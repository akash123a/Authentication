package Check.Authentication.Repositories;

import Check.Authentication.Entities.OrganisationSignup;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface OrganisationSignupRepository extends JpaRepository<OrganisationSignup, UUID> {
    Optional<OrganisationSignup> findByEmail(String email); // Find organisation by email
}
