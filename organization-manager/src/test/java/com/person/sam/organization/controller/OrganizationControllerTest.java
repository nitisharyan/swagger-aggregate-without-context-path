package com.person.sam.organization.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.person.sam.organization.controller.OrganizationController;
import com.person.sam.organization.model.Organization;
import com.person.sam.organization.model.OrganizationResponse;
import com.person.sam.organization.service.OrganizationService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrganizationController.class, secure = false)
public class OrganizationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrganizationService organizationServiceMock;

	private Organization organization;

	@Before
	public void setup() {
		organization = new Organization();
		organization.setName("My Organization");
	}
	
	@Test
	public void getHealthStatus() throws Exception {
		mockMvc.perform(get("/organization").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getOrganization() throws Exception {

		Mockito.when(organizationServiceMock.getOrganization(Mockito.anyString())).thenReturn(new OrganizationResponse());

		mockMvc.perform(get("/organization/1111111111111").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void createOrganization() throws Exception {

		Mockito.when(organizationServiceMock.createOrganization(Mockito.any(Organization.class))).thenReturn(new OrganizationResponse());

		mockMvc.perform(post("/organization").content(new Gson().toJson(organization)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void updateOrganization() throws Exception {

		Mockito.when(organizationServiceMock.updateOrganization(Mockito.anyString(), Mockito.any(Organization.class)))
				.thenReturn(new OrganizationResponse());

		mockMvc.perform(
				put("/organization/1111111111111").content(new Gson().toJson(organization)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}
}