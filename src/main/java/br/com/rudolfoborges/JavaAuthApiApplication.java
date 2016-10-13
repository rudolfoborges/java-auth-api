package br.com.rudolfoborges;

import br.com.rudolfoborges.models.Secret;
import br.com.rudolfoborges.repositories.SecretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaAuthApiApplication implements CommandLineRunner {

	@Autowired
	private SecretRepository secretRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaAuthApiApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Secret secret = new Secret("");
		secretRepository.save(secret);
	}
}
