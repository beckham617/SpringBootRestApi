package com.ll.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public List<Topic> getAllTopics() {
		
		return topicService.getAllTopics();
		
	}
	
	@RequestMapping(value="/topics/{id}",method=RequestMethod.GET)
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		return topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
