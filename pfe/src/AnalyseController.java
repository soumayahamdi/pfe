import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import rcaller.RCaller;
import rcaller.RCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;



import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.corba.se.pept.transport.Connection;



@Controller

public class AnalyseController {

	@RequestMapping(value="/NewFile")
	public ModelAndView hi(Model model,HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException { 
		
		System.out.println( "Geee1!");
		try{
		RCaller caller = new RCaller();
		caller.setRscriptExecutable("C:\\Program Files\\R\\R-2.14.2\\bin\\Rscript.exe");
		RCode code = new RCode();
		code.clear();
		code.addRCode("library(twitteR)");
		code.addRCode("hilton.tweets=searchTwitter('@obama',n=100)");
		code.addRCode("length(hilton.tweets)");
		code.addRCode("tweet=hilton.tweets[[1]]");
		code.addRCode("class(tweet)"); 
		code.addRCode("tweet$getScreenName()");
		code.addRCode("tweet$getText()");
		code.addRCode("library(\"plyr\")");
		code.addRCode("hilton.text=laply(hilton.tweets,function(t)t$getText())");
		code.addRCode("length(hilton.text)");
		code.addRCode("head(hilton.text,5)");
		code.addRCode("hu.liu.pos=scan('C:\\\\Documents and Settings\\\\zied\\\\Bureau\\\\positive-words.txt',what='character',comment.char=';')");
		code.addRCode("hu.liu.neg=scan('C:\\\\Documents and Settings\\\\zied\\\\Bureau\\\\negative-words.txt',what='character',comment.char=';')");
		code.addRCode(" pos.words=c(hu.liu.pos,'upgrade') ");
		code.addRCode("  neg.words=c(hu.liu.neg,'wtf','wait','waiting','epicfail','mechanical')");
		code.addRCode("  sample=c(\"You'reawesomeandIloveyou\",\"Ihateandhateandhate.Soangry.Die!\",\"Impressedandamazed:youarepeerlessinyourachievementofunparalleledmediocrity.\")");
		code.addRCode("score.sentiment = function(sentences, pos.words, neg.words, .progress='none')");
		code.addRCode("{");
		code.addRCode("require(plyr)");
		code.addRCode("require(stringr)");
		code.addRCode("scores = laply(sentences, function(sentence, pos.words, neg.words) {");
		code.addRCode("sentence = gsub('[[:punct:]]', '', sentence)");
		code.addRCode("sentence = gsub('[[:cntrl:]]', '', sentence)");
		code.addRCode("sentence = gsub('\\d+', '', sentence)");
		code.addRCode("sentence = tolower(sentence)");
		code.addRCode("word.list = str_split(sentence, '\\s+')");
		code.addRCode("words = unlist(word.list)");
		code.addRCode("pos.matches = match(words, pos.words)");
		code.addRCode("neg.matches = match(words, neg.words)");
		code.addRCode("pos.matches = !is.na(pos.matches))");
		code.addRCode("neg.matches = !is.na(neg.matches)");
		code.addRCode("score = sum(pos.matches) - sum(neg.matches)");
		code.addRCode("return(score)");
		code.addRCode("}, pos.words, neg.words, .progress=.progress )");
		code.addRCode("return(score)");
		code.addRCode("scores.df = data.frame(score=scores, text=sentences)");
		code.addRCode("return(scores.df)");
		code.addRCode("}");
		code.addRCode("result=score.sentiment(sample,pos.words,neg.words)");
		code.addRCode("class(result)");
		code.addRCode("result$score");
		code.addRCode("hilton.scores=score.sentiment(hilton.text,pos.words,neg.words,.progress='text')");
		code.addRCode("hilton.scores$hotel='Hilton'");
		code.addRCode("hilton.scores$code='HL'");
		code.addRCode("hilton.scores$score");
		code.addRCode("hilton.scores$very.pos=as.numeric(hilton.scores$score>0)");
		code.addRCode("hilton.scores$very.neg=as.numeric(hilton.scores$score<0)");
		code.addRCode("pos.count=sum(hilton.scores$very.pos)");
		code.addRCode("pos.neg=sum(as.numeric(hilton.scores$score<0))");
		code.addRCode("pos.count");
		code.addRCode("pos.neg");
		code.addRCode("setwd(\"E:/workspace/hell/WebContent\")");
		code.addRCode("library(plotrix)");
		code.addRCode("neut=150-pos.count-pos.neg");
		code.addRCode("slices =c(pos.neg, pos.count,neut)" );
		code.addRCode("lbls =c(\"Negative\", \"Positive\",\"neutre\")");
		code.addRCode("pct = round(slices/sum(slices)*100)");
		code.addRCode("lbls = paste(lbls, pct)");
		code.addRCode("lbls = paste(lbls,\"%\",sep=\"\")");
		code.addRCode("setwd(\"E:/workspace/hell/WebContent\")");
		code.addRCode("png('tes8.png', width=600,height=600)");
		 System.out.println( "Geee!");
		code.addRCode("pie3D(slices,labels=lbls,explode=0.1, main=\"Pie Chart of Countries \",col=rainbow(length(lbls),labelcex=2,theta=pi/5))");
		 code.addRCode("dev.off()");
		 caller.setRCode(code);
		

			caller.runOnly();
		
		
		} catch (Exception e) {
			System.out.println(e.toString());
			}
		File f=new File("E:/workspace/hell/WebContent/word108.png");
		BufferedImage buffer = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);

		if( f.exists() ) {
			 buffer= ImageIO.read( f );
		} else {
		    System.out.println( "Geee! I specified the wrong path to the image file!" );
		}
       
      
		
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(buffer, "png", os);
        os.close();		
		
		
        return new ModelAndView("helloworld", "tweets","tweets");}

	}
	
	
