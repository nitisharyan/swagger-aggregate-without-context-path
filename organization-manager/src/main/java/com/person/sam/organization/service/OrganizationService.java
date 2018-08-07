package com.person.sam.organization.service;

import org.springframework.stereotype.Service;

import com.person.sam.organization.model.Organization;
import com.person.sam.organization.model.OrganizationResponse;

@Service
public interface OrganizationService {
	
	String getHealthStatus() throws Exception;

	OrganizationResponse getOrganization(String id) throws Exception;

	OrganizationResponse createOrganization(Organization organization) throws Exception;

	OrganizationResponse updateOrganization(String id, Organization organization) throws Exception;
}
