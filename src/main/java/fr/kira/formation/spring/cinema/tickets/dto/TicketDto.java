package fr.kira.formation.spring.cinema.tickets.dto;

import fr.kira.formation.spring.cinema.seances.Seance;
import lombok.Data;

@Data
public class TicketDto {

    private Integer id;
    private String nomClient;

}
