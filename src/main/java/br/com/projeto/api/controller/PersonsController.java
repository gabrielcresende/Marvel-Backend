package br.com.projeto.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.domain.model.Comic;
import br.com.projeto.domain.model.Event;
import br.com.projeto.domain.model.Person;
import br.com.projeto.domain.model.Serie;
import br.com.projeto.domain.model.Storie;
import br.com.projeto.domain.repository.PersonRepository;

@RestController
@RequestMapping("/v1/characters")
public class PersonsController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping
	public List<Person> listar() {
		return personRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> buscar(@PathVariable Long id) {
		Optional<Person> person = personRepository.findById(id);

		if(person.isPresent())
			return ResponseEntity.ok(person.get());

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/comics")
	public ResponseEntity<Set<Comic>> buscarComics(@PathVariable Long id) {
		Optional<Person> person = personRepository.findById(id);

		if(person.isPresent())
			return ResponseEntity.ok(person.get().getComics());

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/events")
	public ResponseEntity<Set<Event>> buscarEvents(@PathVariable Long id) {
		Optional<Person> person = personRepository.findById(id);

		if(person.isPresent())
			return ResponseEntity.ok(person.get().getEvents());

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/series")
	public ResponseEntity<Set<Serie>> buscarSeries(@PathVariable Long id) {
		Optional<Person> person = personRepository.findById(id);

		if(person.isPresent())
			return ResponseEntity.ok(person.get().getSeries());

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/stories")
	public ResponseEntity<Set<Storie>> buscarStories(@PathVariable Long id) {
		Optional<Person> person = personRepository.findById(id);

		if(person.isPresent())
			return ResponseEntity.ok(person.get().getStories());

		return ResponseEntity.notFound().build();
	}
}