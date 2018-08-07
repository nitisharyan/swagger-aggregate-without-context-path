package com.person.sam.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.sam.school.model.School;
import com.person.sam.school.model.SchoolResponse;
import com.person.sam.school.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "School Resource", description = "School")
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	SchoolService schoolService;

	@ApiOperation(value = "Health Check", notes = "Health Check")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@CrossOrigin
	@GetMapping
	public String getHealthStatus() throws Exception {
		return schoolService.getHealthStatus();
	}

	@ApiOperation(value = "Get School ", notes = "Get School Based On id")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@CrossOrigin
	@GetMapping("/{id}")
	public SchoolResponse getSchool(@PathVariable("id") String id) throws Exception {
		return schoolService.getSchool(id);
	}

	@ApiOperation(value = "Create School", notes = "Create School")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@CrossOrigin
	@PostMapping()
	public SchoolResponse createSchool(@RequestBody School school) throws Exception {
		return schoolService.createSchool(school);
	}

	@ApiOperation(value = "Update School", notes = "Update School Based On id")
	@ApiResponses(value = { @ApiResponse(code = 100, message = "100 is the message"),
			@ApiResponse(code = 200, message = "Successful") })
	@CrossOrigin
	@PutMapping("/{id}")
	public SchoolResponse updateSchool(@PathVariable("id") String id, @RequestBody School school) throws Exception {
		return schoolService.updateSchool(id, school);
	}
}
