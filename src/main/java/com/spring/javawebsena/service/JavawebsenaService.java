package com.spring.javawebsena.service;

import java.util.List;


import com.spring.javawebsena.model.Simulador;

public interface JavawebsenaService {
	
	List<Simulador> findAll();
	Simulador findById(long id);
	Simulador save(Simulador simulador);
	void delete(Simulador simulador);
}
