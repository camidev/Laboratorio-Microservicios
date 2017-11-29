package com.udea.microserviceclient;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonRootName;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonRootName("Client")
public class Client implements Serializable {

    @Id
    private long id;
    private String name;
    private String email;
    private String telephone;

    public Client(long id, String name, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "A client{"
                + "id:" + id
                + ", name='" + name 
                + ", email='" + email +'\''
                + '}';
    }

}
