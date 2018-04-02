package com.test.mongoDb.model;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Version;


@Document(collection="TestData")
public class TestData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private ObjectId id;
	
	private Boolean isValid;
	
	private String strVal;
	
	private Date timeVal;
	
	@Version
	private Integer version;
	
	public TestData() {
		super();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String getStrVal() {
		return strVal;
	}

	public void setStrVal(String strVal) {
		this.strVal = strVal;
	}

	public Date getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(Date timeVal) {
		this.timeVal = timeVal;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
