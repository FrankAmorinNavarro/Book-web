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
@RequestMapping("auth")
public class RegisterController {
    
    @Autowired
    private LoginServices loginServices;

    @PostMapping("/regis")
    public ResponseEntity<UserModel> registerUsuario(@RequestBody UserModel us) {
        
        UserModel saveUsers = loginServices.saveUsuario(us);
        
        //Retorna el nuevo usuario aiiius
        return new ResponseEntity<>(saveUsers, HttpStatus.CREATED);
    }
    
}
