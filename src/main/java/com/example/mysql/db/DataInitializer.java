package com.example.mysql.db;

import com.example.mysql.model.Motorcycle;
import com.example.mysql.repositories.MotorcycleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final MotorcycleRepository motorcycleRepository;

    public DataInitializer(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        motorcycleRepository.deleteAll();

        Motorcycle motorcycleDDD = new Motorcycle("1", "2", "3");
        Motorcycle savedDDD = motorcycleRepository.save(motorcycleDDD);

        Motorcycle motorcycleSIA = new Motorcycle("2", "3", "4");
        Motorcycle savedSIA = motorcycleRepository.save(motorcycleSIA);

        motorcycleRepository.findAll().forEach(motorcycle -> {
            System.out.println("Motorcycle Id: " + motorcycle.getId());
            System.out.println("Motorcycle Title: " + motorcycle.getName());
        });

    }
}
