package himanshu.starter.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("Spring" , "Spring Framework" , "This is the descition feild"),
			new Topic("Hibernate" , "Hibernate Framework" , "This is the descition feild"),
			new Topic("Collection" , "Collection Framework" , "This is the descition feild")
			));
	public List<Topic> getAllTopics() {
		return topics; 
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic)  {
		topics.add(topic);
	}
	
	public void updateTopic(Topic topic , String id)  {
		for (int i=0 ; i< topics.size() ; i++ ) {
			Topic c = topics.get(i);
			if(c.getId().equals(id)) {
				topics.set(i,topic);
				return;
			}
		}
	}
	
	public void removeTopic(String id)  {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
}
