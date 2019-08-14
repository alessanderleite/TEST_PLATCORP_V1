package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.model.HistoricoModel;

public interface ClienteTemperaturaRepository extends JpaRepository<HistoricoModel, Integer>{
	
}
