package br.com.alessanderleite.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.ipvigilante.LocalizacaoModel;
import br.com.alessanderleite.repository.LocalizacaoRepository;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {

	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@Override
	public Iterable<LocalizacaoModel> listAll() {
		return localizacaoRepository.findAll();
	}

	@Override
	public LocalizacaoModel getById(Integer id) throws IOException {
		Optional<LocalizacaoModel> localizacao = localizacaoRepository.findById(id);
		localizacao.orElseThrow(() -> new IOException("Não foi possível localizar o id " + id));
		
		return localizacao.get();
	}

	@Override
	public LocalizacaoModel save(LocalizacaoModel entity) {
		return localizacaoRepository.save(entity);
	}

	@Override
	public void delete(Integer id) throws IOException {
		Optional<LocalizacaoModel> localizacao = localizacaoRepository.findById(id);
		if (!localizacao.isPresent()) {
			throw new IOException("Não foi possível localizar o id " + id);
		}
		localizacaoRepository.deleteById(id);
	}

	@Override
	public LocalizacaoModel update(LocalizacaoModel entity) throws IOException {
		LocalizacaoModel localizacao = getById(entity.getId());
		if (localizacao != null) {
			return localizacaoRepository.save(entity);
		}
		return null;
	}
}
