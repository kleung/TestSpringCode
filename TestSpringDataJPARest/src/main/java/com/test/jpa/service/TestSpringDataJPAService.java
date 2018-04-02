package com.test.jpa.service;

import java.util.List;

import com.test.jpa.model.TestData;

public interface TestSpringDataJPAService {

	public TestData persistTestData(TestData data);
	
	public void deleteTestData(TestData data);
	
	public List<TestData> findValidTestDataByStrVal(String strVal);
	
	public TestData findValidTestDataById(Integer id);
	
	public TestData updateTestData(TestData data);
}
