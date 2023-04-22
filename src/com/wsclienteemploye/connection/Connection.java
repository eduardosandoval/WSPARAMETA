package com.wsclienteemploye.connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connection {
	
public  static final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/employe";
public  static final String JDBC_USER="root";
public  static final String JDBC_PASSWORD="eduardo";
public  static final String JDBC_NAME="com.mysql.cj.jdbc.Driver";

//Conectarse a la DB
public java.sql.Connection getConnection ()  {
	java.sql.Connection conn= null;
	try {
		Class.forName(JDBC_NAME);
		System.out.println("Connetion to bd ok");
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al cargar controlador");

	}
	try {
		conn=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al conectarse a la base de datos");

	}
	return conn;
	}

public static void close  (ResultSet rs) {
	try {
		rs.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public static void preparedStatementClose  (PreparedStatement preparedStatement) {
	try {
		preparedStatement.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}


public static void connectionClose  (java.sql.Connection connection) {
	try {
		connection.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
