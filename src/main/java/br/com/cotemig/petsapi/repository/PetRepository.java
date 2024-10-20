package br.com.cotemig.petsapi.repository;

import br.com.cotemig.petsapi.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
