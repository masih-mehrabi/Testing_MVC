package MVC.controller;

import MVC.model.Course;
import MVC.view.CourseDetailView;
import MVC.view.CourseListViewInterface;

public class Controller {

	private CourseListViewInterface courseListView;

	public void saveCourse(Course course) {
		if (courseListView == null) {
			throw new NullPointerException("courseListView is null");
		}
		courseListView.addCourse(course);
		course.notifyObservers();
	}

	public CourseDetailView selectCourse(Course course) {
		CourseDetailView courseDetailView = new CourseDetailView(this, course);
		courseDetailView.show();
		return courseDetailView;
	}

	public void setCourseListView(CourseListViewInterface courseListView) {
		this.courseListView = courseListView;
	}

}
