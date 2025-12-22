package it.prova.springStudenti.controller;

import it.prova.springStudenti.dto.CorsoDto;
import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/corsi")
public class CorsoController {
    private final CorsoService corsoService;

    @Autowired
    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @GetMapping("/test")
    public String test(){
        return "Api invocata!";
    }

    @PostMapping
    public ResponseEntity<String> creaCorso(@RequestBody CorsoDto corsoDto){
        Corso corso = corsoDto.toModel();
        corsoService.aggiungiCorso(corso);
        return ResponseEntity.status(HttpStatus.CREATED).body("Corso creato con successo");
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminaCorso(@PathVariable Long id){
//        corsoService.eliminaCorso(id);
//        return ResponseEntity.ok("Corso eliminato con successo");
//    }

    @PutMapping()
    public ResponseEntity<String> aggiornaCorso(@RequestBody CorsoDto corsoDto){
        Corso corso = corsoDto.toModel();
        corsoService.modificaCorso(corso);
        return ResponseEntity.status(HttpStatus.OK).body("Corso correttamente aggiornato");
    }

    @GetMapping
    public ResponseEntity<Set<CorsoDto>> leggiCorsi(){
        Set<Corso> corsi = corsoService.getAll();
        return ResponseEntity.ok(CorsoDto.convertFromModel(corsi));
    }

    @DeleteMapping("/{idCorso}")
    public ResponseEntity<String> eliminazioneLogicaCorso(@PathVariable Long idCorso){
        if (idCorso == null)
            throw new RuntimeException("paremetri in input non validi");
        corsoService.eliminazioneLogicaCorso(idCorso);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminazione logica avvenuta con successo");
    }

}
