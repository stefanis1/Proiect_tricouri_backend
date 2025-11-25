package com.example.Proiect_Data.Service;


import com.example.Proiect_Data.Domain.Comanda;
import com.example.Proiect_Data.Domain.Detalii_Comanda;
import com.example.Proiect_Data.Domain.Tricou;
import com.example.Proiect_Data.Domain.User;
import com.example.Proiect_Data.Exception.ExceptionComanda;
import com.example.Proiect_Data.Repository.RepoComanda;
import com.example.Proiect_Data.Repository.RepoTricou;
import com.example.Proiect_Data.Repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceComanda {


    private final RepoComanda repoComanda;

    private final RepoTricou repoTricou;

    private  final RepoUser repoUser;


    public ServiceComanda(RepoComanda repoComanda,RepoUser repoUser,RepoTricou repoTricou){
        this.repoComanda=repoComanda;
        this.repoUser=repoUser;
        this.repoTricou=repoTricou;
    }

    @Transactional
    public void addComanda(Comanda comanda ){

        User ExistUser =comanda.getUser();
        if(ExistUser.getId()!= null)
        {
            Long Userid=ExistUser.getId();
            if(repoUser.existsById(Userid)){
               User UserRepo=repoUser.findById(Userid).orElse(null);
                comanda.setUser(UserRepo);

                List<Detalii_Comanda> detaliiComanda= comanda.getDetaliiComanda();

                for (Detalii_Comanda detaliiComandaOrder : detaliiComanda) {
                    Long tricouId =detaliiComandaOrder.getTricou().getId();
                    Tricou tricouStock=repoTricou.findById(tricouId).orElse(null);
                    if(tricouStock==null || !tricouStock.getIs_active()){
                        throw new RuntimeException("Tricoul cu id-ul cerut nu exista ");
                    }

                    if(detaliiComandaOrder.getCantitate()>tricouStock.getStock()) {
                        throw new ExceptionComanda("Cererea e mai mare decat stock-ul ");
                    }

                       tricouStock.setStock(tricouStock.getStock() - detaliiComandaOrder.getCantitate());
                       repoTricou.save(tricouStock);

                    detaliiComandaOrder.setTricou(tricouStock);
                    detaliiComandaOrder.setComanda(comanda);
                }
                repoComanda.save(comanda);
            }else {throw new ExceptionComanda("Nu exista user-ul cu id acesta");}
        }
        else {throw new ExceptionComanda("Id ul trebuie sa fie un nr");}


    }

    public Iterable<Comanda> getAll(){return repoComanda.findAll();}

    public void Detelecomanda(Long id){repoComanda.deleteById(id);}

}
