package it.prova.springStudenti.model;

import it.prova.springStudenti.dto.StudenteDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(name = "studenti_corsi",
            joinColumns = @JoinColumn(name =  "studente_id"),
            inverseJoinColumns = @JoinColumn(name = "corso_id"))
    @Column(name = "corso")
    private Set<Corso> corsi = new HashSet<>();


    public Studente(){}

    public Studente(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public Studente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(Set<Corso> corsi) {
        this.corsi = corsi;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
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
        return this.nome + " " + this.cognome + ", corsi di studio: " + this.corsi + ", data di nascita: " + this.dataDiNascita;
    }
}
