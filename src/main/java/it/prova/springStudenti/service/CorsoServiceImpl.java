package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CorsoServiceImpl implements CorsoService{
    private final CorsoRepository corsoRepository;

    @Autowired
    public CorsoServiceImpl(CorsoRepository corsoRepository) {
        this.corsoRepository = corsoRepository;
    }

    @Override
    public List<Corso> getAll() {
        if (corsoRepository.findAll().isEmpty()){
            throw new RuntimeException("Non ci sono corsi");
        }
        return corsoRepository.findAll();
    }

    @Override
    public Corso findById(Long id) {
        return corsoRepository.findById(id).orElse(null);
    }

    @Override
    public void aggiungiCorso(Corso corso) {
        corsoRepository.save(corso);
    }

    @Override
    public void modificaCorso(Corso corso) {
        corsoRepository.save(corso);
    }

    @Override
    public void eliminaCorso(Long id) {
        Corso corso = corsoRepository.findById(id).orElse(null);
        if (corso == null)
            throw new RuntimeException("Il corso non esiste");
       corsoRepository.delete(corso);
    }
}
