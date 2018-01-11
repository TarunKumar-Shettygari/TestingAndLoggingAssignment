package com.accolite.au.FizzBuzz_Logging;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


public class FizzBuzzTest {
	static Logger logger;
	
	FizzBuzz fizzBuzz;
	
	@Before
	public void setUp() {
		logger=Logger.getLogger(FizzBuzz.class);
		BasicConfigurator.configure();
		fizzBuzz=new FizzBuzz();
	}
	
	
	@Test()
	public void testZeroInput() {
		logger.info("Testing zero input");
		try {
			List<String> actual=fizzBuzz.play(0);
			assertEquals(0,actual.size());
		}
		catch(Exception e) {
			logger.error("Test with zero input failed");
		}
		
	}
	
	@Test()
	public void testNegetiveInput() {
		logger.info("Testing negetive input");
		try {
			List<String> actual=fizzBuzz.play(-8);
			assertEquals(0,actual.size());
		}
		catch(Exception e) {
			logger.error("Test with negetive input failed");
		}
		
	}
	
	@Test(timeout=1000)
	public void testSmallPositiveInput() {
		logger.info("Testing small positive input");
		try {
			List<String> expected=Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz");
			List<String> actual=fizzBuzz.play(10);
			assertEquals(expected,actual);
		}
		catch(Exception e) {
			logger.error("Test with small positive input failed");
		}
	}
	
	@Test(timeout=1000)
	public void testLargePositiveInput() {
		logger.info("Testing large positive input");
		try {
			List<String> actual=fizzBuzz.play(100);
			assertEquals(100,actual.size());
			assertEquals(6,Collections.frequency(actual, "FizzBuzz"));
			assertEquals(27,Collections.frequency(actual, "Fizz"));
			assertEquals(14,Collections.frequency(actual, "Buzz"));
		}
		catch(Exception e) {
			logger.error("Test with large positive input failed");
		}
		
	}
	
	
	@AfterClass		
	public static void afterFizzBuzzClass() {
		logger.info("Testing done");
	}
	
	
}
