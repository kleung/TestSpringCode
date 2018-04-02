package com.test.mongoDb.service;

import com.test.mongoDb.model.TestData;

import java.util.List;

public interface TestDataService {
	
	public TestData persist(TestData testData);
	
	public TestData update(TestData testData);
	
	public List<TestData> findAllValidTestData();
	
	public List<TestData> findValidTestDataByStrVal(String strVal);
}
