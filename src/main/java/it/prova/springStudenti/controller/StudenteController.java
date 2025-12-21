package it.prova.springStudenti.controller;

import it.prova.springStudenti.dto.StudenteDto;
import it.prova.springStudenti.model.Studente;
import it.prova.springStudenti.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/studenti/")
public class StudenteController {

    private final StudenteService studenteService;

    @Autowired
    public StudenteController(StudenteService studenteService){
        this.studenteService = studenteService;
    }

    @GetMapping("test")
    public String test(){
        return "Api invocata!";
    }

    @PostMapping
    public ResponseEntity<String> creaStudente(@RequestBody StudenteDto studenteDto){
        Studente studente = studenteDto.toModel();
        studenteService.aggiungiStudente(studente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Studente creato con successo");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminaStudente(@PathVariable Long id){
        Studente studente = studenteService.findById(id);
        if (studente == null)
            throw new RuntimeException("Lo studente non esiste");
        studenteService.eliminaStudente(id);
        return ResponseEntity.ok("Studente eliminato con successo");
    }

    @PutMapping()
    public ResponseEntity<String> aggiornaStudente(@RequestBody StudenteDto studenteDto){
        Studente studente = studenteDto.toModel();
        if (studenteService.findById(studente.getId()) == null)
            throw new RuntimeException("Lo studente non esiste");
        studenteService.modificaStudente(studente);
        return ResponseEntity.status(HttpStatus.OK).body("Studente correttamente aggiornato");
    }

    @GetMapping ("leggi")
    public ResponseEntity<List<StudenteDto>> leggiStudenti(){
        List<Studente> studenti = studenteService.getAll();
        if (studenti.isEmpty())
            throw new RuntimeException("Non sono presenti studenti");
        return ResponseEntity.ok(StudenteDto.convertFromModel(studenti));
    }
}
