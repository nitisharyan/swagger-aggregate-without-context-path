package com.pearson.sam.organization.service.impl.test;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.pearson.sam.organization.constant.MessageTypeEnum;
import com.pearson.sam.organization.model.Organization;
import com.pearson.sam.organization.model.OrganizationResponse;
import com.pearson.sam.organization.repository.OrganizationRepository;
import com.pearson.sam.organization.service.impl.OrganizationServiceImpl;

@RunWith(SpringRunner.class)
public class OrganizationServiceImplTest {
	
	@InjectMocks
	OrganizationServiceImpl organizationServiceImpl;
	
	@Mock
	OrganizationRepository organizationRepositoryMock;

	private Organization organization;

	@Before
	public void setup() {
		organization = new Organization();
		organization.setId("222222222222");
		organization.setName("My Organization");
	}
	
	@Test
	public void getHealthStatus() throws Exception {
		Mockito.when(organizationRepositoryMock.count()).thenReturn(new Long(1));
		String organizationGetHealthResponse = organizationServiceImpl.getHealthStatus();
		assertEquals(MessageTypeEnum.ORGANIZATION_HEALTH_OK.toString(), organizationGetHealthResponse);
	}
	
	@Test
	public void getOrganization() throws Exception {
		Optional<Organization> organizationResponse = Optional.of(organization);
		Mockito.when(organizationRepositoryMock.findById(Mockito.anyString())).thenReturn(organizationResponse);
		OrganizationResponse organizationGetResponse = organizationServiceImpl.getOrganization("1111111111111");
		assertEquals(MessageTypeEnum.ORGANIZATION_RETRIEVED_SUCCESSFULLY.toString(), organizationGetResponse.getMessage());
	}
	
	@Test
	public void createOrganization() throws Exception {
		Mockito.when(organizationRepositoryMock.save(Mockito.any(Organization.class))).thenReturn(organization);
		OrganizationResponse organizationPostResponse = organizationServiceImpl.createOrganization(organization);
		assertEquals(MessageTypeEnum.ORGANIZATION_CREATED_SUCCESSFULLY.toString(), organizationPostResponse.getMessage());
	}
	
	@Test
	public void updateOrganization() throws Exception {
		Mockito.when(organizationRepositoryMock.existsById(Mockito.anyString())).thenReturn(true);
		Mockito.when(organizationRepositoryMock.save(Mockito.any(Organization.class))).thenReturn(organization);
		OrganizationResponse organizationPostResponse = organizationServiceImpl.updateOrganization("44444444444", organization);
		assertEquals(MessageTypeEnum.ORGANIZATION_UPDATED_SUCCESSFULLY.toString(), organizationPostResponse.getMessage());
	}
}
