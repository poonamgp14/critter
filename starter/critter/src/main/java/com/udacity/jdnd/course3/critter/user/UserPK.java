package com.udacity.jdnd.course3.critter.user;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserPK implements Serializable {
    @Nationalized
    private String name;
    @Column(name = "contact_number")
    private String contact;

    public UserPK(String name, String contact){
        this.name = name;
        this.contact = contact;
    }

    public UserPK(){}

    public String getName(){
        return name;
    }

    public String getContact(){
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPK userPK = (UserPK) o;
        return contact == userPK.contact &&
                name.equals(userPK.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contact);
    }
}
