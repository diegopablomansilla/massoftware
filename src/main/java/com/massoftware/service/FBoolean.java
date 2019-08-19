package com.massoftware.service;

public class FBoolean {

	private Boolean value;
	private String msg;
	private String prefix;

	public FBoolean(String prefix, Boolean value, String msg) {
		super();
		this.prefix = prefix;
		this.value = value;
		this.msg = msg;
	}

	public FBoolean(Boolean value) {
		super();
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return prefix + " " + msg;
	}

}
