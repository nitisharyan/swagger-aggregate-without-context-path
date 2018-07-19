package com.pearson.sam.organization.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearson.sam.organization.constant.MessageTypeEnum;
import com.pearson.sam.organization.exception.OrganizationUnSupportedException;
import com.pearson.sam.organization.model.Organization;
import com.pearson.sam.organization.model.OrganizationResponse;
import com.pearson.sam.organization.repository.OrganizationRepository;
import com.pearson.sam.organization.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public String getHealthStatus() throws Exception {
		String response = MessageTypeEnum.ORGANIZATION_HEALTH_ERROR.toString();
		try {
			organizationRepository.count();
			response = MessageTypeEnum.ORGANIZATION_HEALTH_OK.toString();
			LOGGER.info(MessageTypeEnum.ORGANIZATION_RESPONSE.toString() + MessageTypeEnum.ORGANIZATION_HEALTH_OK.toString());
		} catch (Exception e) {
			response = MessageTypeEnum.ORGANIZATION_HEALTH_ERROR.toString();
			LOGGER.info(MessageTypeEnum.ORGANIZATION_RESPONSE.toString() + MessageTypeEnum.ORGANIZATION_HEALTH_ERROR.toString());
		}
		return response;
	}

	@Override
	public OrganizationResponse getOrganization(String id) throws Exception {
		Optional<Organization> organizationResponse = null;
		OrganizationResponse response = new OrganizationResponse();
		try {
			organizationResponse = organizationRepository.findById(id);
			if (organizationResponse.isPresent()) {
				response.setOrganization(organizationResponse.get());
				response.setMessage(MessageTypeEnum.ORGANIZATION_RETRIEVED_SUCCESSFULLY.toString());
				response.setStatus(true);
				LOGGER.info(MessageTypeEnum.ORGANIZATION_RESPONSE.toString() + response);
			} else {
				LOGGER.error(MessageTypeEnum.ORGANIZATION_NOT_FOUND.toString());
				throw new OrganizationUnSupportedException(MessageTypeEnum.ORGANIZATION_NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public OrganizationResponse createOrganization(Organization organization) throws Exception {
		Organization organizationResponse = null;
		OrganizationResponse response = new OrganizationResponse();
		try {
			organizationResponse = organizationRepository.save(organization);
			if (organizationResponse != null) {
				response.setOrganization(organizationResponse);
				response.setMessage(MessageTypeEnum.ORGANIZATION_CREATED_SUCCESSFULLY.toString());
				response.setStatus(true);
				LOGGER.info(MessageTypeEnum.ORGANIZATION_RESPONSE.toString() + response);
			} else {
				LOGGER.error(MessageTypeEnum.ORGANIZATION_CREATION_FAILED.toString());
				throw new OrganizationUnSupportedException(MessageTypeEnum.ORGANIZATION_CREATION_FAILED);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public OrganizationResponse updateOrganization(String id, Organization organization) throws Exception {
		Organization organizationResponse = null;
		OrganizationResponse response = new OrganizationResponse();
		try {
			boolean isAvailable = organizationRepository.existsById(id);
			if (isAvailable) {
				organization.setId(id);
				organizationResponse = organizationRepository.save(organization);
				if (organizationResponse != null) {
					response.setOrganization(organizationResponse);
					response.setMessage(MessageTypeEnum.ORGANIZATION_UPDATED_SUCCESSFULLY.toString());
					response.setStatus(true);
					LOGGER.info(MessageTypeEnum.ORGANIZATION_RESPONSE.toString() + response);
				} else {
					LOGGER.error(MessageTypeEnum.ORGANIZATION_UPDATION_FAILED.toString());
					throw new OrganizationUnSupportedException(MessageTypeEnum.ORGANIZATION_UPDATION_FAILED);
				}
			} else {
				LOGGER.error(MessageTypeEnum.ORGANIZATION_NOT_FOUND.toString());
				throw new OrganizationUnSupportedException(MessageTypeEnum.ORGANIZATION_NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return response;
	}
}
