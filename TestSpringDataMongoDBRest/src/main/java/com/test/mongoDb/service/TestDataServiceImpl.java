package com.test.mongoDb.service;

import java.util.List;

import com.test.mongoDb.model.TestData;
import com.test.mongoDb.repositories.QueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataServiceImpl implements TestDataService {
	
	@Autowired
	protected QueryRepository queryRepository;
	
	public TestDataServiceImpl() {
		super();
	}

	@Override
	public TestData persist(TestData testData) {
		this.queryRepository.save(testData);
		
		return testData;
	}

	@Override
	public TestData update(TestData testData) {
		this.queryRepository.save(testData);
		
		return testData;
	}

	@Override
	public List<TestData> findAllValidTestData() {
		List<TestData> result = this.queryRepository.findValidTestData();
		
		return result;
	}

	@Override
	public List<TestData> findValidTestDataByStrVal(String strVal) {
		List<TestData> result = this.queryRepository.findByStrValIsValid(strVal, Boolean.TRUE);
		
		return result;
	}

}
