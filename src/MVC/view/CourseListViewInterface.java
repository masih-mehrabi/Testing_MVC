package MVC.view;

import MVC.model.Course;

import java.util.List;

public interface CourseListViewInterface extends Observer {
	void selectCourse(Course course);

	void createCourse();

	void addCourse(Course course);

	List<Course> getCourses();
}

