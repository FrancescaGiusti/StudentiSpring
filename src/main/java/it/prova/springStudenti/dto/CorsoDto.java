package it.prova.springStudenti.dto;

import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.model.Studente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CorsoDto {
    private Long id;
    private String nome;
    private boolean cancellato;
    private List<Studente> studenti = new ArrayList<>();

   public CorsoDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCancellato() {
        return cancellato;
    }

    public void setCancellato(boolean cancellato) {
        this.cancellato = cancellato;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    public Corso toModel(){
       Corso corso = new Corso();
       corso.setNome(this.getNome());
       corso.setId(this.getId());
       corso.setStudenti(this.getStudenti());
       corso.setCancellato(this.isCancellato());
       return corso;
    }

    public static CorsoDto convertFromModel(Corso toConvert){
       CorsoDto corsoDto = new CorsoDto();
        corsoDto.setNome(toConvert.getNome());
        corsoDto.setId(toConvert.getId());
        corsoDto.setStudenti(toConvert.getStudenti());
        corsoDto.setCancellato(toConvert.isCancellato());
        return corsoDto;
    }

    public static List<CorsoDto> convertFromModel (List<Corso> listToConvert){
        return listToConvert.stream().map(c -> CorsoDto.convertFromModel(c)).collect(Collectors.toUnmodifiableList());
    }


}
