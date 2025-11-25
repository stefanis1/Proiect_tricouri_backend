package com.example.Proiect_Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore; // <--- Import necesar
import jakarta.persistence.*;

@Entity
@Table(name = "detalii_comanda")
public class Detalii_Comanda extends BaseEntity {


    @JoinColumn(name = "id_comanda")
    @ManyToOne
    @JsonIgnore
    private Comanda comanda;

    @JoinColumn(name = "id_tricou")
    @ManyToOne
    private Tricou tricou;

    @Column(name = "cantitate")
    private int cantitate;

    public Detalii_Comanda(){}

    public Detalii_Comanda(Comanda comanda, Tricou tricou, int cantitate){
        this.comanda = comanda;
        this.tricou = tricou;
        this.cantitate = cantitate;
    }



    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Tricou getTricou() {
        return tricou;
    }

    public void setTricou(Tricou tricou) {
        this.tricou = tricou;
    }


    @Override
    public String toString(){
        return "Detalii_Comanda: Cantitate " + cantitate +
                (tricou != null ? ", Tricou ID: " + tricou.getId() : "") +
                (comanda != null ? ", Comanda ID: " + comanda.getId() : "");
    }
}