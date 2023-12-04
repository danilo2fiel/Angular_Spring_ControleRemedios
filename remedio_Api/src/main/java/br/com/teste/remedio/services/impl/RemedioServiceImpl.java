package br.com.teste.remedio.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.teste.remedio.dtos.DtoLista;
import br.com.teste.remedio.dtos.DtoRemedio;
import br.com.teste.remedio.entities.Remedio;
import br.com.teste.remedio.repositories.RemedioRepository;
import br.com.teste.remedio.services.RemedioService;

@Service
public class RemedioServiceImpl implements RemedioService {

	@Autowired
	RemedioRepository repository;
	
	/**
	 * Método para retirar 7 comprimidos de cada estoque de remédio
	 * representando uma semana de uso.
	 * @return Lista atualizada de remédios.
	 */
	public ResponseEntity<List<DtoLista>> semana() {
	    List<Remedio> remedios = repository.findAll();
	    remedios.forEach(remedio -> remedio.setQuantidade(remedio.getQuantidade() - 7));
	    repository.saveAll(remedios);
	    var remedioLista = repository.findAll().stream().map(DtoLista::new).toList();
	    return ResponseEntity.ok().body(remedioLista);
	}	
	
	public ResponseEntity<Object> atualizarRemedio(Long id, Remedio dto) {
	    Optional<Remedio> optionalRemedio = repository.findById(id);
	    if (optionalRemedio.isPresent()) {
	        Remedio remedio = optionalRemedio.get();
	        remedio.setNome(dto.getNome());
	        remedio.setQuantidade(dto.getQuantidade());
	        remedio.setLaboratorio(dto.getLaboratorio());
	        remedio.setMedico(dto.getMedico());
	        dto.setId(id);
	        Remedio remedioAtualizado = repository.save(remedio);
	        return ResponseEntity.ok().body(remedioAtualizado);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<DtoRemedio> obterRemedio(Long id) {
        Optional<Remedio> optionalRemedio = repository.findById(id);
        return optionalRemedio.map(remedio -> ResponseEntity.ok(new DtoRemedio(remedio))).
        		orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	public ResponseEntity<List<DtoLista>> listarRemedios(){
		var remedio = repository.findAll().stream().map(DtoLista::new).toList();
		return ResponseEntity.ok().body(remedio);
	}
	
	public ResponseEntity<DtoRemedio> cadastrarRemedio (DtoRemedio dto) {
		Remedio remedio = repository.save(new Remedio (dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(new DtoRemedio(remedio));
	}
	
	public ResponseEntity<Object> deletarRemedio (Long id) {
		Optional<Remedio> optionalRemedio = repository.findById(id);
        if (optionalRemedio.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }      	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
