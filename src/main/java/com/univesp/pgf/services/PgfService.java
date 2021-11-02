package com.univesp.pgf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univesp.pgf.domain.Pgf;
import com.univesp.pgf.repositories.PgfRepository;
import com.univesp.pgf.services.exceptions.ObjectNotFoundException;

@Service
public class PgfService {

	@Autowired
	private PgfRepository repository;

	public Pgf findById(Integer id) {
		Optional<Pgf> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pgf.class.getName()));
	}

	public List<Pgf> findAllOpen() {
		List<Pgf> list = repository.findAllOpen();
		return list;
	}

	public List<Pgf> findAllClose() {
		List<Pgf> list = repository.findAllClose();
		return list;
	}

	public List<Pgf> findAll() {
		List<Pgf> list = repository.findAll();
		return list;
	}

	public Pgf create(Pgf obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Pgf update(Integer id, Pgf obj) {
		Pgf newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}

}