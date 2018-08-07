package com.person.sam.organization.exception;

import com.person.sam.organization.constant.MessageTypeEnum;

public class OrganizationUnSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrganizationUnSupportedException() {
	}

	public OrganizationUnSupportedException(MessageTypeEnum messageType) {
		super(messageType.toString());
	}

}
