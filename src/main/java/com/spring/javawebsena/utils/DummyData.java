package com.spring.javawebsena.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.javawebsena.model.Simulador;
import com.spring.javawebsena.repository.JavaWebSenaRepository;

@Component
public class DummyData {
	
	@Autowired
	JavaWebSenaRepository javawebsenaRepository;  //ponto de injeção
	
	//@PostConstruct//(Incrementa Novos Registros no Banco)
	public void saveSimulador() {
		
		 List<Simulador> simuladorList = new ArrayList<>();
		 Simulador simulador1 = new Simulador();
	        simulador1.setProjeto("sre-coe-teste-danilo");
	        simulador1.setArea("Teste1");
	        simulador1.setDate(LocalDate.now());
	        simulador1.setAcessosDia(1000);
	        simulador1.setSla(0.0333);		//2 segundos
	        simulador1.setPeriodo(8);		// 8 ou 6 (Horas)

	        simuladorList.add(simulador1);

	        for(Simulador simulador: simuladorList){
	        	Simulador simuladorSaved = javawebsenaRepository.save(simulador);
	            System.out.println(simuladorSaved.getId());

	        }

	}
}