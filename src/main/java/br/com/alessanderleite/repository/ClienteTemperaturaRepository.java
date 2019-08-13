package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.model.ClienteTemperatura;

public interface ClienteTemperaturaRepository extends JpaRepository<ClienteTemperatura, Integer>{
	
}
