package com.ll.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework description"),
			new Topic("java","Core Java","Core Java description"),
			new Topic("javascript","JavaScript","JavaScript Description")
			));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//		for(Topic t : topics) {
//			if(t.getId().equals(id)) {
//				return t;
//			}
//		}
//		return null;
		return topicRepository.findById(id).orElse(new Topic());
	}
	
	public Topic addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
		return topic;
	}
	
	public Topic updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		return topic;
//		for(Topic t : topics) {
//			if(t.getId().equals(id)) {
//				int i = topics.indexOf(t);
//				topics.set(i, topic);
//			}
//		}
//		return topic;
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
//		topics.removeIf(t -> t.getId().equals(id));
	}
}
