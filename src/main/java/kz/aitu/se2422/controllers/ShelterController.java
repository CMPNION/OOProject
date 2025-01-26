package kz.aitu.se2422.controllers;

import kz.aitu.se2422.ShelterRepository;
import kz.aitu.se2422.entities.Shelter;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {
    private final ShelterRepository shelterRepository;

    public ShelterController(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @GetMapping
    public List<Shelter> getAllShelters() {
        return shelterRepository.findAll();
    }

    @PostMapping
    public Shelter addShelter(@RequestBody Shelter shelter) {
        return shelterRepository.save(shelter);
    }
}
