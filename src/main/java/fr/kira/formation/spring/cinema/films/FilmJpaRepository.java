package fr.kira.formation.spring.cinema.films;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository pour la gestion des films en utilisant Spring Boot data JPA.
 * Ici, il y a deux types génériques :
 * - Film qui definie que cette interface gère les films
 * - Integer qui est le type de la clé primaire des films.
 */
public interface FilmJpaRepository extends JpaRepository<Film, Integer> {
    List<Film> findByTitre(String titre);
    List<Film> findByTitreContaining(String titre);

    List<Film> findByTitreContainingIgnoreCaseAndDureeBetween(String titre, int dureeStart, int dureeEnd);

    @Query("SELECT f FROM Film f LEFT JOIN Seance s WHERE s.date = :date")
    List<Film> findByDate(@Param("date") LocalDate date);

}
