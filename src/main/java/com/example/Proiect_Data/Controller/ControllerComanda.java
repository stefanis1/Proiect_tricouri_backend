package com.example.Proiect_Data.Controller;


import com.example.Proiect_Data.Domain.Comanda;
import com.example.Proiect_Data.Service.ServiceComanda;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerComanda {

    private final ServiceComanda serviceComanda;

    public ControllerComanda(ServiceComanda serviceComanda){
        this.serviceComanda=serviceComanda;
    }

    @GetMapping(path = "/comanda")
    public Iterable<Comanda> ComandaHome (){
        return serviceComanda.getAll();
    }


    @PostMapping(path = "/comanda")
    public Iterable<Comanda> AddComanda(@RequestBody Comanda comanda ){
        serviceComanda.addComanda(comanda);

        return ComandaHome();
    }

    @DeleteMapping(path = "/comanda/{id}")
    public void DeleteComanda(@PathVariable Long id){serviceComanda.Detelecomanda(id);}
}
