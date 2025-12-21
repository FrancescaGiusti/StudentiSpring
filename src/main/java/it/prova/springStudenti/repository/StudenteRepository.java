package it.prova.springStudenti.repository;

import it.prova.springStudenti.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long>{
    List<Studente> findAllByNomeLike(String nome);

    @Query("select s from Studente s join s.corsi c where c.nome = :nome")
    List<Studente> findAllByCorsoDiLaurea(@Param("nome") String nomeCorso);

    @Query("select s from Studente s order by s.dataDiNascita ASC")
    List<Studente> sortAllByDataDiNascita();
}
