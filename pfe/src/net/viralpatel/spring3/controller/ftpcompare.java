package net.viralpatel.spring3.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ftpcompare extends HttpServlet {
	public ftpcompare() {
		
		super();
			}
	protected void doGet(HttpServletRequest request, 
			
			HttpServletResponse response) 
			
			throws ServletException, IOException {
			
			System.out.println("hhhhhhhhhhh");
			
			//getHitCounterImage(request, response);
		
			}
	private void getHitCounterImage(HttpServletRequest request,
			HttpServletResponse response) throws MalformedURLException, IOException {
		BufferedImage buffer = new BufferedImage(50, 20, BufferedImage.TYPE_INT_RGB);
		buffer=ImageIO.read(new URL("http://localhost:8080/HelloWorldSpring3/104.png"));
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(buffer, "png", os);
		
		os.close();
		// TODO Auto-generated method stub
		
	}
	

}
