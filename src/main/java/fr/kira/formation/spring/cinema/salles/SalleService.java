package fr.kira.formation.spring.cinema.salles;

import org.springframework.stereotype.Service;

@Service
public class SalleService {

    private final SalleRepository repository;

    public SalleService(SalleRepository repository) {
        this.repository = repository;
    }

    public Salle save(Salle entity) {
        return repository.save(entity);
    }

    public Salle findById(Integer integer) {
        return repository.findById(integer).orElseThrow();
    }

    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    public Iterable<Salle> findAll() {
        return repository.findAll();
    }

}
