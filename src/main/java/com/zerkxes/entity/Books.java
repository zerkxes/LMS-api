package com.zerkxes.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String u_name;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date b_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date r_date;

	public Books(int id, String name, String u_name, Date b_date, Date r_date) {
		super();
		this.id = id;
		this.name = name;
		this.u_name = u_name;
		this.b_date = b_date;
		this.r_date = r_date;
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

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", u_name=" + u_name + ", b_date=" + b_date + ", r_date=" + r_date
				+ "]";
	}
}
