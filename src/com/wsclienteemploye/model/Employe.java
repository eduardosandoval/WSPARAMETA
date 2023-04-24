 package com.wsclienteemploye.model;

public class Employe {


	private Integer idemploye;
	private String name;
	private String lastname;
	private String documenttype;
	private String birthdate;
	private String  companydate;
	private double salary;
	private String post;
	
	public Employe () {
		
	}
	
	public Employe(Integer idemploye, String name, String lastname, String documenttype, String birthdate,
			String companydate, Double salary, String post) {
		this.idemploye = idemploye;
		this.name = name;
		this.lastname = lastname;
		this.documenttype = documenttype;
		this.birthdate =  birthdate;
		this.companydate = companydate;
		this.salary = salary;
		this.post = post;
	}
	public Integer getIdemploye() {
		return idemploye;
	}
	public void setIdemploye(Integer idemploye) {
		this.idemploye = idemploye;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDocumenttype() {
		return documenttype;
	}
	public void setDocumenttype(String documenttype) {
		this.documenttype = documenttype;
	}

	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCompanydate() {
		return companydate;
	}

	public void setCompanydate(String companydate) {
		this.companydate = companydate;
	}

	public void setIdemploye(int idemploye) {
		this.idemploye = idemploye;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
