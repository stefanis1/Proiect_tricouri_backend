package com.example.Proiect_Data.Domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Comanda")
public class Comanda extends BaseEntity {

    @Column(name = "data")
    private java.time.LocalDate data;

    @JoinColumn(name = "Id_user")
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "comanda",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Detalii_Comanda> detaliiComanda;

    public Comanda(){}

    public Comanda(User user,java.time.LocalDate data,List<Detalii_Comanda> detaliiComanda )
    {
        this.detaliiComanda=detaliiComanda;
        this.user=user;
        this.data=data;

        if (detaliiComanda != null) {
            for (Detalii_Comanda detaliu : detaliiComanda) {
                detaliu.setComanda(this);

            }
        }
    }

    public java.time.LocalDate getData() {
        return data;
    }

    public void setData(java.time.LocalDate data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Detalii_Comanda> getDetaliiComanda() {
        return detaliiComanda;
    }

    public void setDetaliiComanda(List<Detalii_Comanda> detaliiComanda) {
        this.detaliiComanda = detaliiComanda;
    }

    @Override
    public String toString(){
        return "Comanda:ID"+getId()+" ,Id_User "+user+" ,data:"+data+detaliiComanda;
    }


}
