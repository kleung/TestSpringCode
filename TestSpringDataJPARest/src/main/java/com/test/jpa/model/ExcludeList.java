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


/**
 * The persistent class for the exclude_list database table.
 * 
 */
@Entity
@Table(name="exclude_list")
public class ExcludeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="EXCLUDED_SINCE")
	private Date excludedSince;

	@Temporal(TemporalType.DATE)
	@Column(name="EXCLUDED_TILL")
	private Date excludedTill;

	@Column(name="HOST_NAME")
	private String hostName;

	public ExcludeList() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExcludedSince() {
		return this.excludedSince;
	}

	public void setExcludedSince(Date excludedSince) {
		this.excludedSince = excludedSince;
	}

	public Date getExcludedTill() {
		return this.excludedTill;
	}

	public void setExcludedTill(Date excludedTill) {
		this.excludedTill = excludedTill;
	}

	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}