package com.wsclientemploye.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.wsclienteemploye.model.Employe;

@WebService
public interface Operaciones {

	
	@WebMethod
	public Employe save (Employe employe);
	
	@WebMethod
	public Employe GetEmployeId (int idEmploye);

}
