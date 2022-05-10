package com.shaimeur.patientsmvc;

import com.shaimeur.patientsmvc.entities.Patient;
import com.shaimeur.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Ash",new Date(),false,34));
            patientRepository.save(new Patient(null,"Brook",new Date(),true,24));
            patientRepository.save(new Patient(null,"Red",new Date(),false,31));
            patientRepository.save(new Patient(null,"Nobody",new Date(),false,64));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }

}
