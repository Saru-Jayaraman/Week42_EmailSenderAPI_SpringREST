package se.lexicon.week42_emailsenderapi_springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.week42_emailsenderapi_springrest.domain.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, String> {
}
