package it.prova.springStudenti.repository;

import it.prova.springStudenti.model.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
    @Query("select c from Corso c order by c.nome ASC")
    List<Corso> sortAllCorsi();
}
