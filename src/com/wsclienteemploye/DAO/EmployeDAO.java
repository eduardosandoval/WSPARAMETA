package com.wsclienteemploye.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wsclienteemploye.connection.Connection;
import com.wsclienteemploye.model.Employe;
import com.wsclientemploye.client.Operaciones;

public class EmployeDAO implements Operaciones {
	
	private Connection connection = new Connection();

	// Constan SQL
	private static final String SQL_INSERT = " insert INTO employe (birthdate,companydate,documenttype,lastname,name,post,salary)  \r\n"
			+ " values (?,?,?,?,?,?,?)";

	private static final String SQL_SELECT_ID = "select idemploye,birthdate,companydate,documenttype,lastname,name,post,salary from employe  where idemploye=?";

	@Override
	public Employe save(Employe employe) {
		
		java.sql.Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int rows=0;
		
		try {
			
			conn = connection.getConnection();
			stmt=conn.prepareStatement(SQL_INSERT);
			stmt.setDate(1,new java.sql.Date(employe.getBirthdate().getTime()));
			stmt.setDate(2,new java.sql.Date(employe.getBirthdate().getTime()));
			stmt.setString(3,employe.getDocumenttype());
			stmt.setString(4,employe.getLastname());
			stmt.setString(5,employe.getName());
			stmt.setString(6,employe.getPost());
			stmt.setDouble(7,employe.getSalary());
			
			rows=stmt.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public Employe GetEmployeId(int idEmploye) {

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

				employe.setBirthdate(birthdate);
				employe.setCompanydate(companydate);
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

}
