package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.model.Studente;
import it.prova.springStudenti.repository.CorsoRepository;
import it.prova.springStudenti.repository.StudenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudenteServiceImpl implements  StudenteService{
    private final StudenteRepository studenteRepository;
    private final CorsoRepository corsoRepository;

    @Autowired
    public StudenteServiceImpl(StudenteRepository studenteRepository, CorsoRepository corsoRepository){
        this.studenteRepository = studenteRepository;
        this.corsoRepository = corsoRepository;
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
      } else {
          throw new RuntimeException("Utente non trovato");
      }
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

    @Override
    public void aggiungiStudenteACorso(Long idStudente, Long idCorso) {
        if (corsoRepository.findById(idCorso).isEmpty()|| studenteRepository.findById(idStudente).isEmpty())
            throw new RuntimeException("Campi di input non validi");
        studenteRepository.addStudentToCourse(idStudente, idCorso);
    }

    @Override
    public void eliminaStudenteDaCorso(Long idStudente, Long idCorso) {
        if (corsoRepository.findById(idCorso).isEmpty()|| studenteRepository.findById(idStudente).isEmpty())
            throw new RuntimeException("Campi di input non validi");
        studenteRepository.deleteStudenteFromCourse(idStudente, idCorso);
    }

    @Override
    public Studente studentiByIdEager(Long idStudente) {
        Studente studente = studenteRepository.studentByIdEager(idStudente);
        if (studente == null){
            throw  new RuntimeException("Non esiste nessuno studente con l'id indicato");
        }
       return studente;
    }
}
