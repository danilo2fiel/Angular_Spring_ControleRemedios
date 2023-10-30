package br.com.teste.remedio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.remedio.dtos.DtoLista;
import br.com.teste.remedio.dtos.DtoRemedio;
import br.com.teste.remedio.entities.Remedio;
import br.com.teste.remedio.repositories.RemedioRepository;
import br.com.teste.remedio.services.RemedioService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/remedios")
public class RemedioController {
	
	@Autowired
	RemedioService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastro (@RequestBody DtoRemedio dados){
		return service.cadastrarRemedio(dados);
	}
	
	@GetMapping
	@ApiOperation("Listar todos os remedios")
	public ResponseEntity<List<DtoRemedio>> listarRemedios(){
		return service.listarRemedios();
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation("Obter um remédio específico tendo como parâmetro o id")
	public ResponseEntity<Object> obterRemedio (@PathVariable Long id) {
		return service.obterRemedio(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> editarRemedio (@PathVariable Long id, @RequestBody Remedio dto){
		return service.atualizarRemedio(id, dto);
	}
	
	@PutMapping("/semana")
	@Transactional
	@ApiOperation("Retirar 7 comprimidos de cada remedio da lista representando uma semana de uso ")
	public ResponseEntity<List<Remedio>> semana(){
		return service.semana();
	}
	
	@DeleteMapping ("/{id}")
	@Transactional
	public ResponseEntity deletarRemedio (@PathVariable Long id) {
		return service.deletarRemedio(id);
	}
}
