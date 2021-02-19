package com.spring.javawebsena.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.javawebsena.model.Simulador;
import com.spring.javawebsena.repository.JavaWebSenaRepository;
import com.spring.javawebsena.service.JavawebsenaService;

@Service
public class JavawebsenaServiceImpl implements JavawebsenaService{
	
	@Autowired
	JavaWebSenaRepository javawebsenaRepository;
	
	@Override
	public List<Simulador> findAll() {
		return javawebsenaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public Simulador findById(long id) {
		return javawebsenaRepository.findById(id).get();
	}
	
	@Override
	public Simulador save(Simulador simulador) {
		return javawebsenaRepository.save(simulador);
	}

	@Override
	public void delete(Simulador simulador) {
		javawebsenaRepository.delete(simulador);
	}
}
