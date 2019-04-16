package com.best.microservice.entity;

import lombok.Data;

@Data
public class HelloMsg {
	private Person person;

	private String msg;
}
