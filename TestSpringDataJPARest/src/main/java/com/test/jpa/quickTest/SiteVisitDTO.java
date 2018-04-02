package com.test.jpa.quickTest;

import java.io.Serializable;
import java.util.Date;

public class SiteVisitDTO implements Serializable {
	
	private static final long serialVersionUID = -8447213132790019921L;

	protected Long visit;
	
	protected String website;
	
	protected Date visitDate;
	
	public SiteVisitDTO(Long visit, 
							String website, 
							Date visitDate) {
		super();
		
		this.visit = visit;
		this.website = website;
		this.visitDate = visitDate;
	}

	public Long getVisit() {
		return visit;
	}

	public void setVisit(Long visit) {
		this.visit = visit;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

}
