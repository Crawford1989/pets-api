package br.com.cotemig.petsapi.controller;

import br.com.cotemig.petsapi.model.Pet;
import br.com.cotemig.petsapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pets")
@CrossOrigin
public class PetController {
    @Autowired
    private PetRepository petRepository;
    @GetMapping
    public ResponseEntity<List<Pet>>getAllPets() {
        return ResponseEntity.ok(petRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") Long id) {
        var pet = petRepository.findById(id);
        if (pet.isPresent()) {
            return ResponseEntity.ok(pet.get());
        }
        return ResponseEntity.notFound().build();
    }
}
