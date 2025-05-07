package com.ronaldosantos.crudclientes.dto;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.ronaldosantos.crudclientes.entities.Client;

public class ClientDTO {
	
	private Long id;
	
	
	private String name;
	private String cpf;
	private Double income;
	
	
	private LocalDate birthDate;
	private Integer children;
	
	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	public ClientDTO() {
		
	}
	
	public ClientDTO(Client entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}
	
}
