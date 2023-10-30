package br.com.teste.remedio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.teste.remedio.dtos.DtoRemedio;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Remedio {

	@Id
	@Column(name = "rem_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "rem_nome")
	private String nome;
	@Column(name = "rem_quant")
	private Long quantidade;
	
	public Remedio (DtoRemedio dados) {
		this.nome = dados.getNome();
		this.quantidade = dados.getQuantidade();
		this.id = dados.getId();
	}
	
	

}
