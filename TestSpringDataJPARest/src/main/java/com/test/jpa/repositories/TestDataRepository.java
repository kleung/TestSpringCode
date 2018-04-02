package com.test.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.jpa.model.TestData;

public interface TestDataRepository extends CrudRepository<TestData, Integer> {
	
	public List<TestData> findByStrValAndIsValidOrderById(String strVal, Boolean isValid);
	
	@Query("select d from TestData d where d.id = ?1 and d.isValid = ?2")
	public TestData findByIdAndIsValid(Integer id, Boolean isValid);

}
