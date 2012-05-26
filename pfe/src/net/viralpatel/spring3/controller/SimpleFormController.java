package net.viralpatel.spring3.controller;




import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import  net.viralpatel.spring3.form.MyTweet;
import  net.viralpatel.spring3.form.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import rcaller.RCaller;
import rcaller.RCode;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

@Controller

public class SimpleFormController 
{
   
 	User user;
	 private static List<MyTweet> tweets = new ArrayList<MyTweet>();
	 private static List<Tweet> ltweets = new ArrayList<Tweet>();
	 

	

	 
	 
	 
	 @RequestMapping(value="/index1" )  
	 public ModelAndView index (Model model,HttpServletRequest request, HttpServletResponse response )
	 		throws ServletException, IOException {
	 	
	 return new ModelAndView("index1", "message","message");
	 }	
	 @RequestMapping(value="/index2" )  
	 public ModelAndView index2 (Model model,HttpServletRequest request, HttpServletResponse response )
	 		throws ServletException, IOException {
	 	
	 return new ModelAndView("index2", "message","message");
	 }	
	 @RequestMapping(value="/Search_by_area" )  
	 public ModelAndView serch (Model model,HttpServletRequest request, HttpServletResponse response )
	 		throws ServletException, IOException {
	 	
	 return new ModelAndView("Search_by_area", "message","message");
	 }	
	 @RequestMapping(value="/Trending_Topics" )  
	 public ModelAndView Trending_Topics(Model model,HttpServletRequest request, HttpServletResponse response )
		 		throws ServletException, IOException {
		 	
		 return new ModelAndView("Trending_Topics", "message","message");
		 }	

	 
	 
	 @RequestMapping(value="/Track_profiles" )  
		 public ModelAndView Track_profilesh (Model model,HttpServletRequest request, HttpServletResponse response )
			 		throws ServletException, IOException {
			 	
			 return new ModelAndView("Track_profiles", "message","message");
			 }	
	 
	 @RequestMapping(value="/compare" )  
			 public ModelAndView compare (Model model,HttpServletRequest request, HttpServletResponse response )
				 		throws ServletException, IOException {
				 	
				 return new ModelAndView("compare", "message","message");
				 }	 
	 
