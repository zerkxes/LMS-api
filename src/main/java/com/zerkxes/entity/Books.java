package com.zerkxes.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	private String owner;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate b_date;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate r_date;

	public Books() {

	}

	public Books(int id, String name, Users user, String owner, LocalDate b_date, LocalDate r_date) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
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
	@JsonBackReference
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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
		return "Books [id=" + id + ", name=" + name + ", user=" + user + ", owner=" + owner + ", b_date=" + b_date
				+ ", r_date=" + r_date + "]";
	}
}
