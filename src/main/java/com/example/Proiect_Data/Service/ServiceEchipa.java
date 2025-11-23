package com.example.Proiect_Data.Service;

import com.example.Proiect_Data.Domain.Echipa;
import com.example.Proiect_Data.Repository.RepoEchipa;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceEchipa {

    private final  RepoEchipa repoEchipa;
    public ServiceEchipa(RepoEchipa repo1){
        this.repoEchipa =repo1;
    }

    public Iterable<Echipa> getAll1(){
        return  repoEchipa.findAll();
    }

    public Echipa add_echipa(Echipa echipa ){
       return  repoEchipa.save(echipa);
    }

    public Echipa FindById(Long id ){
        return repoEchipa.findById(id).orElse(null);
    }

    public void deleteEchipa(Long id){
         repoEchipa.deleteById(id);
    }

    public void updateEchipa(Long id ,Echipa echipa ){
        Echipa oldechipa=FindById(id);
        oldechipa.setName(echipa.getName());
        oldechipa.setTara(echipa.getTara());

        repoEchipa.save(oldechipa);
    }
}
