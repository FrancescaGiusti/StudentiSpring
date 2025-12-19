package it.prova.springStudenti.repository;

import it.prova.springStudenti.model.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
}
