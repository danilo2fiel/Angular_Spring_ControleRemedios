package br.com.teste.remedio.dtos;

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
	
	public DtoRemedio(Remedio dados) {
		super();
		this.nome = dados.getNome();
		this.quantidade = dados.getQuantidade();
		this.id = dados.getId();
	}
	
	
	
	
	
	
}
