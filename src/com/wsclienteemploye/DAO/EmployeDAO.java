package com.wsclienteemploye.DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.wsclienteemploye.connection.Connection;
import com.wsclienteemploye.model.Employe;
import com.wsclientemploye.client.Operaciones;

public class EmployeDAO  implements Operaciones{
   private Connection connection=  new Connection();
   
   //Constan SQL
   private static final  String  SQL_INSERT= " insert INTO employe (idemploye,birthdate,companydate,documenttype,lastname,name,post,salary) values \r\n"
   		+ " (?,?,?,?,?,?,?,?)";
   
 private static final  String SQL_SELECT_ID = "select * from where idemploye=?";
   
	@Override
	public Employe save(Employe employe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe GetEmployeId (int idEmploye) {
		
		java.sql.Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Employe employe = new Employe();

             try {
            	 
            	conn= (java.sql.Connection) connection.getConnection();
            	stmt=conn.prepareStatement(SQL_SELECT_ID);
            	stmt.setInt(1,idEmploye);
            	
            	rs.next();
            	
				int idemploye=rs.getInt("idemploye");
				Date birthdate=rs.getDate("birthdate");
				Date companydate=rs.getDate("companydate");
				String documenttype=rs.getString("documenttype");
				String lastname=rs.getString("lastname");
				String name=rs.getString("name");
				String post=rs.getString("post");
				double salary=rs.getDouble("salary");
				employe.setBirthdate(birthdate);
				employe.setCompanydate(companydate);
				employe.setName(name);
				employe.setLastname(lastname);
				employe.setPost(post);
				employe.setSalary(salary);
				employe.setDocumenttype(documenttype);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				connection.preparedStatementClose(stmt);
				connection.close(rs);
				connection.connectionClose(conn);
			}
	
		// TODO Auto-generated method stub
		return employe;
	}

}
