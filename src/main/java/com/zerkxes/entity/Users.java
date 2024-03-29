package com.zerkxes.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Users {
	public enum role {
		Student, Teacher, Librarian
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min=0)
	@NotNull
	private int id;
	@NotBlank
	private String name;
	@Column(unique=true)
	@NotNull
	private String u_name;
	@NotNull
	private String pswrd;
	@Enumerated(EnumType.STRING)
	private role type;
	@Column(name="owner", nullable = true)
	private String z_owner;
	@OneToMany(targetEntity=Books.class, mappedBy="user", fetch=FetchType.LAZY)
	private List<Books> book;

	public Users() {

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

	public String getZ_owner() {
		return z_owner;
	}

	public void setZ_owner(String z_owner) {
		this.z_owner = z_owner;
	}
	@JsonManagedReference
	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", u_name=" + u_name + ", pswrd=" + pswrd + ", type=" + type
				+ ", z_owner=" + z_owner + ", book=" + book + "]";
	}

	public Users(int id, String name, String u_name, String pswrd, role type, String z_owner, List<Books> book) {
		super();
		this.id = id;
		this.name = name;
		this.u_name = u_name;
		this.pswrd = pswrd;
		this.type = type;
		this.z_owner = z_owner;
		this.book = book;
	}

	

	
}