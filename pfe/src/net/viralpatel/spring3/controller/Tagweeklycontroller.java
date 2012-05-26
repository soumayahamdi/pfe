package net.viralpatel.spring3.controller;

import java.util.ArrayList;
import java.util.List;

import net.viralpatel.spring3.form.Topic;
import net.viralpatel.spring3.form.TopicForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Controller
public class Tagweeklycontroller {
private static List<Topic> topics = new ArrayList<Topic>();
	
	int j=0;
	
	
	
	
	
	
	 
	@RequestMapping(value = "/tagcloud.html", method = RequestMethod.GET)
	    public ModelAndView get() {
	    	
	    	
		  int i=0;
			try {
				Twitter twitter = new TwitterFactory().getInstance();
				  List<Trends> trendsList;
				 trendsList =    twitter.getWeeklyTrends(); 
				 System.out.println("size"+trendsList.size());
				  
	            System.out.println("Showing current trends");
	            for (Trends trends : trendsList) { 
	            
	            	i++; 
	            	System.out.println(i + " As of : " + trends.getAsOf()); 
	            	
	              for (twitter4j.Trend trend : trends.getTrends()) { 
	                      System.out.println("num "+j + trend.getName());
	                      j++;
	                      if(j<35){
	                      topics.add(new Topic(trend.getName()));
	                      System.out.println("psss");
	                      }

	              } 
	            	
	              System.out.println("size of topics"+topics.size());
	      } 
	            System.out.println("done.");
	          
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get current trends: " + te.getMessage());
	           
	        
		  
		    
		  
	        }

	    	
	 
			
			
			
			
			 TopicForm topicForm = new TopicForm();
			 topicForm.setTopics(topics);	
			
			
			
			   return new ModelAndView("tagcloud" , "topicForm", topicForm);
    }	

}
