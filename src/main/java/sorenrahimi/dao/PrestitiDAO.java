package sorenrahimi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import sorenrahimi.entities.Prestito;

import java.util.Date;
import java.util.List;

public class PrestitiDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("progetto-g5-s3-m1");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void aggiungiPrestito(Prestito prestito){
        entityManager.getTransaction().begin();
        entityManager.persist(prestito);
        entityManager.getTransaction().commit();
    }

    public List<Prestito> cercaPrestitiPerNumeroTessera(String numeroTessera) {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> cercaPrestitiScadutiNonRestituiti(){
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < :oggi", Prestito.class);
        query.setParameter("oggi", new Date());
        return query.getResultList();
    }

    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
