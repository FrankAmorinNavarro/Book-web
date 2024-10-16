package com.libros.librosback.Repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libros.librosback.Models.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

    Optional <UserModel> findById(Long id_usuario); 

}
