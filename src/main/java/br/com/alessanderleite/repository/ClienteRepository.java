package br.com.alessanderleite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alessanderleite.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer>{
	Optional<ClienteModel> findById(Integer id);
}
