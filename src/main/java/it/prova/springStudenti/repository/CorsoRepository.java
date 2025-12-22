package it.prova.springStudenti.repository;

import it.prova.springStudenti.model.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
    @Query("select c from Corso c order by c.nome ASC")
    List<Corso> sortAllCorsi();

    @Modifying
    @Query("Update Corso c set c.cancellato = true where c.id = :id")
    void logicDelete (Long id);

    boolean existsByIdAndCancellatoIsFalse(Long id);

    @Query("select c from Corso c where c.cancellato = false")
    Set<Corso> findAllWhereCancellatoIsfalse();
}
