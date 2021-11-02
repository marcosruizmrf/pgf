package com.univesp.pgf.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.univesp.pgf.domain.Pgf;
import com.univesp.pgf.services.PgfService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pgfs")
public class PgfResource {

	@Autowired
	private PgfService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pgf> findById(@PathVariable Integer id) {
		Pgf obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Pgf>> listOpen() {
		List<Pgf> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/close")
	public ResponseEntity<List<Pgf>> listClose() {
		List<Pgf> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping
	public ResponseEntity<List<Pgf>> listAll() {
		List<Pgf> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Pgf> create(@RequestBody Pgf obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pgf> update(@PathVariable Integer id, @RequestBody Pgf obj) {
		Pgf newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
