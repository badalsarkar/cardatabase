package ca.badalsarkar.carddatabase;

import ca.badalsarkar.carddatabase.model.Car;
import ca.badalsarkar.carddatabase.model.Owner;
import ca.badalsarkar.carddatabase.repositories.CarRepositories;
import ca.badalsarkar.carddatabase.repositories.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarddatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CarddatabaseApplication.class);

	@Autowired
	private CarRepositories carRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarddatabaseApplication.class, args);
		logger.info("Hello Spring Boot app");
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Add owner
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);

			carRepository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000, owner1));
			carRepository.save(new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000, owner1));
			carRepository.save(new Car("Toyota", "Prius", "Silver",
					"KKO-0212", 2018, 39000, owner2));
		};
	}

}
