package com.example.Proiect_Data.Domain;


import jakarta.persistence.*;

@Entity
@Table(name="Tricou")
public class Tricou extends BaseEntity {

    @Column(name = "Model")
    private String name;

    @Column(name = "Marime")
    private String marime;

    @Column(name = "Stock")
    private int stock;


    @ManyToOne
    @JoinColumn(name = "id_echipa")
    private Echipa echipa;

    @Column(name = "Pret")
    private int pret;


    @Column(name = "sezon")
    private int sezon;

    @Column(name="is_active")
    private Boolean is_active=true;


    public int getSezon() {
        return sezon;
    }

    public void setSezon(int sezon) {
        this.sezon = sezon;
    }




    public Tricou(){}


    public Tricou( String name, String marime, int stock, Echipa echipa,int pret,int sezon){
        this.name=name;
        this.marime=marime;
        this.stock=stock;
        this.echipa=echipa;
        this.pret=pret;
        this.sezon=sezon;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setMarime(String marime) {
        this.marime = marime;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa echipa) {
        this.echipa = echipa;
    }


    public String getName() {
        return name;
    }

    public String getMarime() {
        return marime;
    }

    public int getStock() {
        return stock;
    }


    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tricou: " + name +
                (echipa != null ? ", Echipa ID: " + echipa.getId() : ", Fără echipă");
    }
}



