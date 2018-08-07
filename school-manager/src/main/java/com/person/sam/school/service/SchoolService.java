package com.person.sam.school.service;

import org.springframework.stereotype.Service;

import com.person.sam.school.model.School;
import com.person.sam.school.model.SchoolResponse;

@Service
public interface SchoolService {
	
	String getHealthStatus() throws Exception;

	SchoolResponse getSchool(String id) throws Exception;

	SchoolResponse createSchool(School school) throws Exception;

	SchoolResponse updateSchool(String id, School school) throws Exception;

}
