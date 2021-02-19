package com.spring.javawebsena.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.javawebsena.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByLogin(String login);

}
