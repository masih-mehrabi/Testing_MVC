package MVC;

import MVC.controller.Controller;
import MVC.model.Course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class should contain only two testcases {@link #testCourseDetailViewUpdate()} and
 * {@link #testCourseUpdateOnSave()}.
 * <p>
 * In this exercise you'll be only using the mocks of the view classes instead of the classes themselves. This will
 * make life way easier for everyone because we want to test the communication between model, view and controller
 * and not if the GUI works correctly.
 */

class UniversityTest {



private CourseListViewMock courseListViewMock;
private CourseDetailViewMock courseDetailViewMock;

private Course course;
private Controller controller;
 
 

@BeforeEach
void setUp() {
	course = new Course("2", "nlp");
	controller = new Controller();
	courseDetailViewMock = new CourseDetailViewMock(controller, course);
	List<Course> courseList = new ArrayList<>();
	courseList.add(course);
	courseListViewMock = new CourseListViewMock(controller, courseList);
}
	
	

	@Test

	void testCourseDetailViewUpdate() {
		course.setId("1");
		course.setName("pse");
		courseDetailViewMock.update();
		assertEquals("1", courseDetailViewMock.getId());
		assertNotEquals("2", courseDetailViewMock.getId());
		assertEquals("pse", courseDetailViewMock.getName());
		assertNotEquals("nlp", courseDetailViewMock.getName());
		
	}

	@Test
	void testCourseUpdateOnSave() {
		courseDetailViewMock.setId("1");
		courseDetailViewMock.setName("pse");
		courseDetailViewMock.save();
		assertEquals("1", course.getId());
		assertNotEquals("2", course.getId());
		assertEquals("pse", course.getName());
		assertNotEquals("nlp", course.getName());
		assertTrue(courseListViewMock.getCourses().contains(course));
	}
}
