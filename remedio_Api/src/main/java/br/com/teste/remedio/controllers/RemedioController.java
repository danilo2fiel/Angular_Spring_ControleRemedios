package br.com.teste.remedio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import br.com.teste.remedio.dtos.DtoLista;
import br.com.teste.remedio.dtos.DtoRemedio;
import br.com.teste.remedio.entities.Remedio;
import br.com.teste.remedio.services.RemedioService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/remedios")
public class RemedioController {
	
	private final RemedioService service;
	
	@Autowired
	public RemedioController (RemedioService service) {
		this.service = service;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<DtoRemedio> cadastrarRemedio (@RequestBody DtoRemedio dados){
		return service.cadastrarRemedio(dados);
	}
	
	@GetMapping
	@ApiOperation("Listar todos os remedios")
	public ResponseEntity<List<DtoLista>> listarRemedios(){
		return service.listarRemedios();
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation("Obter um remédio específico tendo como parâmetro o id")
	public ResponseEntity<DtoRemedio> obterRemedio (@PathVariable("id") Long id) {
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
	public ResponseEntity<List<DtoLista>> semana(){
		return service.semana();
	}
	
	@DeleteMapping ("/{id}")
	@Transactional
	public ResponseEntity<Object> deletarRemedio (@PathVariable Long id) {
		return service.deletarRemedio(id);
	}
}
