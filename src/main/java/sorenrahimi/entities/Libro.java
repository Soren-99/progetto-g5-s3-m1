package sorenrahimi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
@NamedQueries({
        @NamedQuery(name = "Libro.cercaPerAutore", query = "SELECT l FROM Libro 1 WHERE 1.autore = :autore"),
        @NamedQuery(name = "Libro.cercaPerTitolo", query = "SELECT l FROM Libro 1 WHERE 1.titolo LIKE = :titolo"),
        @NamedQuery(name = "Libro.cercaPerGenere", query = "SELECT l FROM Libro 1 WHERE 1.genere LIKE = :genere"),
})
public class Libro extends Elemento{
    private String autore;
    private String genere;

    public Libro(){}

    public Libro(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
