package com.libros.librosback.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.libros.librosback.Models.UserModel;
import com.libros.librosback.Services.LoginServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("/auth")

public class LoginController {
    @Autowired

    private LoginServices loginServices;
   
    @PostMapping("/login")
    public ResponseEntity<UserModel> loginUsuario(@RequestBody UserModel us) {
        UserModel foundUser = loginServices.getUsuario(us.getId_usuario());

        if(foundUser != null) {
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        
    }
    
}
