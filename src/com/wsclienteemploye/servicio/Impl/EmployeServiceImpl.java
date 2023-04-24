package com.wsclienteemploye.servicio.Impl;

import java.util.logging.Logger;

import javax.jws.WebService;

import com.wsclienteemploye.DAO.EmployeDAO;
import com.wsclienteemploye.model.Employe;
import com.wsclienteemploye.model.Response;
import com.wsclienteemploye.util.Utillities;
import com.wsclientemploye.client.Operaciones;

@WebService(endpointInterface = "com.wsclientemploye.client.Operaciones")
public class EmployeServiceImpl implements Operaciones {

	private static final String CORRECT = "CORRECT";
	private static final String ALREADY_EXISTS = "ALREADY EXISTS";
	private static final String BEFORE_DATABASE = "BEFORE SAVE IN DATABASE";
	private static final String AFTER_DATABASE = "AFTER SAVE IN DATABASE";

	private static Logger logger = Logger.getLogger(EmployeServiceImpl.class.getName());

	private EmployeDAO employeDAO;
	private Utillities utilities;

	public EmployeServiceImpl() {
		employeDAO = new EmployeDAO();
		utilities = new Utillities();
	}

	// method to save employee information
	public Response save(Employe employe) {
		Response result = new Response();
		// TODO Auto-generated method stub
		Response response = new Response();

		try {

			response = getDocumentType(employe.getDocumenttype());

			if (response.getIdemploye() == null) {
				logger.info(BEFORE_DATABASE);
				employeDAO.save(employe);
				logger.info(AFTER_DATABASE);

				response = getDocumentType(employe.getDocumenttype());

				result.setBirthdate(response.getBirthdate());
				result.setCompanyDate(response.getCompanyDate());
				result.setDocumentType(response.getDocumentType());
				result.setLastName(response.getLastName());
				result.setName(response.getName());
				result.setPost(response.getPost());
				result.setSalary(response.getSalary());
				result.setIdemploye(response.getIdemploye());
				result.setCurrentAge(utilities.validAge(response.getBirthdate().toString()));
				result.setTimeLinking(utilities.validAge(response.getCompanyDate().toString()));
				result.setResponse(CORRECT);

				logger.info(CORRECT);

			} else {
				result.setResponse(ALREADY_EXISTS);

				logger.info(ALREADY_EXISTS);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public Employe getEmployeId(int idEmploye) {
		// TODO Auto-generated method stub
		return employeDAO.getEmployeId(idEmploye);
	}

	@Override
	public Response getDocumentType(String documentType) {
		// TODO Auto-generated method stub
		return employeDAO.getDocumentType(documentType);
	}

}
