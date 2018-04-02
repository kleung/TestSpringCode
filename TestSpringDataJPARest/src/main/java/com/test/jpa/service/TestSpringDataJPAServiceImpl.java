package com.test.jpa.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.jpa.model.TestData;
import com.test.jpa.repositories.TestDataRepository;

@Service
public class TestSpringDataJPAServiceImpl implements TestSpringDataJPAService {
	
	protected static Logger log = Logger.getLogger(TestSpringDataJPAServiceImpl.class);
	
	@Autowired
	protected TestDataRepository testDataRepository;
	
	public TestSpringDataJPAServiceImpl() {
		super();
	}
	
	@Override
	@Transactional
	public TestData persistTestData(TestData data) {
		log.info("persistTestData() - data: " + data);
		
		this.testDataRepository.save(data);
		
		return data;
	}
	
	@Override
	@Transactional
	public void deleteTestData(TestData data) {
		log.info("deleteTestData() - data: " + data);
		
		this.testDataRepository.delete(data);
	}
	
	@Override
	public List<TestData> findValidTestDataByStrVal(String strVal) {
		log.info("findValidTestDataByStrVal() - strVal: " + strVal);
		
		List<TestData> result = this.testDataRepository.findByStrValAndIsValidOrderById(strVal, Boolean.TRUE);
		log.info("findValidTestDataByStrVal() - result: " + result);
		
		return result;
	}
	
	@Override
	public TestData findValidTestDataById(Integer id) {
		log.info("findValidTestDataById() - id: " + id);
		
		TestData result = this.testDataRepository.findByIdAndIsValid(id, Boolean.TRUE);
		log.info("findValidTestDataById() - result: " + result);
		
		return result;
	}
	
	@Override
	@Transactional
	public TestData updateTestData(TestData data) {
		log.info("updateTestData() - data: " + data);
		TestData target = this.testDataRepository.findByIdAndIsValid(data.getId(), Boolean.TRUE);
		
		if(target == null) {
			throw new EntityNotFoundException("Target data not found.");
		}
		
		String updatedStrVal = data.getStrVal();
		if(updatedStrVal != null)
			target.setStrVal(updatedStrVal);
		
		Date updatedTimeVal = target.getTimeVal();
		if(updatedTimeVal != null)
			target.setTimeVal(updatedTimeVal);
		
		this.testDataRepository.save(target);
		
		return target;
	}
	
}
