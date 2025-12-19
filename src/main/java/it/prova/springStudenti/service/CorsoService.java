package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Corso;
import java.util.List;

public interface CorsoService {
    List<Corso> getAll();
    Corso findById(Long id);
    void aggiungiCorso(Corso corso);
    void modificaCorso(Corso corso);
    void eliminaCorso(Long id);
}