	 @RequestMapping(value="/NewFile" )  
				 public ModelAndView NewFile(Model model,HttpServletRequest request, HttpServletResponse response )
					 		throws ServletException, IOException {
					 	
					 return new ModelAndView("NewFile", "message","message");
					 }
	 @RequestMapping(value="/home",method=RequestMethod.POST)
public ModelAndView helloWordd1(@RequestParam("search") String query,Model model,HttpServletRequest request)
		throws ServletException, IOException {
System.out.println(query);

	 request.getSession().setAttribute("SESSION_ATTRIBUTE", query);
    

		
	return new ModelAndView("home", "location","/images/word102.png");
	}

@RequestMapping(value="/formoutput" )  
public ModelAndView helloWordd(Model model,HttpServletRequest request){
	
	
	

	String b=(String)request.getSession().getAttribute("SESSION_ATTRIBUTE");
Twitter twitter = new TwitterFactory().getInstance();
Query rs=new Query(b);
 System.out.println("ahla");
 rs.setRpp(400);
 QueryResult result1 = null;
 try {
	result1 = twitter.search(rs);
} catch (TwitterException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
 tweets.clear();
for (Tweet tweet : result1.getTweets()) 	     {
GeoLocation loc=tweet.getGeoLocation();	 
if (loc!= null) 
     	{int x=10;String r="ahla";

   
	   tweets.add(new MyTweet(tweet.getText(),tweet.getText(),loc.getLongitude(),loc.getLatitude()));   
               		      System.out.println("text"+tweet.getText())      ;   
    	}

}
model.addAttribute("tweets",tweets);
	      return new ModelAndView("formoutput", "message","message");
   

}
@RequestMapping(value="/cc",method=RequestMethod.POST)
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	String b=(String) req.getSession().getAttribute("SESSION_ATTRIBUTE");
    resp.setContentType("text/html");
  
    //Twits tweets = new Twits();
    Twitter twitter = new TwitterFactory().getInstance();
    //twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    Query rs = new Query(b);
    QueryResult result = null;
   
    try {
        result = twitter.search(rs);
    } catch (TwitterException e) {
        e.printStackTrace();
    }
    for (Tweet tweet : result.getTweets()) {
    	
        resp.getWriter().println("<img src='"+tweet.getProfileImageUrl().toString()+"'/>" +":"+ tweet.getFromUser() + ":" + tweet.getText() + "  <br/>");
        
    }
}

@RequestMapping(value="/home" )  
public ModelAndView searchtweett (Model model,HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {
	
	
	Twitter twitter = new TwitterFactory().getInstance();

	  AccessToken token = new AccessToken("522839769-uyMIF6Gv9NOYEH131ruLwrX3WLUGZJ3XeLIW5r4C", "hpLpyg0xioPphUGcL5ZqmXYy06dUbTS6inMrcxYfBNQ");
	  twitter.setOAuthConsumer("t9ajqoXSsedAAPNPBPolQ", "Zj2eoHl3L6UrAwW3QVY3IiBAhbV0khg0NcUGlB8N4");
		twitter.setOAuthAccessToken(token); 
	 
	 ConfigurationBuilder conf1;

	
return new ModelAndView("home", "message","message");
}
@RequestMapping(value="/fff.png")
void hi(Model model,HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException {  
	
	String b=(String) request.getSession().getAttribute("SESSION_ATTRIBUTE");
	System.out.println("finaaaalllllllllllllllll");

	try {

		RCaller caller = new RCaller();

		/*
		* This must be caller.setRScriptExecutable() instead.
		*/
		caller.setRscriptExecutable("C:\\Program Files\\R\\R-2.14.2\\bin\\Rscript.exe");

		/*
		* After version 2.0.6
		* Graphics themes change the theme for plots.
		* Themes:
		* BlackTheme
		* SkyTheme
		* DefaultTheme
		*/

		
		/*
		* After version 2.0.6
		* We build the code using RCode class. Older
		* methods are deprecated and will no longer will be
		* available in RCaller 3.0
		*/
		RCode code = new RCode();
		code.clear();
		/*double[] numbers = new double[]{1, 4, 3, 5, 6, 10};

		code.addDoubleArray("x", numbers);*/

		/*File file = code.startPlot();
		code.addRCode("plot.ts(x)");
		code.endPlot();

		/*
		* After version 2.0.6
		* We set the code.setwd("C:/data")

		*/



		code.addRCode("require(twitteR)");
		code.addRCode("searchTerm = '#"+b+"'");
		code.addRCode("rdmTweets <- searchTwitter(searchTerm, n=100)");
		System.out.println("ahla");
		code.addRCode("tw.df=twListToDF(rdmTweets)");
		code.addRCode("RemoveAtPeople <- function(tweet) {gsub(\"@\\\\w+\", \"\", tweet)}");
		code.addRCode("tweets <- as.vector(sapply(tw.df$text, RemoveAtPeople))");
		code.addRCode("require(tm)");
		System.out.println("ahla");
		code.addRCode("generateCorpus= function(df,my.stopwords=c()){");
		code.addRCode("tw.corpus= Corpus(VectorSource(df))");
		code.addRCode("tw.corpus = tm_map(tw.corpus, removePunctuation)");
		code.addRCode("tw.corpus = tm_map(tw.corpus, tolower)");
		code.addRCode("tw.corpus = tm_map(tw.corpus, removeWords, stopwords('english'))");
		code.addRCode("tw.corpus = tm_map(tw.corpus, removeWords, my.stopwords)");
		code.addRCode("tw.corpus }");
		code.addRCode("wordcloud.generate=function(corpus,min.freq=3){");
		code.addRCode("require(wordcloud)");
		code.addRCode("doc.m = TermDocumentMatrix(corpus, control = list(minWordLength = 1))");
		code.addRCode("dm = as.matrix(doc.m)");
		code.addRCode("v = sort(rowSums(dm), decreasing=TRUE)");
		code.addRCode("d = data.frame(word=names(v), freq=v)");
		code.addRCode("wc=wordcloud(d$word, d$freq, min.freq=min.freq)");
		code.addRCode("wc }");
		System.out.println("ahla");
	
		code.addRCode("setwd(\"C:/Users/Na3im/Desktop/f/versionfff/WebContent/images\")");
		code.addRCode("print(wordcloud.generate(generateCorpus(tweets,'"+b+"'),5))");
		System.out.println("ahla");
		code.addRCode("setwd(\"C:/Users/Na3im/Desktop/f/versionfff/WebContent/images\")");
		code.addRCode("png('word101.png', width=600,height=600)");
		code.addRCode("setwd(\"C:/Users/Na3im/Desktop/f/versionfff/WebContent/images\")");
		code.addRCode("wordcloud.generate(generateCorpus(tweets,'"+b+"'),5)");
	    code.addRCode("dev.off()");
		caller.setRCode(code);
		

		caller.runOnly();
		
		/*System.out.println(file.getAbsolutePath());

		/*ImageIcon ii = code.getPlot(file);*/
		System.out.println("ahla");
		} catch (Exception e) {
		System.out.println(e.toString());
		}
	
BufferedImage buffer = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
	File f=new File("C:/Users/Na3im/Desktop/f/versionfff/WebContent/images/word101.png");
	if( f.exists() ) {
		 buffer= ImageIO.read( f );
	} else {
	    System.out.println( "Geeelo! I specified the wrong path to the image file!" );
	}
   
  
	
    response.setContentType("image/png");
    OutputStream os = response.getOutputStream();
    ImageIO.write(buffer, "png", os);
    os.close();
	//String b=(String)request.getSession().getAttribute("SESSION_ATTRIBUTE");
}



}