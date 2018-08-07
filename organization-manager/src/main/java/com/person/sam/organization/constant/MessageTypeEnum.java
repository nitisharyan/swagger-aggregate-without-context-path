package com.person.sam.organization.constant;

public enum MessageTypeEnum {
	ORGANIZATION_NOT_FOUND("Organization Not Found"),
	ORGANIZATION_CREATION_FAILED("Organization Creation Failed"),
	ORGANIZATION_UPDATION_FAILED("Organization Updation Failed"),
	ORGANIZATION_UPDATED_SUCCESSFULLY("Organization Updated Successfully."),
	ORGANIZATION_CREATED_SUCCESSFULLY("Organization Created Successfully."),
	ORGANIZATION_RETRIEVED_SUCCESSFULLY("Organization Retrieved Successfully."),
	ORGANIZATION_RESPONSE("Organization Response- "),
	ORGANIZATION_HEALTH_OK("Organization Manager service is UP and Running"),
	ORGANIZATION_HEALTH_ERROR("Organization Manager service is DOWN");
	MessageTypeEnum(String label) {
		name = label;
	}

	private final String name;

	public boolean equalsName(String otherName) {
		return name.equals(otherName);
	}

	@Override
	public String toString() {
		return this.name;
	}
}