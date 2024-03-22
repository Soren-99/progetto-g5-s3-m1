package sorenrahimi.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "elemento_id")
    private Elemento elementoPrestato;

    private Date dataInizioPrestito;
    private Date dataRestituzionePrevista;
    private Date getDataRestituzioneEffettiva;

    public Prestito(){

    }

    public Prestito(Utente utente, Elemento elementoPrestato, Date dataInizioPrestito, Date dataRestituzionePrevista, Date getDataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.getDataRestituzioneEffettiva = getDataRestituzioneEffettiva;
    }

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Elemento getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Elemento elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public Date getGetDataRestituzioneEffettiva() {
        return getDataRestituzioneEffettiva;
    }

    public void setGetDataRestituzioneEffettiva(Date getDataRestituzioneEffettiva) {
        this.getDataRestituzioneEffettiva = getDataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", getDataRestituzioneEffettiva=" + getDataRestituzioneEffettiva +
                '}';
    }
}
