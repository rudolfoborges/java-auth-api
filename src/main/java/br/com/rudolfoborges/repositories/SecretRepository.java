package br.com.rudolfoborges.repositories;

import br.com.rudolfoborges.models.Secret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends JpaRepository<Secret, Long> {

    Secret findFirstByEnabled(Boolean enabled);

}
