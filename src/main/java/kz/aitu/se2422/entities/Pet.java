package kz.aitu.se2422.entities;

import jakarta.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String species;
    private boolean adopted;

    public Pet() {
    }

    public Pet(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.adopted = false;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isAdopted() {
        return adopted;
    }
}
