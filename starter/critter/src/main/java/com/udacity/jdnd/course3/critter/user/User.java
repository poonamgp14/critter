package com.udacity.jdnd.course3.critter.user;


import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	@Id
	@GeneratedValue
	private Long id;

//	@EmbeddedId
//	private UserPK id;

	@Column(name = "address_full", length = 500)
	private String address;
	@Nationalized
	private String name;
	@Column(name = "contact_number")
	private String contact;

	public String getName(){
		return name;
	}
	public void setName(String name){ this.name= name;}

	public String getContact(){
		return contact;
	}
	public void setContact(String contact){ this.contact=contact;}

	public Long getId(){ return id;}

	public void setId(Long id){ this.id = id; }


	public String getAddress() {
		return address;
	}

	public void setAddress(String name) {
		this.address = address;
	}

}

