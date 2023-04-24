package com.wsclienteemploye.model;

public class Response {

	private Integer idemploye;
	private String name;
	private String lastName;
	private String documentType;
	private String birthdate;
	private String companyDate;
	private double salary;
	private String post;
	private String timeLinking;
	private String currentAge;
    private String response;
	public Response() {
		
	}

	
	public Response(Integer idemploye, String name, String lastName, String documentType, String birthdate,
			String companyDate, double salary, String post, String timeLinking, String currentAge, String response) {
		super();
		this.idemploye = idemploye;
		this.name = name;
		this.lastName = lastName;
		this.documentType = documentType;
		this.birthdate = birthdate;
		this.companyDate = companyDate;
		this.salary = salary;
		this.post = post;
		this.timeLinking = timeLinking;
		this.currentAge = currentAge;
		this.response=response;
	}


	public Integer getIdemploye() {
		return idemploye;
	}


	public void setIdemploye(int idemploye) {
		this.idemploye = idemploye;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getCompanyDate() {
		return companyDate;
	}


	public void setCompanyDate(String companyDate) {
		this.companyDate = companyDate;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getTimeLinking() {
		return timeLinking;
	}


	public void setTimeLinking(String timeLinking) {
		this.timeLinking = timeLinking;
	}


	public String getCurrentAge() {
		return currentAge;
	}


	public void setCurrentAge(String currentAge) {
		this.currentAge = currentAge;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public void setIdemploye(Integer idemploye) {
		this.idemploye = idemploye;
	}



}
