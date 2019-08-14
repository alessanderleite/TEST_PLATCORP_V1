package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.model.ipvigilante.LocalizacaoModel;

public interface LocalizacaoRepository extends JpaRepository<LocalizacaoModel, Integer>{

}
