package fr.kira.formation.spring.cinema.realisateurs;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.spring.cinema.realisateurs.dto.RealisateurCompletDto;
import fr.kira.formation.spring.cinema.realisateurs.dto.RealisateurSansFilmDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    private final RealisateurRepository repository;

    private final ObjectMapper mapper;

    public RealisateurService(RealisateurRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RealisateurCompletDto save(Realisateur entity) {
        Realisateur entitySauvegarder = repository.save(entity);
        return mapper.convertValue(entitySauvegarder, RealisateurCompletDto.class);
    }

    public RealisateurCompletDto findById(Integer integer) {
        Realisateur entity = repository.findById(integer).orElseThrow();
        return mapper.convertValue(entity, RealisateurCompletDto.class);
    }

    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    public List<RealisateurSansFilmDto> findAll() {
        List<Realisateur> entities = repository.findAll();
        return entities.stream().map(realisateur -> mapper.convertValue(realisateur, RealisateurSansFilmDto.class)).toList();
    }

}
