package com.wsclienteemploye.servicio.Impl;

import javax.jws.WebService;

import com.wsclienteemploye.DAO.EmployeDAO;
import com.wsclienteemploye.model.Employe;
import com.wsclientemploye.client.Operaciones;

@WebService(endpointInterface = "com.wsclientemploye.client.Operaciones")
public class EmployeServiceImpl implements Operaciones {
private EmployeDAO employeDAO = new EmployeDAO(); 
	
	@Override
	public Employe save(Employe employe) {
		// TODO Auto-generated method stub
		return employeDAO.save(employe);
	}
	
	@Override
	public Employe GetEmployeId(int idEmploye) {
		// TODO Auto-generated method stub
		return employeDAO.GetEmployeId(idEmploye);
	}


}
