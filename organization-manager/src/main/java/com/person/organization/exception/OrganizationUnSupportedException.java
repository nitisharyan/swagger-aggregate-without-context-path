package com.person.organization.exception;

import com.person.organization.constant.MessageTypeEnum;

public class OrganizationUnSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrganizationUnSupportedException() {
	}

	public OrganizationUnSupportedException(MessageTypeEnum messageType) {
		super(messageType.toString());
	}

}
