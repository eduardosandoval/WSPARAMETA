package com.wsclienteemploye.servicio.Impl;

import javax.xml.ws.Endpoint;

//web service publication
public class ServicePublic {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2021/ws/service", new EmployeServiceImpl());
	}
}
