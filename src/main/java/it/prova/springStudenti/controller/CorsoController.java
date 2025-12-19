package it.prova.springStudenti.controller;

import it.prova.springStudenti.dto.CorsoDto;
import it.prova.springStudenti.dto.StudenteDto;
import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.model.Studente;
import it.prova.springStudenti.service.CorsoService;
import it.prova.springStudenti.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/corso")
public class CorsoController {
    private final CorsoService corsoService;

    @Autowired
    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping("test")
    public String test(){
        return "Api invocata!";
    }

    @PostMapping
    public ResponseEntity creaCorso(@RequestBody CorsoDto corsoDto){
        Corso corso = corsoDto.toModel();
        corsoService.aggiungiCorso(corso);
        return ResponseEntity.status(201).body("Corso creato con successo");
    }

    @DeleteMapping("{id}")
    public ResponseEntity eliminaCorso(@PathVariable Long id){
        Corso corso = corsoService.findById(id);
        if (corso == null)
            throw new RuntimeException("Il corso non esiste");
        corsoService.eliminaCorso(id);
        return ResponseEntity.ok("Corso eliminato con successo");
    }

    @PutMapping()
    public ResponseEntity aggiornaCorso(@RequestBody CorsoDto corsoDto){
        Corso corso = corsoDto.toModel();
        if (corsoService.findById(corso.getId()) == null)
            throw new RuntimeException("Il corso non esiste");
        corsoService.modificaCorso(corso);
        return ResponseEntity.status(200).body("Corso correttamente aggiornato");
    }

    @GetMapping ("leggi")
    public List<CorsoDto> leggiCorsi(){
        List<Corso> corsi = corsoService.getAll();
        if (corsi.isEmpty())
            throw new RuntimeException("Non sono presenti corsi");
        return CorsoDto.convertFromModel(corsi);
    }

}
