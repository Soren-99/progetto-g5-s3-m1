package sorenrahimi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "rivista")
@NamedQueries({
    @NamedQuery(name = "Rivista.cercaPerPeriodicita", query = "SELECT r FROM Rivista r WHERE r.periodicita = :periodicita")
})
public class Rivista extends Elemento {
    private Periodicita periodicita;

    public Rivista(){

    }
    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita(){
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
