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
		Secret secret = new Secret("ff298e4c4f975caa25114d524167027dd47275f4bf7e414fce87b993ad12d058");
		secretRepository.save(secret);
	}
}
