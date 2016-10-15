package br.com.rudolfoborges.repositories;

import br.com.rudolfoborges.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Long countByEmail(String email);

    User findOneByEmail(String email);

    List<User> findAllByOrderByName();
}
