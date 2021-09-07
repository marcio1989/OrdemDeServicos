package com.marcio.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcio.os.domain.Tecnico;
import com.marcio.os.repositories.TecnicoRepository;
import com.marcio.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	//buscando técnico no BD
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ", Tipo: " + Tecnico.class.getName()));
	}
	
	//retornando uma lista de tecnicos
	public List<Tecnico> findAll() {
		return repository.findAll();
	}
}
