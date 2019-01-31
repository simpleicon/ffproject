package com.vo;

public class Admin {
	String a_id;
	String a_pw;
	String a_name;
	int access_level;
	
	public Admin() {}

	public Admin(String a_id, String a_pw, String a_name, int access_level) {
		super();
		this.a_id = a_id;
		this.a_pw = a_pw;
		this.a_name = a_name;
		this.access_level = access_level;
	}
	

	public Admin(String a_id, String a_pw, String a_name) {
		super();
		this.a_id = a_id;
		this.a_pw = a_pw;
		this.a_name = a_name;
	}
	
	
	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_pw() {
		return a_pw;
	}

	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public int getAccess_level() {
		return access_level;
	}

	public void setAccess_level(int access_level) {
		this.access_level = access_level;
	}

	



	@Override
	public String toString() {
		return "Admin [a_id=" + a_id + ", a_pw=" + a_pw + ", a_name=" + a_name + ", access_level=" + access_level
				+ "]";
	}
	
	
	
	
	
}
