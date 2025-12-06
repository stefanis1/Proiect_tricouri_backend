package com.example.Proiect_Data.Controller;


import com.example.Proiect_Data.Domain.Echipa;
import com.example.Proiect_Data.Domain.User;
import com.example.Proiect_Data.Service.ServiceUser;
import org.springframework.web.bind.annotation.*;


@RestController
public class ControllerUser {

    private final ServiceUser serviceUser;

    public ControllerUser(ServiceUser serviceUser){
        this.serviceUser=serviceUser;
    }

    @GetMapping(path = "/user")
    public Iterable<User> HomeUser(){

        return serviceUser.getAll();
    }

    @GetMapping(path  ="/user/{id}")
    public User getUser(@PathVariable Long id){
        return serviceUser.GetByIdUser(id);

    }

    @PostMapping(path = "/user")
    public Iterable<User> addUser(@RequestBody User newUser){

        serviceUser.add_User(newUser);
        return HomeUser();

     }

     @DeleteMapping(path = "/user/{id}")
    public Iterable<User> deleteUser(@PathVariable long id){
        serviceUser.deleteUser(id);
        return HomeUser();
     }

     @PutMapping(path = "/user/{id}")
    public Iterable<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {

        serviceUser.updateUser(id,newUser);
        return HomeUser();

     }


}
