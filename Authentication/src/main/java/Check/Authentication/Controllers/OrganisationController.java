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
import Check.Authentication.Entities.OrganisationAdmin;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.OrganisationAdminRepository;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Repositories.UserRepository;
import Check.Authentication.Services.OrganisationService;
import Check.Authentication.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/organisation")
@CrossOrigin(origins = "*")  // Allow requests from all origins
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private OrganisationAdminRepository organisationAdminRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

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
//    @PostMapping("/data")
//    public ResponseEntity<?> catchData(@RequestBody OrgRequestDTO orgRequestDTO) {
//        Optional<Organisation> existingOrg = organisationRepository.findByEmail(orgRequestDTO.getEmail());
//
//        if (existingOrg.isPresent()) {
//            return ResponseEntity.badRequest().body("Email already exists!");
//        }
//
//        Organisation organisation = new Organisation();
//        organisation.setName(orgRequestDTO.getName());
//        organisation.setEmail(orgRequestDTO.getEmail());
//        organisation.setPassword("password"); // Consider encrypting password before saving
//
//        Organisation savedOrganisation = organisationRepository.save(organisation);
//        OrganisationAdmin organisationAdmin = new OrganisationAdmin();
//         organisationAdmin.setAdminName(organisation.getName());
//         organisationAdmin.setEmail(organisation.getEmail());
//
//            organisationAdminRepository.save(organisationAdmin);
//           return ResponseEntity.ok(savedOrganisation);
//    }




    @PostMapping("/data")
    public ResponseEntity<?> catchData(@RequestBody OrgRequestDTO orgRequestDTO) {
        Optional<Organisation> existingOrg = organisationRepository.findByEmail(orgRequestDTO.getEmail());

        if (existingOrg.isPresent()) {
            // ✅ If organisation exists, update its subscription
            Organisation organisation = existingOrg.get();
            organisation.setSubscription(orgRequestDTO.getSubscription());  // Update subscription
            organisationRepository.save(organisation);

            return ResponseEntity.ok().body("Subscription updated for " + orgRequestDTO.getEmail());
        }

        // ✅ If organisation does not exist, create new organisation
        Organisation organisation = new Organisation();
        organisation.setName(orgRequestDTO.getName());
        organisation.setEmail(orgRequestDTO.getEmail());
        organisation.setPassword("password"); // 🔴 TODO: Encrypt before saving!
        organisation.setSubscription(orgRequestDTO.getSubscription());

        Organisation savedOrganisation = organisationRepository.save(organisation);

        // ✅ Automatically create an admin for this organisation
        OrganisationAdmin organisationAdmin = new OrganisationAdmin();
        organisationAdmin.setAdminName(organisation.getName());
        organisationAdmin.setEmail(organisation.getEmail());
        organisationAdmin.setOrganisation(savedOrganisation);

        organisationAdminRepository.save(organisationAdmin);

        return ResponseEntity.ok().body("Organisation registered successfully!");
    }

//    @PostMapping("/invite")
//    public ResponseEntity inviteMember(@RequestHeader("Authorization") String authHeader,
//                                       @RequestParam String inviteEmail,
//                                       @RequestParam String role){
//        String token = authHeader.substring(7);
//        String username = jwtUtil.extractUsername(token);
//
//        if(jwtUtil.validateToken(token,username)) {
//            try {
//                organisationService.inviteMember(username,inviteEmail,role);
//                return new ResponseEntity("User Invited Successfully", HttpStatus.OK);
//            }catch (Exception e){
//                return new ResponseEntity("Inviting User Failed",HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//        return new ResponseEntity("Invalid User",HttpStatus.UNAUTHORIZED);
//    }






}
