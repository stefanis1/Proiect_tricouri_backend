package com.example.Proiect_Data.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "nume")
    private String name;

    @Column(name="email_adress")
    private String email;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Comanda> comenziUser;

    public User(){};

    public User(String name,String email){
        this.name=name;
        this.email=email;
    }

    public List<Comanda> getComenziUser() {
        return comenziUser;
    }

    public void setComenziUser(List<Comanda> comenziUser) {
        this.comenziUser = comenziUser;
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

    @Override
    public String toString(){
        return "User: nume:"+name+" ,email:"+email+" ,ID:"+getId();
    }
}
