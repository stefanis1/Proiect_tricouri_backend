package com.example.Proiect_Data.Controller;


import com.example.Proiect_Data.Domain.Tricou;
import com.example.Proiect_Data.Service.ServiceEchipa;
import com.example.Proiect_Data.Service.ServiceTricou;
import org.springframework.web.bind.annotation.*;


@RestController
public class ControllerTricou {

    private final ServiceTricou serviceTricou;

    public ControllerTricou(ServiceTricou serviceTricou){
        this.serviceTricou=serviceTricou;
    }

    @GetMapping(path = "/tricou")
    public Iterable<Tricou> HomeTricou(){
        return serviceTricou.getAll();
    }

    @GetMapping(path = "/tricou/{id}")
    public Tricou getTricou(@PathVariable Long id ){
            return serviceTricou.getByIdTricou(id);
}

    @DeleteMapping(path = "/tricou/{id}")
    public Iterable<Tricou> deleteTricou(@PathVariable Long id) {
        serviceTricou.deleteTricou(id);
        return HomeTricou();

    }

    @PostMapping(path="/tricou")
    public Tricou addTricou(@RequestBody Tricou tricou){
        return serviceTricou.addTricou(tricou);

    }

    @PutMapping(path = "/tricou/{id}")
    public Iterable<Tricou> updateTricou(@PathVariable Long id, @RequestBody Tricou newtricou){
        serviceTricou.updateTricou(id,newtricou);

        return HomeTricou();
    }

    @PutMapping(path = "/tricouURL/{id}")
    public Tricou updateURLTricou(@PathVariable Long id , @RequestBody String url) {
        serviceTricou.updateUrl(id,url);

        return serviceTricou.getByIdTricou(id);

    }

    @PutMapping(path = "/tricouName/{id}")
    public Tricou updateNameTricou(@PathVariable Long id, @RequestBody String name ){
       return  serviceTricou.UpdateNameTricou(id,name);
    }

    @PutMapping(path = "/tricouNameEchipa/{id}")
    public Tricou updateNameEchipa(@PathVariable Long id, @RequestBody String  idEchipaString){
        return serviceTricou.UpdateNameEchipa(id,idEchipaString);
    }

    @PutMapping(path="/tricouPrice/{id}")
    public Tricou updatePriceEchipa(@PathVariable Long id, @RequestBody String price){
        return  serviceTricou.UpdatePrice(id,price);
    }
}
