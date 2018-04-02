package com.test.jpa.quickTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.jpa.model.SiteVisit;

@RestController
@RequestMapping("/SiteVisits")
public class SiteVisitController {
	
	@Autowired
	protected SiteVisitRepository siteVisitRepository;
	
	public SiteVisitController() {
		super();
	}

	public SiteVisitRepository getSiteVisitRepository() {
		return siteVisitRepository;
	}

	public void setSiteVisitRepository(SiteVisitRepository siteVisitRepository) {
		this.siteVisitRepository = siteVisitRepository;
	}
	
	@RequestMapping(value="/distinctDates", method=RequestMethod.GET, produces="application/json")
	public List<String> findDistinctDates() {
		List<String> result = this.siteVisitRepository.findDistinctDate();
		
		return result;
	}
	
	@RequestMapping(value="/siteVisit/{dateStr}", method=RequestMethod.GET, produces="application/json")
	public List<SiteVisit>findSiteVisitByDate(@PathVariable String dateStr) {
		
		
		List<SiteVisit> result = this.siteVisitRepository.findSiteVisitByDate(dateStr, 5);
		
		
		return result;
	}

}
