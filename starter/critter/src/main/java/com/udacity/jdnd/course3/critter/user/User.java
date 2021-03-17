package com.udacity.jdnd.course3.critter.user;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
//	@Id
//	@GeneratedValue
//	private Long id;

	@EmbeddedId
	private UserPK id;

	@Column(name = "address_full", length = 500)
	private String address;


	public UserPK getId(){ return id;}

	public void setId(UserPK id){ this.id = id; }


	public String getAddress() {
		return address;
	}

	public void setAddress(String name) {
		this.address = address;
	}

}

