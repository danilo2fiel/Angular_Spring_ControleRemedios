package br.com.teste.remedio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.teste.remedio.dtos.DtoRemedio;
import br.com.teste.remedio.entities.Remedio;
import br.com.teste.remedio.repositories.RemedioRepository;

@Service
public class RemedioService {

	@Autowired
	RemedioRepository repository;
	
	//private List<Remedio> remedios = new ArrayList<>();
	
	public ResponseEntity<List<Remedio>> semana() {
		List<Remedio> remedios = repository.findAll();
		for (Remedio remedio : remedios) {
			remedio.setQuantidade(remedio.getQuantidade()-7); 
		}
		
		repository.saveAll(remedios);
		return ResponseEntity.ok().body(remedios);
	}
	
	public ResponseEntity<Object> atualizarRemedio(Long id, Remedio dto){
		var remedio = repository.findById(id).orElse(null);
		if(remedio != null) {
			remedio.setNome(dto.getNome());
			remedio.setQuantidade(dto.getQuantidade());
			dto.setId(id);
			
			Remedio remedios = repository.save(dto);
			
			return new ResponseEntity<>(remedios, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<Object> obterRemedio(Long id) {
        var remedio = repository.findById(id);
        if(!remedio.isEmpty()) 
        	return ResponseEntity.ok().body(remedio);    
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<List<DtoRemedio>> listarRemedios(){
		var remedio = repository.findAll().stream().map(DtoRemedio::new).toList();
		return ResponseEntity.ok().body(remedio);
	}
	
	
	
	/**
	 * Método para cadastro de novos remédios
	 * 
	 * @param dto
	 * @return O remédio cadastrado.
	 */
	public ResponseEntity<Object> cadastrarRemedio (DtoRemedio dto) {
		var remedio = repository.save(new Remedio (dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(remedio);
	}
	
	public ResponseEntity deletarRemedio (Long id) {
		var remedio = repository.findById(id);
        if(!remedio.isEmpty()) {
        	repository.deleteById(id); 
        	return ResponseEntity.ok().body(null);
        }      	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
