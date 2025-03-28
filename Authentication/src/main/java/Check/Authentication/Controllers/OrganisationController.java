package Check.Authentication.Controllers;

import Check.Authentication.DTO.OrgRequestDTO;
import Check.Authentication.DTO.OrganisationDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/organisations")
public class OrganisationController {

        @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    private OrganisationService organisationService;

    @GetMapping
    public List<Organisation> getAllOrganisations() {
        return organisationService.getAllOrganisations();
    }

    @GetMapping("/{id}")
    public Optional<Organisation> getOrganisationById(@PathVariable UUID id) {
        return organisationService.getOrganisationById(id);
    }

    @PostMapping("/register")
    public Organisation createOrganisation(@RequestBody OrganisationDTO organisationDTO) {
        return organisationService.createOrganisation(organisationDTO);
    }

    @PostMapping("/data")
    public  void CatchData(@RequestBody OrgRequestDTO orgRequestDTO){
        Organisation organisation = new Organisation();
        organisation.setName(orgRequestDTO.getName());
        organisation.setEmail(orgRequestDTO.getEmail());
        organisation.setPassword("password");
        organisationRepository.save(organisation);
    }
}
