package sorenrahimi.dao;

import jakarta.persistence.*;
import sorenrahimi.entities.Elemento;

import java.util.List;

public class CatalogoDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("progetto-g5-s3-m1");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void aggiungiElemento(Elemento elemento) {
        entityManager.getTransaction().begin();
        entityManager.persist(elemento);
        entityManager.getTransaction().commit();
    }

    public Elemento cercaPerISBN(String ISBN) {
        return entityManager.find(Elemento.class, ISBN);
    }

    public List<Elemento> cercaPerAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Elemento> query= entityManager.createQuery("SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno", Elemento.class);
        query.setParameter("anno", annoPubblicazione);
        return query.getResultList();
    }

    public List<Elemento> cercaPerAutore(String autore) {
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e WHERE TYPE(e) = Libro AND e.autore = :autore", Elemento.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Elemento> cercaPerTitolo(String titolo) {
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo", Elemento.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public void rimuoviPerISBN(String ISBN) {
        entityManager.getTransaction().begin();
        Elemento elemento = entityManager.find(Elemento.class, ISBN);
        if (elemento != null){
            entityManager.remove(elemento);
        }
        entityManager.getTransaction().commit();
    }

    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
