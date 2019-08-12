package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.model.ipvigilante.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer>{

}
