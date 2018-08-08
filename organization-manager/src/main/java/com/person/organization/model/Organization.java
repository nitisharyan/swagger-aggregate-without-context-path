package com.person.organization.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "_id", "idamGroupId", "uniqueIdentifier", "name", "orgURL", "addresses", "contactDetails",
		"createdOn", "createdBy", "updatedOn", "updatedBy" })
@Document(collection="tbl_org")
public class Organization {

	@JsonProperty("_id")
	@JsonPropertyDescription("IDAM Generated Unique Indetifier")
	private String id;

	@JsonProperty("idamGroupId")
	@JsonPropertyDescription("IDAM Generated Unique Indetifier")
	private String idamGroupId;

	@JsonProperty("uniqueIdentifier")
	@JsonPropertyDescription("Application Specific Unique Indetifier")
	private String uniqueIdentifier;

	@JsonProperty("name")
	@JsonPropertyDescription("Organization Name")
	private String name;

	@JsonProperty("orgURL")
	@JsonPropertyDescription("Organization Web URL")
	@URL
	private String orgURL;

	@JsonProperty("addresses")
	@Valid
	private List<Address> addresses = new ArrayList<>();

	@JsonProperty("contactDetails")
	@Valid
	private List<ContactDetail> contactDetails = new ArrayList<>();

	@JsonProperty("createdOn")
	@JsonPropertyDescription("Organization Web URL")
	private String createdOn;

	@JsonProperty("createdBy")
	@JsonPropertyDescription("Organization Web URL")
	private String createdBy;

	@JsonProperty("updatedOn")
	@JsonPropertyDescription("Organization Web URL")
	private String updatedOn;

	@JsonProperty("updatedBy")
	@JsonPropertyDescription("Organization Web URL")
	private String updatedBy;

	@JsonProperty("_id")
	public String getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("idamGroupId")
	public String getIdamGroupId() {
		return idamGroupId;
	}

	@JsonProperty("idamGroupId")
	public void setIdamGroupId(String idamGroupId) {
		this.idamGroupId = idamGroupId;
	}

	@JsonProperty("uniqueIdentifier")
	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	@JsonProperty("uniqueIdentifier")
	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("orgURL")
	public String getOrgURL() {
		return orgURL;
	}

	@JsonProperty("orgURL")
	public void setOrgURL(String orgURL) {
		this.orgURL = orgURL;
	}

	@JsonProperty("addresses")
	public List<Address> getAddresses() {
		return addresses;
	}

	@JsonProperty("addresses")
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@JsonProperty("contactDetails")
	public List<ContactDetail> getContactDetails() {
		return contactDetails;
	}

	@JsonProperty("contactDetails")
	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	@JsonProperty("createdOn")
	public String getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("createdOn")
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@JsonProperty("createdBy")
	public String getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("createdBy")
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty("updatedOn")
	public String getUpdatedOn() {
		return updatedOn;
	}

	@JsonProperty("updatedOn")
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@JsonProperty("updatedBy")
	public String getUpdatedBy() {
		return updatedBy;
	}

	@JsonProperty("updatedBy")
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((contactDetails == null) ? 0 : contactDetails.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idamGroupId == null) ? 0 : idamGroupId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orgURL == null) ? 0 : orgURL.hashCode());
		result = prime * result + ((uniqueIdentifier == null) ? 0 : uniqueIdentifier.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedOn == null) ? 0 : updatedOn.hashCode());
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
		Organization other = (Organization) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (contactDetails == null) {
			if (other.contactDetails != null)
				return false;
		} else if (!contactDetails.equals(other.contactDetails))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idamGroupId == null) {
			if (other.idamGroupId != null)
				return false;
		} else if (!idamGroupId.equals(other.idamGroupId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orgURL == null) {
			if (other.orgURL != null)
				return false;
		} else if (!orgURL.equals(other.orgURL))
			return false;
		if (uniqueIdentifier == null) {
			if (other.uniqueIdentifier != null)
				return false;
		} else if (!uniqueIdentifier.equals(other.uniqueIdentifier))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedOn == null) {
			if (other.updatedOn != null)
				return false;
		} else if (!updatedOn.equals(other.updatedOn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", idamGroupId=" + idamGroupId + ", uniqueIdentifier=" + uniqueIdentifier
				+ ", name=" + name + ", orgURL=" + orgURL + ", addresses=" + addresses + ", contactDetails="
				+ contactDetails + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn
				+ ", updatedBy=" + updatedBy + "]";
	}

}
