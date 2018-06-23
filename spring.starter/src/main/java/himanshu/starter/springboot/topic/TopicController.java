package himanshu.starter.springboot.topic;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService; //needs depency injection
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return  topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return "Saved";
	}
	
	@RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.PUT, value="/topic/{id}")
	public String updateTopic(@RequestBody Topic topic , @PathVariable("id") String id ) {
		topicService.updateTopic(topic , id);
		return "Updated";
	}
	@RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.DELETE, value="/topic/{id}")
	public String removeTopic(@PathVariable String id) {
		topicService.removeTopic(id);
		return "Removed";
	}
}
