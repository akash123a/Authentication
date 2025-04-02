package Check.Authentication.Repositories;

import Check.Authentication.Entities.OrganisationAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganisationAdminRepository extends JpaRepository<OrganisationAdmin, UUID> {
    Optional<OrganisationAdmin> findByEmail(String email);
}
