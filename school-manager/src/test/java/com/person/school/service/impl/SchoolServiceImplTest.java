package com.person.school.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.person.school.constant.MessageTypeEnum;
import com.person.school.model.School;
import com.person.school.model.SchoolResponse;
import com.person.school.repository.SchoolRepository;
import com.person.school.service.impl.SchoolServiceImpl;

@RunWith(SpringRunner.class)
public class SchoolServiceImplTest {

	@InjectMocks
	SchoolServiceImpl schoolServiceImpl;

	@Mock
	SchoolRepository schoolRepositoryMock;

	private School school;

	@Before
	public void setup() {
		school = new School();
		school.setId("222222222222");
		school.setName("St. Johns");
	}
	
	@Test
	public void getHealthStatus() throws Exception {
		Mockito.when(schoolRepositoryMock.count()).thenReturn(new Long(1));
		String schoolGetHealthResponse = schoolServiceImpl.getHealthStatus();
		assertEquals(MessageTypeEnum.SCHOOL_HEALTH_OK.toString(), schoolGetHealthResponse);
	}

	@Test
	public void getSchool() throws Exception {
		Optional<School> schoolResponse = Optional.of(school);
		Mockito.when(schoolRepositoryMock.findById(Mockito.anyString())).thenReturn(schoolResponse);
		SchoolResponse schoolGetResponse = schoolServiceImpl.getSchool("1111111111111");
		assertEquals(MessageTypeEnum.SCHOOL_RETRIEVED_SUCCESSFULLY.toString(), schoolGetResponse.getMessage());
	}

	@Test
	public void createSchool() throws Exception {
		Mockito.when(schoolRepositoryMock.save(Mockito.any(School.class))).thenReturn(school);
		SchoolResponse schoolPostResponse = schoolServiceImpl.createSchool(school);
		assertEquals(MessageTypeEnum.SCHOOL_CREATED_SUCCESSFULLY.toString(), schoolPostResponse.getMessage());
	}

	@Test
	public void updateSchool() throws Exception {
		Mockito.when(schoolRepositoryMock.existsById(Mockito.anyString())).thenReturn(true);
		Mockito.when(schoolRepositoryMock.save(Mockito.any(School.class))).thenReturn(school);
		SchoolResponse schoolPostResponse = schoolServiceImpl.updateSchool("44444444444", school);
		assertEquals(MessageTypeEnum.SCHOOL_UPDATED_SUCCESSFULLY.toString(), schoolPostResponse.getMessage());
	}
}
