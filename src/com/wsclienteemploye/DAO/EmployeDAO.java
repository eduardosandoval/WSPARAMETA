package com.wsclienteemploye.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wsclienteemploye.connection.Connection;
import com.wsclienteemploye.model.Employe;
import com.wsclienteemploye.model.Response;
import com.wsclientemploye.client.Operaciones;

public class EmployeDAO  {

	private Connection connection = new Connection();

	// Constans SQL
	private static final String SQL_INSERT = " insert INTO employe (birthdate,companydate,documenttype,lastname,name,post,salary)  \r\n"
			+ " values (?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_ID = "select idemploye,birthdate,companydate,documenttype,lastname,name,post,salary from employe  where idemploye=?";
	private static final String SQL_SELECT_DOCUMENT_TYPE = "select idemploye,birthdate,companydate,documenttype,lastname,name,post,salary from employe  where documenttype=?";

	public int save(Employe employe) {

		java.sql.Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			conn = connection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setDate(1, convertStringToDate(employe.getBirthdate()));
			stmt.setDate(2, convertStringToDate(employe.getCompanydate()));
			stmt.setString(3, employe.getDocumenttype());
			stmt.setString(4, employe.getLastname());
			stmt.setString(5, employe.getName());
			stmt.setString(6, employe.getPost());
			stmt.setDouble(7, employe.getSalary());

			rows = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.preparedStatementClose(stmt);
			connection.connectionClose(conn);
		}
		// TODO Auto-generated method stub
		return rows;
	}

	public Employe getEmployeId(int idEmploye) {

		java.sql.Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Employe employe = new Employe();

		try {

			conn = connection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ID);
			stmt.setInt(1, idEmploye);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Date birthdate = rs.getDate("birthdate");
				Date companydate = rs.getDate("companydate");
				String documenttype = rs.getString("documenttype");
				String lastname = rs.getString("lastname");
				String name = rs.getString("name");
				String post = rs.getString("post");
				double salary = rs.getDouble("salary");

     			employe.setBirthdate(birthdate.toString());
				employe.setCompanydate(companydate.toString());
				employe.setName(name);
				employe.setLastname(lastname);
				employe.setPost(post);
				employe.setSalary(salary);
				employe.setDocumenttype(documenttype);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.preparedStatementClose(stmt);
			connection.close(rs);
			connection.connectionClose(conn);
		}

		// TODO Auto-generated method stub
		return employe;
	}

	public Response getDocumentType(String documentType) {

		java.sql.Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Response response = new Response();

		try {

			conn = connection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_DOCUMENT_TYPE);
			stmt.setString(1, documentType);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Integer idEmploye = rs.getInt("idemploye");
				Date birthdate = rs.getDate("birthdate");
				Date companydate = rs.getDate("companydate");
				String documenttype = rs.getString("documenttype");
				String lastname = rs.getString("lastname");
				String name = rs.getString("name");
				String post = rs.getString("post");
				double salary = rs.getDouble("salary");
				
				response.setIdemploye(idEmploye);
				response.setBirthdate(birthdate.toString());
				response.setCompanyDate(companydate.toString());
				response.setName(name);
				response.setLastName(lastname);
				response.setPost(post);
				response.setSalary(salary);
				response.setDocumentType(documenttype);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.preparedStatementClose(stmt);
			connection.close(rs);
			connection.connectionClose(conn);
		}

		// TODO Auto-generated method stub
		return response;
	}

	public Date convertStringToDate(String pdate) {
		Date date = null;
		try {
			date = Date.valueOf(pdate);// converting string into sql date
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}

}
