package com.qrux.utils;

public enum Status {
	A("Active"), I("Inactive");


	private String status;

	Status(final String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
