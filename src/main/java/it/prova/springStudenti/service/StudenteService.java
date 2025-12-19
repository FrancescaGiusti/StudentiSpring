package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Studente;

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

}
