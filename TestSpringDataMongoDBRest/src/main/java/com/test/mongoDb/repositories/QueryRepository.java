package com.test.mongoDb.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.test.mongoDb.model.TestData;

public interface QueryRepository extends MongoRepository<TestData, ObjectId> {
	
	@Query("{strVal:'?0', isValid: ?1}")
	public List<TestData> findByStrValIsValid(String strVal, Boolean isValid);
	
	@Query("{isValid: true}")
	public List<TestData> findValidTestData();

}
