package fr.kira.formation.spring.cinema.tickets;

import fr.kira.formation.spring.cinema.seances.Seance;
import fr.kira.formation.spring.cinema.seances.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketService {

    private final TicketRepository repository;

    private final SeanceService seanceService;

    public TicketService(TicketRepository repository, SeanceService seanceService) {
        this.repository = repository;
        this.seanceService = seanceService;
    }



    public Ticket save(Ticket entity) {
        Seance obtenirSeance = seanceService.findById(entity.getSeance().getId().intValue());
        if(obtenirSeance.getNombrePlace() >= entity.getNombrePlace()) {
            System.out.println(obtenirSeance.getNombrePlace());
            System.out.println(entity.getSeance());
            // enlever les places restante a la salle attitré à la séance
            //obtenirSeance.getNombrePlace() - entity.getNombrePlace();
            return repository.save(entity);
        } else {
            new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return entity;
    }

    public Ticket findById(Integer integer) {
        return repository.findById(integer).orElseThrow();
    }

    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    public Iterable<Ticket> findAll() {
        return repository.findAll();
    }


}
