package fr.kira.formation.spring.cinema.films;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Pour les film.
 * Cette classe permet de gérer les films dans la base de données.
 *
 * Cette classe utilise EntityManager d'hibernate
 */
@Repository
public class FullFilmRepository {

    private final EntityManager entityManager;

    public FullFilmRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Sauvegarde un nouveau film dans la base de données.
     * @param film a sauvegarder
     * @return le film avec son id
     */
    public Film save(Film film){
        entityManager.persist(film);
        entityManager.flush(); // synchro l'instance film avec la base de données. Ajoute donc l'id.
        return film;
    }

    /**
     * Retourne le film portant l'id
     * @param id du film recherche
     * @return le film portant l'id
     */
    public Film findById(Integer id){
        // SELECT * FROM films WHERE films.id == {id}
        return entityManager.find(Film.class, id);
    }

    /**
     * Retourne la liste de l'ensemble des films
     * @return la liste de l'ensemble des films
     */
    public List<Film> findAll(){
        TypedQuery<Film> query = entityManager.createQuery("SELECT f FROM films f", Film.class);
        return query.getResultList();
    }

    /**
     * Met a jour l'entité dans la base de données
     * @param film a metre a jour
     * @return film mis a jour
     */
    public Film update(Film film){
        entityManager.merge(film);
        return film;
    }

    /**
     * Supprime un film de la base de données en fonction de son id
     * @param id du film a supprimer
     */
    public void deleteById(Integer id){
        Film film = this.findById(id);
        entityManager.remove(film);
    }


}
