package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.model.Studente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class StudenteServiceTest {
    @Autowired
    private StudenteServiceImpl studenteServiceImpl;

    @Test
    public void testCrud() {
        Studente studente1 = new Studente();
        studente1.setNome("Gaia");
        studente1.setCognome("Bianchi");

        //Test aggiungi
        System.out.println("**************** test Aggiungi Inizio ****************");
        studenteServiceImpl.aggiungiStudente(studente1);
        Studente aggiunto = studenteServiceImpl.findById(studente1.getId());
        if (aggiunto.getId() == null)
            throw new RuntimeException("Test fallito");
        System.out.println("**************** test Aggiungi Fine ****************");

        //Test modifica
        System.out.println("**************** test Modifica Inizio ****************");
        aggiunto.setNome("Maria");
        studenteServiceImpl.modificaStudente(aggiunto);
        if (!aggiunto.getNome().equals("Maria"))
            throw  new RuntimeException("Test fallito");
        System.out.println("**************** test Modifica Fine ****************");

        //test lettura
        System.out.println("**************** test Lettura Inizio ****************");
        List<Studente> studenti = studenteServiceImpl.getAll();
        if (studenti.size() != 1)
           throw  new RuntimeException("Test fallito");
        System.out.println("**************** test Lettura Fine ****************");

        //test ricerca per nome
        System.out.println("**************** test Ricerca per nome Inizio ****************");
        String nome = studente1.getNome();
        List<Studente> trovato = studenteServiceImpl.trovaPerNomeCheIniziaCon(nome);
        if (trovato.size() != 1)
            throw  new RuntimeException("Test fallito");
        System.out.println("**************** test Ricerca per nome Fine ****************");


        //test eliminazione
        System.out.println("**************** test Elimina Inizio ****************");
        studenteServiceImpl.eliminaStudente(aggiunto.getId());
        if (studenteServiceImpl.findById(aggiunto.getId()) != null)
            throw  new RuntimeException("Test fallito");
        System.out.println("**************** test Elimina Fine ****************");


        //test ricercaInBaseAlCorsoDiLaurea
        System.out.println("**************** test ricercaInBaseAlCorsoDiLaurea Inizio ****************");
        List<Studente> studentiCompleti = studenteServiceImpl.getAll();
        Studente studente = studentiCompleti.get(0);
        Set<Corso> corsi = new HashSet<>();
        corsi.add(new Corso("Matematica"));
        studente.setCorsi(corsi);
        studenteServiceImpl.modificaStudente(studente);
        List<Studente> studentiCercati = studenteServiceImpl.cercaTuttiInBaseAlCorsoDiLaurea("Matematica");
        if (studentiCercati.size() > 0) {
            Studente trovatoConCorso = studentiCercati.get(0);
            if (!trovatoConCorso.getCorsi().equals("Matematica")) {
                throw new RuntimeException("Test fallito");
            }
        }
        System.out.println("**************** test ricercaInBaseAlCorsoDiLaurea Fine ****************");

        //test ordinamento in base alla data di nascita
        System.out.println("**************** test ordinaInbaseAllaDataDiNascita Inizio ****************");
        List<Studente> studentiOrdinati = studenteServiceImpl.ordinaTuttiInBaseAllaDataDiNAscita();
        LocalDate dataPrimoStudente = studentiOrdinati.get(0).getDataDiNascita();
        LocalDate dataSecondoStudente = studentiOrdinati.get(1).getDataDiNascita();
        if (dataPrimoStudente != null && dataSecondoStudente != null && dataPrimoStudente.isAfter(dataSecondoStudente)) {
                throw new RuntimeException("Test fallito");
        }
        System.out.println("**************** test ordinaInbaseAllaDataDiNascita Fine ****************");
    }
}