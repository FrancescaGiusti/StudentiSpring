package it.prova.springStudenti.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.model.Studente;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CorsoDto {
    private Long id;
    private String nome;
    private boolean cancellato;
    @JsonIgnoreProperties ("corsi")
    private List<StudenteDto> studenti = new ArrayList<>();

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

    public List<StudenteDto> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<StudenteDto> studenti) {
        this.studenti = studenti;
    }

    public Corso toModel(){
       Corso corso = new Corso();
       corso.setNome(this.getNome());
       corso.setId(this.getId());
       corso.setStudenti(this.getStudenti().stream().map(s -> s.toModel()).collect(Collectors.toList()));
       corso.setCancellato(this.isCancellato());
       return corso;
    }

    public static CorsoDto convertFromModel(Corso toConvert){
       CorsoDto corsoDto = new CorsoDto();
        corsoDto.setNome(toConvert.getNome());
        corsoDto.setId(toConvert.getId());
        corsoDto.setStudenti(StudenteDto.convertFromModelLight(toConvert.getStudenti()));
        corsoDto.setCancellato(toConvert.isCancellato());
        return corsoDto;
    }

    public static Set<CorsoDto> convertFromModel (Set<Corso> setToConvert){
        return setToConvert.stream().map(c -> CorsoDto.convertFromModel(c)).collect(Collectors.toSet());
    }

    public static CorsoDto convertFromModelLight(Corso toConvert){
       CorsoDto corsoDto = new CorsoDto();
       corsoDto.setId(toConvert.getId());
       corsoDto.setNome(toConvert.getNome());
       corsoDto.setCancellato(toConvert.isCancellato());
       return corsoDto;
    }

    public static Set<CorsoDto> convertFromModelLight(Set<Corso> setToConvert){
       return setToConvert.stream().map(c-> CorsoDto.convertFromModelLight(c)).collect(Collectors.toSet());
    }


}
