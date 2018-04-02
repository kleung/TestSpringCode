package com.test.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * The persistent class for the test_data database table.
 * 
 */
@Entity
@Table(name="test_data")
public class TestData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="is_valid")
	private Boolean isValid;

	@Column(name="str_val")
	private String strVal;

	@Column(name="time_val")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeVal;

	@Version
	private Integer version;

	public TestData() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String getStrVal() {
		return this.strVal;
	}

	public void setStrVal(String strVal) {
		this.strVal = strVal;
	}

	public Date getTimeVal() {
		return this.timeVal;
	}

	public void setTimeVal(Date timeVal) {
		this.timeVal = timeVal;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}