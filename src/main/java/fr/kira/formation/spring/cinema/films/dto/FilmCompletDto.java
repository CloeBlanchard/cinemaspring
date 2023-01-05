package fr.kira.formation.spring.cinema.films.dto;

import fr.kira.formation.spring.cinema.acteurs.dto.ActeurSansFilmDto;
import fr.kira.formation.spring.cinema.realisateurs.Realisateur;
import fr.kira.formation.spring.cinema.realisateurs.dto.RealisateurSansFilmDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmCompletDto {
    private Integer id;
    private String titre;
    private String resume;
    private int duree;
    private LocalDate dateSortie;
    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
    private List<RealisateurSansFilmDto> realisateurs = new ArrayList<>();
}
