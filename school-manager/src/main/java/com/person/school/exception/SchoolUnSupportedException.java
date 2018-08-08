package com.person.school.exception;

import com.person.school.constant.MessageTypeEnum;

public class SchoolUnSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public SchoolUnSupportedException() {
	}

	public SchoolUnSupportedException(MessageTypeEnum messageType) {
		super(messageType.toString());
	}

}
