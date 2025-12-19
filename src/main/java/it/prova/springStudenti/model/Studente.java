package it.prova.springStudenti.model;

import it.prova.springStudenti.dto.StudenteDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "studente")
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "datadinascita")
    private LocalDate dataDiNascita;
    @Column(name = "corsodilaurea")
    private String corsoDiLaurea;


    public Studente(){}

    public Studente(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public Studente(String nome, String cognome, LocalDate dataDiNascita, String corsoDiLaurea) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.corsoDiLaurea = corsoDiLaurea;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public void setCorsoDiLaurea(String corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
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

    @Override
    public String toString(){
        return this.nome + " " + this.cognome + ", corso di laurea: " + this.corsoDiLaurea + ", data di nascita: " + this.dataDiNascita;
    }
}
