package fr.kira.formation.spring.cinema.tickets;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.spring.cinema.exceptions.BadRequestException;
import fr.kira.formation.spring.cinema.tickets.dto.TicketDto;
import org.hibernate.PropertyValueException;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

@RestController
@RequestMapping("tickets")
@CrossOrigin
public class TicketController {

        private final TicketService service;
        private final ObjectMapper mapper;

        private final Logger logger = LoggerFactory.getLogger(TicketController.class);

        public TicketController(TicketService service, ObjectMapper mapper) {
            this.service = service;
            this.mapper = mapper;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public TicketDto save(@RequestBody Ticket ticket) {
            try {
                Ticket entity = service.save(ticket);
                return mapper.convertValue(entity, TicketDto.class);
            } catch (PropertyValueException | DataIntegrityViolationException e) {
                logger.warn("La séance doit contenir une seance et un nom de client. "+ ticket);
                throw new BadRequestException("La séance doit contenir une seance et un nom de client.");
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
                throw new RuntimeException("Le ticket n'a pas pu être sauvegardé.", e);
            }
            //return service.save(entity);
        }

        @GetMapping("{id}")
        public TicketDto findById(@PathVariable Integer id) {
            Ticket entity = service.findById(id);
            return mapper.convertValue(entity, TicketDto.class);
        }

        @DeleteMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById(@PathVariable Integer id) {
            service.deleteById(id);
        }

        @GetMapping
        public Iterable<Ticket> findAll() {
           return service.findAll();
        }



}
