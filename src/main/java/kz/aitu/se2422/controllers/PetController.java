package kz.aitu.se2422.controllers;

import kz.aitu.se2422.PetRepository;
import kz.aitu.se2422.entities.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petRepository.save(pet));
    }

    @GetMapping("/filter")
    public List<Pet> filterPetsBySpecies(@RequestParam String species) {
        return petRepository.findBySpecies(species);
    }

    @GetMapping("/search")
    public List<Pet> searchPetsByName(@RequestParam String name) {
        return petRepository.findByNameContainingIgnoreCase(name);
    }

    @PutMapping("/{id}/adopt")
    public Pet adoptPet(@PathVariable Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
        pet.setAdopted(true);
        return petRepository.save(pet);
    }
}
