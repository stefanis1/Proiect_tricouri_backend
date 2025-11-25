package com.example.Proiect_Data.Domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Echipa")
public class Echipa extends BaseEntity {

    @Column(name = "Nume")
    private String name;

    @Column(name = "Tara")
    private String tara;


    public Echipa(){}

    public Echipa( String name,String tara ){
        this.name=name;
        this.tara=tara;
    }

    public String getName(){
        return name;
    }

    public String getTara(){
        return tara;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setTara(String tara){
        this.tara=tara;
    }


}
