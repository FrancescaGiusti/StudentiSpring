package it.prova.springStudenti.dto;

import it.prova.springStudenti.model.Corso;
import it.prova.springStudenti.model.Studente;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudenteDto {
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private Set<Corso> corsi;


    public StudenteDto(){}

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(Set<Corso> corsi) {
        this.corsi = corsi;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public Studente toModel(){
        Studente studente = new Studente();
        studente.setNome(this.getNome());
        studente.setCognome(this.getCognome());
        studente.setCorsi(this.getCorsi());
        studente.setDataDiNascita(this.getDataDiNascita());
        studente.setId(this.getId());
        return studente;
    }

    public static StudenteDto convertFromModel (Studente toConvert){
        StudenteDto studenteDto = new StudenteDto();
        studenteDto.setNome(toConvert.getNome());
        studenteDto.setCognome(toConvert.getCognome());
        studenteDto.setId(toConvert.getId());
        studenteDto.setDataDiNascita(toConvert.getDataDiNascita());
        studenteDto.setCorsi(toConvert.getCorsi());
        return studenteDto;
    }

    public static List<StudenteDto> convertFromModel (List<Studente> listToConvert){
        return listToConvert.stream().map(s -> StudenteDto.convertFromModel(s)).collect(Collectors.toUnmodifiableList());
    }


}
