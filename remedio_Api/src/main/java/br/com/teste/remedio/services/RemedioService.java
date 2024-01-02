package br.com.teste.remedio.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.teste.remedio.dtos.DtoLista;
import br.com.teste.remedio.dtos.DtoRemedio;
import br.com.teste.remedio.entities.Remedio;

public interface RemedioService {
	
	public ResponseEntity<List<DtoLista>> semana();
	
	public ResponseEntity<Object> atualizarRemedio(Long id, Remedio dto);
	
	public ResponseEntity<DtoRemedio> obterRemedio(Long id);
	
	public ResponseEntity<List<DtoLista>> listarRemedios();
	
	public ResponseEntity<DtoRemedio> cadastrarRemedio (DtoRemedio dto);
	
	public ResponseEntity<Object> deletarRemedio (Long id);

}
