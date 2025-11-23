package com.example.Proiect_Data.Service;

import com.example.Proiect_Data.Domain.Echipa;
import com.example.Proiect_Data.Domain.Tricou;
import com.example.Proiect_Data.Repository.RepoTricou;
import org.springframework.stereotype.Service;

@Service
public class ServiceTricou {


    private final RepoTricou repoTricou;
    private final  ServiceEchipa serviceEchipa;




    public ServiceTricou(RepoTricou repoTricou, ServiceEchipa serviceEchipa){
        this.repoTricou=repoTricou;
        this.serviceEchipa =serviceEchipa;
    }

    public void add_Tricou(Tricou e)
    {
        repoTricou.save(e);
    }

    public  Iterable<Tricou> getAll(){return repoTricou.findAll();}

    public Long size() {
        return repoTricou.count();
    }

    public void deleteTricou(Long id){
       Tricou tricou= getByIdTricou(id);
       tricou.setIs_active(false);

       repoTricou.save(tricou);
    }

    public Tricou getByIdTricou(Long id) {
        return repoTricou.findById(id).orElse(null);
    }

    public Tricou updateTricou(Long id,Tricou newTricou){
        Tricou oldTricou =getByIdTricou(id);
        if(newTricou.getEchipaId()!=null) {

            Echipa newEchipa = serviceEchipa.FindById(newTricou.getEchipaId());

            if (newEchipa != null) {
                oldTricou.setEchipa(newEchipa);
            }else System.out.println("Echipa cu id-ul "+newTricou.getEchipaId()+" nu exista");

        }else{ System.out.println("nu se modifica echipa ");}

        oldTricou.setMarime(newTricou.getMarime());

        oldTricou.setName(newTricou.getName());

        oldTricou.setPret(newTricou.getPret());

        oldTricou.setSezon(newTricou.getSezon());

        oldTricou.setStock(newTricou.getStock());

        repoTricou.save(oldTricou);

        return oldTricou;
    }
}
