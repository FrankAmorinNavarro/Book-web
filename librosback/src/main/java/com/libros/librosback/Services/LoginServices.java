package com.libros.librosback.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libros.librosback.Models.UserModel;
import com.libros.librosback.Repositories.UserRepository;

@Service
public class LoginServices {
        @Autowired
        
        private UserRepository userRepository;

        //Listar
        public List<UserModel> listUsuarios(){
            return userRepository.findAll();
        }

        //buscar por id
        public UserModel getUsuario(Long id){
            Optional <UserModel> userOptional = userRepository.findById(id);
            return userOptional.orElseThrow(() -> new NoSuchElementException("Usuario no Encontrado")); 
        }

        //guardar
        public UserModel saveUsuario(UserModel us){   
            return userRepository.save(us); 
        }

        //actualizar(realizar excepcion)
        public UserModel updateUsuario(UserModel us){    

            if(!userRepository.existsById(us.getId_usuario())){
                throw new NoSuchElementException("Usuario no encontrado");
            }

            return userRepository.save(us);
        }

        //eliminar(realizar excepcion)
        public void deleteUsuario(Long id){

            if(!userRepository.existsById(id)){
                throw new NoSuchElementException("Usuario no encontrado");
            }

            userRepository.deleteById(id);
        }
        
}
