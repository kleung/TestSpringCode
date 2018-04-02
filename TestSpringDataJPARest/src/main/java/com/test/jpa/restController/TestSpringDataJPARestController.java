package com.test.jpa.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.jpa.model.TestData;
import com.test.jpa.service.TestSpringDataJPAService;

@RestController
public class TestSpringDataJPARestController {
	
	@Autowired
	protected TestSpringDataJPAService testSpringDataJPAService;
	
	public TestSpringDataJPARestController() {
		super();
	}

	@RequestMapping(value="/persist", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public TestData persistTestData(@RequestBody TestData data) {
		return this.testSpringDataJPAService.persistTestData(data);
	}
	
	@RequestMapping(value="/TestData/{id}", method=RequestMethod.GET, produces="application/json")
	public TestData findValidTestDataById(@PathVariable Integer id) {
		return this.testSpringDataJPAService.findValidTestDataById(id);
	}
	
	@RequestMapping(value="/TestData/StrVal/{strVal}", method=RequestMethod.GET, produces="application/json")
	public List<TestData> findValidTestDataByStrVal(@PathVariable String strVal) {
		return this.testSpringDataJPAService.findValidTestDataByStrVal(strVal);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public TestData putUpdateTestData(@RequestBody TestData data) {
		return this.testSpringDataJPAService.updateTestData(data);
	}
}
