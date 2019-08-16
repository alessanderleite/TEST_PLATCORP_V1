package br.com.alessanderleite.businessobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alessanderleite.model.Historico;
import br.com.alessanderleite.service.HistoricoService;
import br.com.alessanderleite.valueobject.DataGeoVO;
import br.com.alessanderleite.valueobject.HistoricoVO;

@Component
public class HistoricoBO {

	@Autowired
	private HistoricoService historicoService;
	
	public HistoricoVO buscarById(Integer id) {
		try {
			Historico historico = historicoService.getById(id);
			return buildHistoricoVO(historico);
		} catch (Exception e) {
			throw new RuntimeException("Id não localizado");
		}
	}
	
	public List<HistoricoVO> listaHistoricos() {
		try {
			Iterable<Historico> historicos = historicoService.listAll();
			List<HistoricoVO> lista = new ArrayList<HistoricoVO>();
			historicos.forEach(cliente -> lista.add(buildHistoricoVO(cliente)));
			return lista;
		} catch (Exception e) {
			throw new RuntimeException("Dados nao localizados");
		}
	}
	
	private HistoricoVO buildHistoricoVO(Historico historico) {
		if (!Optional.ofNullable(historico).isPresent()) {
			return null;
		}
		HistoricoVO retorno = new HistoricoVO(historico.getId(), historico.getMinTemp(), historico.getMaxTemp(), new DataGeoVO(historico.getLocalizacao()));
		return retorno;
	}
}
