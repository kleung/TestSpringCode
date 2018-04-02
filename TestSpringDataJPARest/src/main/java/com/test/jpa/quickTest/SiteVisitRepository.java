package com.test.jpa.quickTest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.jpa.model.SiteVisit;

public interface SiteVisitRepository extends JpaRepository<SiteVisit, Long> {

	@Query(value="SELECT DATE_FORMAT(distinctDates.dates, '%Y-%m-%d') AS dateStrings " +
				 "FROM (SELECT DISTINCT VISIT_DATE AS dates " +
				 	   "FROM SITE_VISIT) distinctDates " +
				 "ORDER BY dateStrings DESC", nativeQuery=true)
	public List<String> findDistinctDate();	
	
	@Query(value="SELECT siteVisit.* " +
				 "FROM SITE_VISIT siteVisit " +
				 "WHERE siteVisit.ID NOT IN (SELECT excludedSiteVisit.ID " +
				 							"FROM SITE_VISIT excludedSiteVisit " +
				 							"INNER JOIN (SELECT CONCAT('%', HOST_NAME, '%') AS hostname " +
				 										"FROM EXCLUDE_LIST " +
				 										"WHERE ((EXCLUDED_SINCE IS NULL) AND (EXCLUDED_TILL IS NULL)) " +
				 										"OR ((EXCLUDED_SINCE <= STR_TO_DATE(:searchDate, '%Y-%m-%d')) AND (EXCLUDED_TILL IS NULL)) " +
				 										"OR ((EXCLUDED_SINCE IS NULL) AND (EXCLUDED_TILL >= STR_TO_DATE(:searchDate, '%Y-%m-%d'))) " +
				 										"OR ((EXCLUDED_SINCE <= STR_TO_DATE(:searchDate, '%Y-%m-%d')) AND (EXCLUDED_TILL >= STR_TO_DATE(:searchDate, '%Y-%m-%d')))) excludedHostNameList " +
				 							"ON ((excludedSiteVisit.VISIT_DATE = STR_TO_DATE(:searchDate, '%Y-%m-%d')) AND (excludedSiteVisit.WEBSITE LIKE excludedHostNameList.HOSTNAME))) " +
				 "AND siteVisit.VISIT_DATE = STR_TO_DATE(:searchDate, '%Y-%m-%d') " +
				 "ORDER BY siteVisit.VISIT DESC " +
				 "LIMIT :limitRecordCount",
		   nativeQuery=true)
	public List<SiteVisit> findSiteVisitByDate(@Param("searchDate")String searchDate, 
											   @Param("limitRecordCount")int limitRecordCount);
	
}
