package net.viralpatel.spring3.controller;
 
import java.util.ArrayList;
import java.util.List;
 
import net.viralpatel.spring3.form.Contact;
import net.viralpatel.spring3.form.ContactForm;
import net.viralpatel.spring3.form.Topic;
import net.viralpatel.spring3.form.TopicForm;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
 
@Controller
public class ContactController {
 
    private static List<Contact> contacts = new ArrayList<Contact>();
  
 
    static {
        contacts.add(new Contact("Barack", "Obama", "barack.o@whitehouse.com", "147-852-965"));
        contacts.add(new Contact("George", "Bush", "george.b@whitehouse.com", "785-985-652"));
        contacts.add(new Contact("Bill", "Clinton", "bill.c@whitehouse.com", "236-587-412"));
        contacts.add(new Contact("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
    }
    
    
   
    
    
    
    
    
    
 
    @RequestMapping(value = "/add_contact.html", method = RequestMethod.GET)
    public ModelAndView get() {
    	
    	
    	
    	
    	
    	
    	
 
        ContactForm contactForm = new ContactForm();
        contactForm.setContacts(contacts);
 
        return new ModelAndView("add_contact" , "contactForm", contactForm);
    }
    
   
    
    
   
 
 
    
    
    
    
 
    @RequestMapping(value = "/show_contact.html", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("contactForm") ContactForm contactForm) {
        System.out.println(contactForm);
        System.out.println(contactForm.getContacts());
        List<Contact> contacts = contactForm.getContacts();
 
        if(null != contacts && contacts.size() > 0) {
            ContactController.contacts = contacts;
            for (Contact contact : contacts) {
                System.out.printf("%s \t %s \n", contact.getFirstname(), contact.getLastname());
            }
        }
 
        return new ModelAndView("show_contact", "contactForm", contactForm);
    }
}