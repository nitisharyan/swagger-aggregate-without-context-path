package com.pearson.sam.school.controller;

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
import com.pearson.sam.school.model.School;
import com.pearson.sam.school.model.SchoolResponse;
import com.pearson.sam.school.service.SchoolService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SchoolController.class, secure = false)
public class SchoolControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SchoolService schoolServiceMock;

	private School school;

	@Before
	public void setup() {
		school = new School();
		school.setName("St. Johns");
	}
	
	@Test
	public void getHealthStatus() throws Exception {
		mockMvc.perform(get("/school").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getSchool() throws Exception {

		Mockito.when(schoolServiceMock.getSchool(Mockito.anyString())).thenReturn(new SchoolResponse());

		mockMvc.perform(get("/school/1111111111111").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void createSchool() throws Exception {

		Mockito.when(schoolServiceMock.createSchool(Mockito.any(School.class))).thenReturn(new SchoolResponse());

		mockMvc.perform(post("/school").content(new Gson().toJson(school)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void updateSchool() throws Exception {

		Mockito.when(schoolServiceMock.updateSchool(Mockito.anyString(), Mockito.any(School.class)))
				.thenReturn(new SchoolResponse());

		mockMvc.perform(
				put("/school/1111111111111").content(new Gson().toJson(school)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}
}