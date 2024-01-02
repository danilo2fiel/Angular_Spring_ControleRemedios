package br.com.teste.remedio.dtos;

import javax.persistence.Column;

import br.com.teste.remedio.entities.Remedio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoRemedio {

	private String nome;
	private Long quantidade;
	private Long id;
	private String laboratorio;
	private String medico;
	
	public DtoRemedio(Remedio remedio) {
		this.nome = remedio.getNome();
		this.quantidade = remedio.getQuantidade();
		this.id = remedio.getId();
		this.laboratorio = remedio.getLaboratorio();
		this.medico = remedio.getMedico();
	}
	
}
