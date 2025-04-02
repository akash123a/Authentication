package Check.Authentication.Repositories;

import Check.Authentication.Entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.lang.ScopedValue;
import java.util.Optional;
import java.util.UUID;
public interface OrganisationRepository extends JpaRepository<Organisation, UUID> {
    Optional<Organisation> findByEmail(String email);
}




