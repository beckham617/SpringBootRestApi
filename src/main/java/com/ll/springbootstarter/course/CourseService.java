package com.ll.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		//courseRepository.findByTopicName(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(new Course());
	}
	
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
	
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
