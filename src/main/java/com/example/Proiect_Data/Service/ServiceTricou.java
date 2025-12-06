package com.example.Proiect_Data.Service;

import com.example.Proiect_Data.Domain.Echipa;
import com.example.Proiect_Data.Domain.Tricou;
import com.example.Proiect_Data.Repository.RepoEchipa;
import com.example.Proiect_Data.Repository.RepoTricou;
import org.springframework.stereotype.Service;

@Service
public class ServiceTricou {


    private final RepoTricou repoTricou;
    private final RepoEchipa repoEchipa;
    private final  ServiceEchipa serviceEchipa;




    public ServiceTricou(RepoTricou repoTricou, ServiceEchipa serviceEchipa,RepoEchipa repoEchipa){
        this.repoTricou=repoTricou;
        this.repoEchipa=repoEchipa;
        this.serviceEchipa =serviceEchipa;
    }


    public  Iterable<Tricou> getAll(){return repoTricou.findAll();}

    public Long size() {
        return repoTricou.count();
    }

    public void deleteTricou(Long id){
       Tricou tricou= getByIdTricou(id);
       tricou.setIs_active(false);
       repoTricou.deleteById(id);

//       repoTricou.save(tricou);
    }

    public Tricou getByIdTricou(Long id) {
        return repoTricou.findById(id).orElse(null);
    }

    public Tricou updateTricou(Long id,Tricou newTricou){
        Tricou oldTricou =getByIdTricou(id);
        if(newTricou.getEchipa().getId()!=null) {

            Echipa newEchipa = serviceEchipa.FindById(newTricou.getEchipa().getId());

            if (newEchipa != null) {
                oldTricou.setEchipa(newEchipa);
            }else System.out.println("Echipa cu id-ul "+newTricou.getEchipa().getId()+" nu exista");

        }else{ System.out.println("nu se modifica echipa ");}

        oldTricou.setMarime(newTricou.getMarime());

        oldTricou.setName(newTricou.getName());

        oldTricou.setPret(newTricou.getPret());

        oldTricou.setSezon(newTricou.getSezon());

        oldTricou.setStock(newTricou.getStock());

        oldTricou.setIs_active(newTricou.getIs_active());

        repoTricou.save(oldTricou);

        return oldTricou;
    }


    public Tricou updateUrl( Long id ,String url ){
        Tricou tricou=repoTricou.findById(id).orElse(null);
            tricou.setUrl(url);

        repoTricou.save(tricou);

        return tricou;

    }


    public Tricou addTricou(Tricou t ){
        Echipa echipa= t.getEchipa();
        Long idEchipa=echipa.getId();

        if(idEchipa!=null){
            boolean existEchipa=repoEchipa.existsById(idEchipa);
            if(!existEchipa){
                Echipa echipaBazaDeDate=repoEchipa.findById(idEchipa).orElse(null);
                echipa=echipaBazaDeDate;

            }
            repoTricou.save(t);
        }
        return t;
    }


    public Tricou UpdateNameTricou(Long id ,String nume){

        Tricou t= repoTricou.findById(id).orElse(null);
        t.setName(nume);
        repoTricou.save(t);

        return t;
    }

    public Tricou UpdateNameEchipa(Long id,String idEchipaString){
        Tricou t =repoTricou.findById(id).orElse(null);
        Long idEchipa=Long.parseLong(idEchipaString);
        Echipa echipa=repoEchipa.findById(idEchipa).orElse(null);
        t.setEchipa(echipa);

        repoTricou.save(t);

        return t;
    }


    public Tricou UpdatePrice (Long id, String priceString){
        Tricou t=repoTricou.findById(id).orElse(null);
        int price=Integer.parseInt(priceString);
        t.setPret(price);

        repoTricou.save(t);

        return t;
    }
}
