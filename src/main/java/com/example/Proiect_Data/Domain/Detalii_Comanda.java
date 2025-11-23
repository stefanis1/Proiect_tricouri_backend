package com.example.Proiect_Data.Domain;


import jakarta.persistence.*;

import javax.naming.Name;

@Entity
public class Detalii_Comanda extends BaseEntity {

    @JoinColumn(name = " id_comanda")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comanda comanda;

    @JoinColumn(name = "id_tricou")
    @ManyToOne
    private Tricou tricou;

    @Column(name = "cantitate")
    private int cantitate;

    public Detalii_Comanda(){}

    public Detalii_Comanda(Comanda comanda,Tricou tricou,int cantitate){
        this.comanda=comanda;
        this.tricou=tricou;
        this.cantitate=cantitate;
    }

    public Long getId_comanda() {
        return comanda.getId();
    }

    public void setId_comanda(Long id_comanda) {
        this.comanda.setId(id_comanda) ;
    }

    public Long getId_Tricou() {
        return tricou.getId();
    }

    public void setId_user(Long id_tricou) {
        this.tricou.setId(id_tricou);
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString(){
        return "Detalii_Comanda:Id_Comanda: "+comanda.getId()+" ,Id_User "+tricou.getId()+" ,cantitate"+cantitate;
    }
}
