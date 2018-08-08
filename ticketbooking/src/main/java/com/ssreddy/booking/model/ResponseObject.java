package com.ssreddy.booking.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseObject {

	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
