package fr.kira.formation.spring.cinema.salles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface SalleRepository extends JpaRepository<Salle, Integer> {
  /*@Query("SELECT s FROM Salle s LEFT JOIN FETCH Seance WHERE Seance.date = :date")
  List<Salle> findByDate(@Param("date") LocalDate date);*/
}
