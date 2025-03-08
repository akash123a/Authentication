package Check.Authentication.Services;

import Check.Authentication.DTO.OrganisationDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }

    public Optional<Organisation> getOrganisationById(UUID id) {
        return organisationRepository.findById(id);
    }

    public Organisation createOrganisation(OrganisationDTO organisationDTO) {
        // Convert OrganisationDTO to Organisation entity
        Organisation organisation = new Organisation();
        organisation.setName(organisationDTO.getName());
        organisation.setEmail(organisationDTO.getEmail());
        organisation.setPassword(organisationDTO.getPassword());
        organisation.setSubscription(organisationDTO.getSubscription());

        // Save the organisation to the database
        return organisationRepository.save(organisation);
    }
}