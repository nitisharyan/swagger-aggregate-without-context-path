package com.pearson.sam.organization.service;

import org.springframework.stereotype.Service;

import com.pearson.sam.organization.model.Organization;
import com.pearson.sam.organization.model.OrganizationResponse;

@Service
public interface OrganizationService {
	
	String getHealthStatus() throws Exception;

	OrganizationResponse getOrganization(String id) throws Exception;

	OrganizationResponse createOrganization(Organization organization) throws Exception;

	OrganizationResponse updateOrganization(String id, Organization organization) throws Exception;
}
