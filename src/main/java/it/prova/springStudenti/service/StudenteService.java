package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Studente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudenteService {
    List<Studente> getAll();
    Studente findById(Long id);
    void aggiungiStudente(Studente studente);
    void modificaStudente(Studente studente);
    void eliminaStudente(Long id);
    List<Studente> trovaPerNomeCheIniziaCon(String nome);
    List<Studente> cercaTuttiInBaseAlCorsoDiLaurea(String corsoDiLaurea);
    List<Studente> ordinaTuttiInBaseAllaDataDiNAscita();
    void aggiungiStudenteACorso(Long idStudente, Long idCorso);
    void eliminaStudenteDaCorso(Long idStudente, Long idCorso);
    Studente studentiByIdEager (Long idStudente);

}
