package it.prova.springStudenti.repository;

import it.prova.springStudenti.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query(value = "insert into studenti_corsi(corso_id, studente_id) values ( :idCorso, :idStudente)", nativeQuery = true)
    void addStudentToCourse(Long idStudente, Long idCorso);

    @Modifying
    @Query(value = "delete from studenti_corsi sc where sc.corso_id = :idCorso AND sc.studente_id = :idStudente", nativeQuery = true)
    void deleteStudenteFromCourse(Long idStudente, Long idCorso);

    @Query("select s from Studente s join fetch s.corsi where s.id = :idStudente")
    Studente studentByIdEager (Long idStudente);
}
