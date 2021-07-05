package com.cjc;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class DemoLog4j {
	static Logger log=Logger.getLogger(DemoLog4j.class.getName());
public static void main(String[]args) throws IOException {
	BasicConfigurator.configure();
	Layout la=new XMLLayout(); 
	Appender ap=new FileAppender(la,"ABC.txt");
	
	log.addAppender(ap);
	log.info("INFOMSG");
	log.debug("DEBUGMSG");
	log.warn("WARNMSG");
	log.error("ERRORMSG");
	log.fatal("FATALMESSG");
	System.out.println("Hello");
	
}
	
}
