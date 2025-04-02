//package Check.Authentication.Controllers;
//
//import Check.Authentication.DTO.OrgRequestDTO;
//import Check.Authentication.DTO.OrganisationDTO;
//import Check.Authentication.Entities.Organisation;
//import Check.Authentication.Repositories.OrganisationRepository;
//import Check.Authentication.Services.OrganisationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/organisations")
//public class OrganisationController {
//
//    @Autowired
//    OrganisationRepository organisationRepository;
//
//    @Autowired
//    private OrganisationService organisationService;
//
//    @GetMapping
//    public List<Organisation> getAllOrganisations() {
//        return organisationService.getAllOrganisations();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Organisation> getOrganisationById(@PathVariable UUID id) {
//        return organisationService.getOrganisationById(id);
//    }
//
//    @PostMapping("/register")
//    public Organisation createOrganisation(@RequestBody OrganisationDTO organisationDTO) {
//        return organisationService.createOrganisation(organisationDTO);
//    }
//
//    @PostMapping("/data")
//    public  void CatchData(@RequestBody OrgRequestDTO orgRequestDTO){
//        Organisation organisation = new Organisation();
//        organisation.setName(orgRequestDTO.getName());
//        organisation.setEmail(orgRequestDTO.getEmail());
//        organisation.setPassword("password");
//        organisationRepository.save(organisation);
//    }
//}








package Check.Authentication.Controllers;

import Check.Authentication.DTO.OrgRequestDTO;
import Check.Authentication.DTO.OrganisationDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/organisations")
@CrossOrigin(origins = "*")  // Allow requests from all origins
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @Autowired
    private OrganisationRepository organisationRepository;

    // ✅ Get all organisations
    @GetMapping
    public ResponseEntity<List<Organisation>> getAllOrganisations() {
        List<Organisation> organisations = organisationService.getAllOrganisations();
        return ResponseEntity.ok(organisations);
    }

    // ✅ Get organisation by ID (Handles not found case)
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrganisationById(@PathVariable UUID id) {
        return organisationService.getOrganisationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Register a new organisation
    @PostMapping("/register")
    public ResponseEntity<?> createOrganisation(@RequestBody OrganisationDTO organisationDTO) {
        try {
            Organisation savedOrganisation = organisationService.createOrganisation(organisationDTO);
            return ResponseEntity.ok(savedOrganisation);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Catch data (Refactored to prevent duplicate email registration)
    @PostMapping("/data")
    public ResponseEntity<?> catchData(@RequestBody OrgRequestDTO orgRequestDTO) {
        Optional<Organisation> existingOrg = organisationRepository.findByEmail(orgRequestDTO.getEmail());

        if (existingOrg.isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists!");
        }

        Organisation organisation = new Organisation();
        organisation.setName(orgRequestDTO.getName());
        organisation.setEmail(orgRequestDTO.getEmail());
        organisation.setPassword("default_password"); // Consider encrypting password before saving

        Organisation savedOrganisation = organisationRepository.save(organisation);
        return ResponseEntity.ok(savedOrganisation);
    }

}
