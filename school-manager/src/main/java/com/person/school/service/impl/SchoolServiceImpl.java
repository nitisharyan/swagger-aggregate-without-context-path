package com.person.school.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.school.constant.MessageTypeEnum;
import com.person.school.exception.SchoolUnSupportedException;
import com.person.school.model.School;
import com.person.school.model.SchoolResponse;
import com.person.school.repository.SchoolRepository;
import com.person.school.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolServiceImpl.class);

	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public String getHealthStatus() throws Exception {
		String response = MessageTypeEnum.SCHOOL_HEALTH_ERROR.toString();
		try {
			schoolRepository.count();
			response = MessageTypeEnum.SCHOOL_HEALTH_OK.toString();
			LOGGER.info(MessageTypeEnum.SCHOOL_RESPONSE.toString() + MessageTypeEnum.SCHOOL_HEALTH_OK.toString());
		} catch (Exception e) {
			response = MessageTypeEnum.SCHOOL_HEALTH_ERROR.toString();
			LOGGER.info(MessageTypeEnum.SCHOOL_RESPONSE.toString() + MessageTypeEnum.SCHOOL_HEALTH_ERROR.toString());
		}
		return response;
	}

	@Override
	public SchoolResponse getSchool(String id) throws Exception {
		Optional<School> schoolResponse = null;
		SchoolResponse response = new SchoolResponse();
		try {
			schoolResponse = schoolRepository.findById(id);
			if (schoolResponse.isPresent()) {
				response.setSchool(schoolResponse.get());
				response.setMessage(MessageTypeEnum.SCHOOL_RETRIEVED_SUCCESSFULLY.toString());
				response.setStatus(true);
				LOGGER.info(MessageTypeEnum.SCHOOL_RESPONSE.toString() + response);
			} else {
				LOGGER.error(MessageTypeEnum.SCHOOL_NOT_FOUND.toString());
				throw new SchoolUnSupportedException(MessageTypeEnum.SCHOOL_NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public SchoolResponse createSchool(School school) throws Exception {
		School schoolResponse = null;
		SchoolResponse response = new SchoolResponse();
		try {
			schoolResponse = schoolRepository.save(school);
			if (schoolResponse != null) {
				response.setSchool(schoolResponse);
				response.setMessage(MessageTypeEnum.SCHOOL_CREATED_SUCCESSFULLY.toString());
				response.setStatus(true);
				LOGGER.info(MessageTypeEnum.SCHOOL_RESPONSE.toString() + response);
			} else {
				LOGGER.error(MessageTypeEnum.SCHOOL_CREATION_FAILED.toString());
				throw new SchoolUnSupportedException(MessageTypeEnum.SCHOOL_CREATION_FAILED);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public SchoolResponse updateSchool(String id, School school) throws Exception {
		School schoolResponse = null;
		SchoolResponse response = new SchoolResponse();
		try {
			boolean isAvailable = schoolRepository.existsById(id);
			if (isAvailable) {
				school.setId(id);
				schoolResponse = schoolRepository.save(school);
				if (schoolResponse != null) {
					response.setSchool(schoolResponse);
					response.setMessage(MessageTypeEnum.SCHOOL_UPDATED_SUCCESSFULLY.toString());
					response.setStatus(true);
					LOGGER.info(MessageTypeEnum.SCHOOL_RESPONSE.toString() + response);
				} else {
					LOGGER.error(MessageTypeEnum.SCHOOL_UPDATION_FAILED.toString());
					throw new SchoolUnSupportedException(MessageTypeEnum.SCHOOL_UPDATION_FAILED);
				}
			} else {
				LOGGER.error(MessageTypeEnum.SCHOOL_NOT_FOUND.toString());
				throw new SchoolUnSupportedException(MessageTypeEnum.SCHOOL_NOT_FOUND);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return response;
	}
}
