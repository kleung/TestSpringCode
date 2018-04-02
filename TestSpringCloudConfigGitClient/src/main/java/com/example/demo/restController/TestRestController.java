package com.example.demo.restController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping(value="/TestRestController")
public class TestRestController {
	
	@Value("${test.message}")
	protected String testMessage1;
	
	@Value("${test.message2}")
	protected String testMessage2;
	
	public TestRestController() {
		super();
	}

	@RequestMapping(value="/getTestMessage1")
	public String getTestMessage1() {
		return this.testMessage1;
	}
	
	@RequestMapping(value="/getTestMessage2")
	public String getTestMessage2() {
		return this.testMessage2;
	}
	
	
}
