package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.model.ipvigilante.Data;

public interface DataRepository extends JpaRepository<Data, Integer>{

}
