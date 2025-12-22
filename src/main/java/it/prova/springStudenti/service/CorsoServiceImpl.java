package it.prova.springStudenti.service;

import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.repository.CorsoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CorsoServiceImpl implements CorsoService{
    private final CorsoRepository corsoRepository;

    @Autowired
    public CorsoServiceImpl(CorsoRepository corsoRepository) {
        this.corsoRepository = corsoRepository;
    }

    @Override
    public Set<Corso> getAll() {
        if (corsoRepository.findAll().isEmpty()){
            throw new RuntimeException("Non ci sono corsi");
        }
        return corsoRepository.findAll().stream().collect(Collectors.toSet());
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
        if (this.findById(corso.getId()) == null)
            throw new RuntimeException("Il corso non esiste");
        corsoRepository.save(corso);
    }

    @Override
    public void eliminaCorso(Long id) {
        Corso corso = corsoRepository.findById(id).orElse(null);
        if (corso == null)
            throw new RuntimeException("Il corso non esiste");
       corsoRepository.delete(corso);
    }

    @Override
    public List<Corso> ordinaPerNome() {
        return corsoRepository.sortAllCorsi();
    }
}
