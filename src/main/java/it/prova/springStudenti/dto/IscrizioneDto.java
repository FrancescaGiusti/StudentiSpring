package it.prova.springStudenti.dto;

public class IscrizioneDto {
    private Long idCorso;
    private Long idStudente;

    public IscrizioneDto(Long idCorso, Long idStudente){
        this.idCorso = idCorso;
        this.idStudente = idStudente;
    }

    public Long getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(Long idCorso) {
        this.idCorso = idCorso;
    }

    public Long getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(Long idStudente) {
        this.idStudente = idStudente;
    }
}
