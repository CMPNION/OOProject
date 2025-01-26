package kz.aitu.se2422;

import kz.aitu.se2422.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findBySpecies(String species);
    List<Pet> findByNameContainingIgnoreCase(String name);

}
