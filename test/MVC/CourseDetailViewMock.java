package MVC;

import MVC.controller.Controller;
import MVC.model.Course;
import MVC.view.CourseDetailView;
import MVC.view.CourseDetailViewInterface;

/**
 * This class is responsible for representing {@link CourseDetailView} in a way that makes it
 * easier to test by removing the UI elements.
 * Keep in mind that this is <b>not</b> suitable for actual testing since we are technically testing the mock instead
 * of the actual implementation even though it works the same way.
 *
 * @see #id represents {@link CourseDetailView#idTextField}
 * @see #name represents {@link CourseDetailView#nameTextField}
 */
public class CourseDetailViewMock implements CourseDetailViewInterface {
	private String id;
	private String name;

	private Controller controller;
	private Course course;

	public CourseDetailViewMock(Controller controller, Course course) {
		this.controller = controller;
		this.course = course;
		course.addObserver(this);

		this.id = course.getId();
		this.name = course.getName();
	}

	@Override
	public void update() {
		this.id = course.getId();
		this.name = course.getName();
	}

	@Override
	public void save() {
		course.setId(id);
		course.setName(name);
		controller.saveCourse(course);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
