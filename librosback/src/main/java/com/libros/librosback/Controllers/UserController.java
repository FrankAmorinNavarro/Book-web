package com.libros.librosback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.libros.librosback.Models.UserModel;
import com.libros.librosback.Services.LoginServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginServices loginServices;

    //Muestra una lista de usuarios
    @GetMapping("/users")
    public List <UserModel> getAllUsuarios(){
        return loginServices.listUsuarios();
    }
    
    //Muestra el usuario por el id
    @GetMapping("/{id}")
    public UserModel getUsuario(@RequestParam Long id) {
        return loginServices.getUsuario(id);
    }

    @PostMapping
    public UserModel saveUsuario(@RequestBody UserModel us) {
        return loginServices.saveUsuario(us);
    }

    @PutMapping("/{id}")
    public UserModel updateUsario(@PathVariable Long id, @RequestBody UserModel us) {
        us.setId_usuario(id);
        
        return loginServices.updateUsuario(us);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id){
        loginServices.deleteUsuario(id);
    }
    
    
}
