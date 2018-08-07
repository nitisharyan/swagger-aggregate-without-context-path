package com.person.sam.school.exception;

import com.person.sam.school.constant.MessageTypeEnum;

public class SchoolUnSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public SchoolUnSupportedException() {
	}

	public SchoolUnSupportedException(MessageTypeEnum messageType) {
		super(messageType.toString());
	}

}
