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
 * The persistent class for the site_visit database table.
 * 
 */
@Entity
@Table(name="site_visit")
public class SiteVisit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="VISIT")
	private Long visit;

	@Temporal(TemporalType.DATE)
	@Column(name="VISIT_DATE")
	private Date visitDate;

	@Column(name="WEBSITE")
	private String website;

	public SiteVisit() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVisit() {
		return this.visit;
	}

	public void setVisit(Long visit) {
		this.visit = visit;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}