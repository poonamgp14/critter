package com.udacity.jdnd.course3.critter.user;


import javax.persistence.*;

@Entity
@Table(name = "user")
public abstract class User {
//	@Id
//	@GeneratedValue
//	private Long id;

	@EmbeddedId
	private UserPK userId;

	@Column(name = "address_full", length = 500)
	private String address;


	public UserPK getId(){ return userId;}

	public void setId(UserPK id){ this.userId = id; }


	public String getAddress() {
		return address;
	}

	public void setAddress(String name) {
		this.address = address;
	}

}

