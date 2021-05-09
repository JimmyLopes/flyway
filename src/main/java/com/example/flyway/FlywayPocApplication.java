package com.example.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlywayPocApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlywayPocApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Create the Flyway instance and point it to the database
		var flyway = Flyway.configure()
				.dataSource("jdbc:postgresql://localhost/postgres", "user", "password")
				.load();

		// Start the migration
		flyway.migrate();
	}
}
