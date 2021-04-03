package com.qrux.utils;

public enum Status {
	A("Active"), I("Inactive");

     // this is a demo commit
	private String status;

	Status(final String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
