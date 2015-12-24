package com.fish.acfun.model;

import java.io.Serializable;


public class Message implements Serializable{

	private static final long serialVersionUID = 5945161211817861027L;
	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
