package it.prova.springStudenti.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "corso")
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cancellato")
    private boolean cancellato;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "corsi")
    @Column(name = "studente")
    private List<Studente> studenti = new ArrayList<>();

    public Corso(){}

    public Corso(String nome) {
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return "Corso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cancellato=" + cancellato +
                ", studenti=" + studenti +
                '}';
    }
}
