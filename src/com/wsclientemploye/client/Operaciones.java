package com.wsclientemploye.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.wsclienteemploye.model.Employe;
import com.wsclienteemploye.model.Response;

@WebService
public interface Operaciones {

	
	@WebMethod
	public Response save (Employe employe);
	
	@WebMethod
	public Employe getEmployeId (int idEmploye);

	@WebMethod
	public Response getDocumentType (String documentType);

}
