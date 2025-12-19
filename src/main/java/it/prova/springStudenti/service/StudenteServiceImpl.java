package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Studente;
import it.prova.springStudenti.repository.StudenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudenteServiceImpl implements  StudenteService{
    private final StudenteRepository studenteRepository;

    @Autowired
    public StudenteServiceImpl(StudenteRepository studenteRepository){
        this.studenteRepository = studenteRepository;
    }

    @Override
    public List<Studente> getAll() {
        return studenteRepository.findAll();
    }

    @Override
    public Studente findById(Long id) {
        return studenteRepository.findById(id).orElse(null);
    }

    @Override
    public void aggiungiStudente(Studente studente) {
        studenteRepository.save(studente);
    }

    @Override
    public void modificaStudente(Studente studente) {
      if(studenteRepository.existsById(studente.getId())){
          studenteRepository.save(studente);
      }
      throw new RuntimeException("Utente non trovato");
    }

    @Override
    public void eliminaStudente(Long id) {
        studenteRepository.deleteById(id);
    }

    @Override
    public List<Studente> trovaPerNomeCheIniziaCon(String nome) {
        return studenteRepository.findAllByNomeLike(nome);
    }

    public List<Studente> cercaTuttiInBaseAlCorsoDiLaurea(String corsoDiLaurea){
       return studenteRepository.findAllByCorsoDiLaurea(corsoDiLaurea);
    }

    @Override
    public List<Studente> ordinaTuttiInBaseAllaDataDiNAscita() {
        return studenteRepository.sortAllByDataDiNascita();
    }
}
