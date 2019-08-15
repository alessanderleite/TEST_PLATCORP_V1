package br.com.alessanderleite.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.ipvigilante.Localizacao;
import br.com.alessanderleite.repository.LocalizacaoRepository;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {

	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@Override
	public Iterable<Localizacao> listAll() {
		return localizacaoRepository.findAll();
	}

	@Override
	public Localizacao getById(Integer id) throws IOException {
		Optional<Localizacao> localizacao = localizacaoRepository.findById(id);
		localizacao.orElseThrow(() -> new IOException("Não foi possível localizar o id " + id));
		
		return localizacao.get();
	}

	@Override
	public Localizacao save(Localizacao entity) {
		return localizacaoRepository.save(entity);
	}

	@Override
	public void delete(Integer id) throws IOException {
		Optional<Localizacao> localizacao = localizacaoRepository.findById(id);
		if (!localizacao.isPresent()) {
			throw new IOException("Não foi possível localizar o id " + id);
		}
		localizacaoRepository.deleteById(id);
	}

	@Override
	public Localizacao update(Localizacao entity) throws IOException {
		Localizacao localizacao = getById(entity.getId());
		if (localizacao != null) {
			return localizacaoRepository.save(entity);
		}
		return null;
	}
}
