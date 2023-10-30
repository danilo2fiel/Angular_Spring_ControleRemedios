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
public class DtoLista {

	private String nome;
//	private Long quantidade;
	
	public DtoLista (Remedio dados) {
		this.nome = dados.getNome();
//		this.quantidade = dados.getQuantidade();	
	}
	
}
