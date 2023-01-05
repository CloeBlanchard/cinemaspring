package fr.kira.formation.spring.cinema.seances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "seances", path = "seances")
public interface SeanceRepository extends JpaRepository<Seance, Integer> {
}
