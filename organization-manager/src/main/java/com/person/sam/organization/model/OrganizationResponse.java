package com.person.sam.organization.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "organization", "message", "status" })
public class OrganizationResponse {

	@JsonProperty("organization")
	@JsonPropertyDescription("organization")
	private Organization organization;

	@JsonProperty("message")
	@JsonPropertyDescription("message")
	private String message;

	@JsonProperty("status")
	@JsonPropertyDescription("status")
	private boolean status;

	@JsonProperty("organization")
	public Organization getOrganization() {
		return organization;
	}

	@JsonProperty("organization")
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("status")
	public boolean isStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
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
		OrganizationResponse other = (OrganizationResponse) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrganizationResponse [organization=" + organization + ", message=" + message + ", status=" + status
				+ "]";
	}

}
