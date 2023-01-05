package fr.kira.formation.spring.cinema.realisateurs;

import fr.kira.formation.spring.cinema.realisateurs.dto.RealisateurCompletDto;
import fr.kira.formation.spring.cinema.realisateurs.dto.RealisateurSansFilmDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/realisateurs")
@CrossOrigin
public class RealisateurController {

    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public Iterable<RealisateurSansFilmDto> getAllRealisateurs() {
        return realisateurService.findAll();
    }

    @GetMapping("{id}")
    public RealisateurCompletDto getRealisateurById(Integer id) {
        return realisateurService.findById(id);
    }

    @PostMapping
    public RealisateurCompletDto saveRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.save(realisateur);
    }

    @DeleteMapping("{id}")
    public void deleteRealisateurById(Integer id) {
        realisateurService.deleteById(id);
    }

}
