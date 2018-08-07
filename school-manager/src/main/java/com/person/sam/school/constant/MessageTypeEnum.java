package com.person.sam.school.constant;

public enum MessageTypeEnum {
	SCHOOL_NOT_FOUND("School Not Found"),
	SCHOOL_CREATION_FAILED("School Creation Failed"),
	SCHOOL_UPDATION_FAILED("School Updation Failed"),
	SCHOOL_UPDATED_SUCCESSFULLY("School Updated Successfully."),
	SCHOOL_CREATED_SUCCESSFULLY("School Created Successfully."),
	SCHOOL_RETRIEVED_SUCCESSFULLY("School Retrieved Successfully."),
	SCHOOL_RESPONSE("School Response- "),
	SCHOOL_HEALTH_OK("School Manager service is UP and Running"),
	SCHOOL_HEALTH_ERROR("School Manager service is DOWN");
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