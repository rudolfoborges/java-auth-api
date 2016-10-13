package br.com.rudolfoborges.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rudolfoborges.models.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
	
}
