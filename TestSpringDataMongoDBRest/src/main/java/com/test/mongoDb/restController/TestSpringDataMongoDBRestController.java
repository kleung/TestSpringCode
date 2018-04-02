package com.test.mongoDb.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.mongoDb.model.TestData;
import com.test.mongoDb.service.TestDataService;

@RestController
public class TestSpringDataMongoDBRestController {
	
	@Autowired
	protected TestDataService testDataService;
	
	public TestSpringDataMongoDBRestController() {
		super();
	}
	
	@RequestMapping(value="/persist", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public TestData persist(@RequestBody TestData testData) {
		
		return this.testDataService.persist(testData);

	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public TestData update(@RequestBody TestData testData) {
		
		return this.testDataService.update(testData);

	}
	
	@RequestMapping(value="/TestData/{strVal}", method=RequestMethod.GET, produces="application/json")
	public List<TestData>findValidTestDataByStrVal(@PathVariable String strVal) {
		
		return this.testDataService.findValidTestDataByStrVal(strVal);
		
	}

}
