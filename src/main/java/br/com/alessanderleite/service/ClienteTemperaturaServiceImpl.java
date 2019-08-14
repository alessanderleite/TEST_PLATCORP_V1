package br.com.alessanderleite.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.HistoricoModel;
import br.com.alessanderleite.repository.ClienteTemperaturaRepository;

@Service
public class ClienteTemperaturaServiceImpl implements ClienteTemperaturaService{

	@Autowired 
	ClienteTemperaturaRepository clienteTemperaturaRepository;

	@Override
	public Iterable<HistoricoModel> listAll() {
		return clienteTemperaturaRepository.findAll();
	}

	@Override
	public HistoricoModel getById(Integer id) throws IOException {
		Optional<HistoricoModel> clienteTemperatura = clienteTemperaturaRepository.findById(id);
		clienteTemperatura.orElseThrow(() -> new IOException("Não foi possível localizar o id " + id));
		
		return clienteTemperatura.get();
	}

	@Override
	public HistoricoModel save(HistoricoModel entity) {
		return clienteTemperaturaRepository.save(entity);
	}

	@Override
	public void delete(Integer id) throws IOException {
		Optional<HistoricoModel> clienteTemperatura = clienteTemperaturaRepository.findById(id);
		if (!clienteTemperatura.isPresent()) {
			throw new IOException("Não foi possível localizar o id " + id);
		}
		clienteTemperaturaRepository.deleteById(id);
	}

	@Override
	public HistoricoModel update(HistoricoModel entity) throws IOException {
		HistoricoModel clienteTemperatura = getById(entity.getId());
		if (clienteTemperatura != null) {
			return clienteTemperaturaRepository.save(entity);
		}
		return null;
	}

}
