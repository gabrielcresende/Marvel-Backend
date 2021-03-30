package br.com.projeto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.domain.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
