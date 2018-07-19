package com.pearson.sam.school.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "school", "message", "status" })
public class SchoolResponse {

	@JsonProperty("school")
	@JsonPropertyDescription("school")
	private School school;

	@JsonProperty("message")
	@JsonPropertyDescription("message")
	private String message;

	@JsonProperty("status")
	@JsonPropertyDescription("status")
	private boolean status;

	@JsonProperty("school")
	public School getSchool() {
		return school;
	}

	@JsonProperty("school")
	public void setSchool(School school) {
		this.school = school;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolResponse other = (SchoolResponse) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchoolResponse [school=" + school + ", message=" + message + ", status=" + status + "]";
	}

}
