package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.model.ipvigilante.DataModel;

public interface DataRepository extends JpaRepository<DataModel, Integer>{

}
