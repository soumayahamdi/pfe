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
public class WeeklyTrendController {
	private static List<Topic> topics = new ArrayList<Topic>();
	
	
	
	
	
	
	
	
	 
	@RequestMapping(value = "/weekly_Trend.html", method = RequestMethod.GET)
	    public ModelAndView get() {
	    	
	    	
		  int i=0;
			try {
				Twitter twitter = new TwitterFactory().getInstance();
				  List<Trends> trendsList;
				 trendsList =    twitter.getWeeklyTrends(); 
				  
	            System.out.println("Showing current trends");
	            for (Trends trends : trendsList) { 
	            
	            	i++; 
	            	System.out.println(i + " As of : " + trends.getAsOf()); 
	              for (twitter4j.Trend trend : trends.getTrends()) { 
	                      System.out.println(" " + trend.getName());
	                      
	                      topics.add(new Topic(trend.getName()));
	                     

	              } 
	      } 
	            System.out.println("done.");
	          
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get current trends: " + te.getMessage());
	           
	        
		  
		    
		  
	        }
	    	
//		  String message = "Hello World, Spring 3.0!";
//	        return new ModelAndView("trend", "message", message);
	    	
	    	
	    	
	 
			
			
			
			
			 TopicForm topicForm = new TopicForm();
			 topicForm.setTopics(topics);	
			
			
			
			   return new ModelAndView("weekly_Trend" , "topicForm", topicForm);
    }	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	       
	 
	        
	    
		
}
