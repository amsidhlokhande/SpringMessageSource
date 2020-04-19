package com.amsidh.spring.tutorial;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {

	@Autowired
	@Resource(name="pointC")
	private Point centerPoint;

	@Autowired
	private MessageSource messageSource;
	
	
	public Point getCenterPoint() {
		return centerPoint;
	}
	

	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	

	public MessageSource getMessageSource() {
		return messageSource;
	}


	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	@Override
	public void draw() {
		//System.out.println("Circle center point (" + centerPoint.getX() + " , "	+ centerPoint.getY() + " )");
		System.out.println(messageSource.getMessage("circle.message", new Object[]{centerPoint.getX(),centerPoint.getY()}, "No Circle Info message available",Locale.US));
        System.out.println(messageSource.getMessage("hello.message", null, "Default Hello Message",Locale.US)); 
	}

	@PostConstruct
	public void initCircle()
	{
		System.out.println("Init Circle is callled");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy Circle caledd");
	}
	
}
