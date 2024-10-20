package br.com.cotemig.petsapi;

import br.com.cotemig.petsapi.model.Pet;
import br.com.cotemig.petsapi.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetsApiApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;
	private Logger logger = LoggerFactory.getLogger(PetsApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PetsApiApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		if(petRepository.count() == 0){
			Pet[] pets = {
					new Pet("Hulk", "Mates", 3, "Rafael"),
					new Pet("Bianca", "yorkshire", 18, "Maria Eugênea"),
					new Pet("Pepita", "poodle", 15, "Denise"),
					new Pet("Tigrinho", "Gato sem raca", 4, "Bruno")

			};
			for (Pet pet : pets) {
				petRepository.save(pet);
			}
			logger.info("Pets salvo no banco");
		}
		else{
			logger.info("Pets  já esta cheio");
		};
	}

}
