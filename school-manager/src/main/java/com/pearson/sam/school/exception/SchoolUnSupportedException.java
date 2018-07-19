package com.pearson.sam.school.exception;

import com.pearson.sam.school.constant.MessageTypeEnum;

public class SchoolUnSupportedException extends Exception {

	private static final long serialVersionUID = 1L;

	public SchoolUnSupportedException() {
	}

	public SchoolUnSupportedException(MessageTypeEnum messageType) {
		super(messageType.toString());
	}

}
