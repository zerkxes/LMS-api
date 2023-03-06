package com.zerkxes.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private String owner;
	@JsonFormat(pattern= "dd-MM-yyyy")
	private LocalDate b_date;
	@JsonFormat(pattern= "dd-MM-yyyy")
	private LocalDate r_date;

	public Books() {

	}

	public Books(int id, String name, String u_name, String owner, LocalDate b_date, LocalDate r_date ) {
		super();
		this.id = id;
		this.name = name;
		this.u_name = u_name;
		this.owner = owner;
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

	public LocalDate getB_date() {
		return b_date;
	}

	public void setB_date(LocalDate b_date) {
		this.b_date = b_date;
	}

	public LocalDate getR_date() {
		return r_date;
	}

	public void setR_date(LocalDate r_date) {
		this.r_date = r_date;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", u_name=" + u_name + ", owner=" + owner + ", b_date=" + b_date + ", r_date=" + r_date
				+ "]";
	}
}
