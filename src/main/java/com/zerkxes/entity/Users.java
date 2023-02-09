package com.zerkxes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	enum role {
		Student, Teacher, Librarian
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String u_name;
	private String pswrd;
	private role type;

	public Users(int id, String name, String u_name, String pswrd, role type) {
		super();
		this.id = id;
		this.name = name;
		this.u_name = u_name;
		this.pswrd = pswrd;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getPswrd() {
		return pswrd;
	}

	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}

	public role getType() {
		return type;
	}

	public void setType(role type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", u_name=" + u_name + ", pswrd=" + pswrd + ", type=" + type
				+ "]";
	}
}