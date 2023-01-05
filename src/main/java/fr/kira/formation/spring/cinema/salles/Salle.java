package fr.kira.formation.spring.cinema.salles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "salles")
@Getter
@Setter
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numero;

    private int capacite;

}
