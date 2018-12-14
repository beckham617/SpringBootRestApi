package com.ll.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ll.springbootstarter.topic.Topic;

public interface CourseRepository extends CrudRepository<Course, String>{

	public List<Course> findByName(String name);
	public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(String topicId);
	
	public List<Course> findByTopicName(String topicName);
	
}
