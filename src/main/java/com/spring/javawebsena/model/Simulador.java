package com.spring.javawebsena.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table (name="TB_SIMULADOR") //NOME TABELA NO BANCO
public class Simulador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String projeto;
	@NotBlank
	private String area;
	private int acessosDia;
	private double sla;
	private int periodo;
	private int quantidadeReqs;
	private double vazaoRps;
	private double quantidadeVus;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate date;
	
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getAcessosDia() {
		return acessosDia;
	}
	public void setAcessosDia(int acessosDia) {
		this.acessosDia = acessosDia;
	}
	public double getSla() {
		return sla;
	}
	public void setSla(double d) {
		this.sla = d;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public int getQuantidadeReqs() {
		return quantidadeReqs;
	}
	public void setQuantidadeReqs(int quantidadeReqs) {
		this.quantidadeReqs = quantidadeReqs;
	}
	public double getVazaoRps() {
		return vazaoRps;
	}
	public void setVazaoRps(double vazaoRps) {
		this.vazaoRps = vazaoRps;
	}
	public double getQuantidadeVus() {
		return quantidadeVus;
	}
	public void setQuantidadeVus(double quantidadeVus) {
		this.quantidadeVus = quantidadeVus;
	}
	
	
}