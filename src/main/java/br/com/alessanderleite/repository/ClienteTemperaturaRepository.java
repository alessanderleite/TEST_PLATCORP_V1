package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.model.ClienteTemperatura;

@Repository
public interface ClienteTemperaturaRepository extends JpaRepository<ClienteTemperatura, Long>{
	
}
