package br.com.teste.remedio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.remedio.dtos.DtoRemedio;
import br.com.teste.remedio.entities.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {

	Remedio findByNome(String nome);

	Object save(DtoRemedio dados);

	void save(Class<? extends Remedio> class1);

	void save(Long id);

	

}
