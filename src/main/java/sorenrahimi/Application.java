package sorenrahimi;


import sorenrahimi.dao.CatalogoDAO;
import sorenrahimi.dao.PrestitiDAO;
import sorenrahimi.entities.Elemento;
import sorenrahimi.entities.Libro;
import sorenrahimi.entities.Prestito;
import sorenrahimi.entities.Utente;

import javax.swing.text.Element;
import java.util.Date;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        CatalogoDAO catalogoDAO = new CatalogoDAO();
        PrestitiDAO prestitiDAO = new PrestitiDAO();

        Libro libro = new Libro();
        libro.setISBN("978-3-16-148410-3");
        libro.setTitolo("Il Signore degli Anelli");
        libro.setAnnoPubblicazione(1954);
        libro.setNumeroPagine(1178);
        libro.setAutore("J.R.R. Tolkien");
        libro.setGenere("Fantasy");
        catalogoDAO.aggiungiElemento(libro);

        Elemento elementoByISBN = catalogoDAO.cercaPerISBN("978-3-16-148410-0");
        if (elementoByISBN != null){
            System.out.println("Elemento trovato per ISBN: " + elementoByISBN.getTitolo());
        }else {
            System.out.println("Elemento non trovato per ISBN.");
        }

        Utente utente = new Utente();
        utente.setNome("Soren");
        utente.setCognome("Rahimi");
        utente.setDataNascita(new Date());
        utente.setNumeroTessera("373849");
        Prestito prestito = new Prestito();
        prestito.setUtente(utente);
        prestito.setElementoPrestato(libro);
        prestito.setDataInizioPrestito(new Date());
        prestito.setDataRestituzionePrevista(calcolaDataRestituzionePrevista(prestito.getDataInizioPrestito()));
        prestitiDAO.aggiungiPrestito(prestito);

        List<Prestito> prestitiUtente = prestitiDAO.cercaPrestitiPerNumeroTessera("373849");
        if (!prestitiUtente.isEmpty()){
            System.out.println("Prestiti per l'utente:");
            for (Prestito p : prestitiUtente) {
                System.out.println("- " + p.getElementoPrestato().getTitolo() + " - Restituzione prevista: " + p.getDataRestituzionePrevista());
            }
        }else {
            System.out.println("Nessun prestito trovato per l'utente.");
        }
        List<Prestito> prestitiScaduti = prestitiDAO.cercaPrestitiScadutiNonRestituiti();
        if (!prestitiUtente.isEmpty()){
            System.out.println("Prestiti scaduti e non ancora restituiti:");
            for (Prestito p : prestitiScaduti) {
                System.out.println("- " + p.getElementoPrestato().getTitolo() + " - Restituzione prevista: " + p.getDataRestituzionePrevista());
            }
        }else {
            System.out.println("Nessun prestito trovato per l'utente.");
        }

        catalogoDAO.close();
        prestitiDAO.close();
    }

    private static Date calcolaDataRestituzionePrevista(Date dataInizioPrestito){
            long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
            long millisRestituzionePrevista = dataInizioPrestito.getTime() + (30 * MILLIS_PER_DAY);
            return new Date(millisRestituzionePrevista);
    }
}

