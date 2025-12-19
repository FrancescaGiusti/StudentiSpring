package it.prova.springStudenti.controller;

import it.prova.springStudenti.dto.StudenteDto;
import it.prova.springStudenti.model.Studente;
import it.prova.springStudenti.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/studente")
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
    public ResponseEntity creaStudente(@RequestBody StudenteDto studenteDto){
        Studente studente = studenteDto.toModel();
        studenteService.aggiungiStudente(studente);
        return ResponseEntity.status(201).body("Studente creato con successo");
    }

    @DeleteMapping("{id}")
    public ResponseEntity eliminaStudente(@PathVariable Long id){
        Studente studente = studenteService.findById(id);
        if (studente == null)
            throw new RuntimeException("Lo studente non esiste");
        studenteService.eliminaStudente(id);
        return ResponseEntity.status(204).body("Studente eliminato con successo");
    }

    @PutMapping("{id}")
    public ResponseEntity aggiornaStudente(@PathVariable Long id, @RequestBody StudenteDto studenteDto){
        Studente studente = studenteDto.toModel();
        studente.setId(id);
        if (studenteService.findById(studente.getId()) == null)
            throw new RuntimeException("Lo studente non esiste");
        studenteService.modificaStudente(studente);
        return ResponseEntity.status(200).body("Studente correttamente aggiornato");
    }

    @GetMapping ("leggi")
    public List<Studente> leggiStudenti(){
        return studenteService.getAll();
    }


}
