package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Corso;
import java.util.List;
import java.util.Set;

public interface CorsoService {
    Set<Corso> getAll();
    Corso findById(Long id);
    void aggiungiCorso(Corso corso);
    void modificaCorso(Corso corso);
    void eliminaCorso(Long id);
    List<Corso> ordinaPerNome();
    void eliminazioneLogicaCorso(Long idCorso);
}
