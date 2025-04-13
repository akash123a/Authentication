//package Check.Authentication.Services;
//
//import Check.Authentication.DTO.OrganisationDTO;
//import Check.Authentication.Entities.Organisation;
//import Check.Authentication.Repositories.OrganisationAdminRepository;
//import Check.Authentication.Repositories.OrganisationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class OrganisationService {
//
//    @Autowired
//    private OrganisationRepository organisationRepository;
//
//    @Autowired
//    private OrganisationAdminRepository organisationAdminRepository;
//
//
//
//    public List<Organisation> getAllOrganisations() {
//        return organisationRepository.findAll();
//    }
//
//    public Optional<Organisation> getOrganisationById(UUID id) {
//        return organisationRepository.findById(id);
//    }
//
//    public Organisation createOrganisation(OrganisationDTO organisationDTO) {
//        // Convert OrganisationDTO to Organisation entity
//        Organisation organisation = new Organisation();
//        organisation.setName(organisationDTO.getName());
//        organisation.setEmail(organisationDTO.getEmail());
//        organisation.setPassword(organisationDTO.getPassword());
//        organisation.setSubscription(organisationDTO.getSubscription());
//
//        // Save the organisation to the database
//        return organisationRepository.save(organisation);
//    }
//}





//
//package Check.Authentication.Services;
//
//import Check.Authentication.DTO.OrganisationDTO;
//import Check.Authentication.Entities.Organisation;
//import Check.Authentication.Entities.OrganisationAdmin;
//import Check.Authentication.Repositories.OrganisationAdminRepository;
//import Check.Authentication.Repositories.OrganisationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class OrganisationService {
//
//    @Autowired
//    private OrganisationRepository organisationRepository;
//
//    @Autowired
//    private OrganisationAdminRepository organisationAdminRepository;
//
//    public List<Organisation> getAllOrganisations() {
//        return organisationRepository.findAll();
//    }
//
//    public Optional<Organisation> getOrganisationById(UUID id) {
//        return organisationRepository.findById(id);
//    }
//
//    public Organisation createOrganisation(OrganisationDTO organisationDTO) {
//        // Convert OrganisationDTO to Organisation entity
//        Organisation organisation = new Organisation();
//        organisation.setName(organisationDTO.getName());
//        organisation.setEmail(organisationDTO.getEmail());
//        organisation.setPassword(organisationDTO.getPassword());
//        organisation.setSubscription(organisationDTO.getSubscription());
//
//        // Save the organisation to the database
//        Organisation savedOrganisation = organisationRepository.save(organisation);
//
//        // Automatically create an admin for this organisation
//        OrganisationAdmin admin = new OrganisationAdmin(
//                savedOrganisation.getName(),
//                savedOrganisation.getEmail(),
//                savedOrganisation
//        );
//
//        organisationAdminRepository.save(admin);
//
//        return savedOrganisation;
//    }
//}








//package Check.Authentication.Services;
//
//import Check.Authentication.DTO.OrganisationDTO;
//import Check.Authentication.Entities.Organisation;
//import Check.Authentication.Repositories.OrganisationAdminRepository;
//import Check.Authentication.Repositories.OrganisationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class OrganisationService {
//
//    @Autowired
//    private OrganisationRepository organisationRepository;
//
//    @Autowired
//    private OrganisationAdminRepository organisationAdminRepository;
//
//
//
//    public List<Organisation> getAllOrganisations() {
//        return organisationRepository.findAll();
//    }
//
//    public Optional<Organisation> getOrganisationById(UUID id) {
//        return organisationRepository.findById(id);
//    }
//
//    public Organisation createOrganisation(OrganisationDTO organisationDTO) {
//        // Convert OrganisationDTO to Organisation entity
//        Organisation organisation = new Organisation();
//        organisation.setName(organisationDTO.getName());
//        organisation.setEmail(organisationDTO.getEmail());
//        organisation.setPassword(organisationDTO.getPassword());
//        organisation.setSubscription(organisationDTO.getSubscription());
//
//        // Save the organisation to the database
//        return organisationRepository.save(organisation);
//    }
//}





//
//package Check.Authentication.Services;
//
//import Check.Authentication.DTO.OrganisationDTO;
//import Check.Authentication.Entities.Organisation;
//import Check.Authentication.Entities.OrganisationAdmin;
//import Check.Authentication.Repositories.OrganisationAdminRepository;
//import Check.Authentication.Repositories.OrganisationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class OrganisationService {
//
//    @Autowired
//    private OrganisationRepository organisationRepository;
//
//    @Autowired
//    private OrganisationAdminRepository organisationAdminRepository;
//
//    public List<Organisation> getAllOrganisations() {
//        return organisationRepository.findAll();
//    }
//
//    public Optional<Organisation> getOrganisationById(UUID id) {
//        return organisationRepository.findById(id);
//    }
//
//    public Organisation createOrganisation(OrganisationDTO organisationDTO) {
//        // Convert OrganisationDTO to Organisation entity
//        Organisation organisation = new Organisation();
//        organisation.setName(organisationDTO.getName());
//        organisation.setEmail(organisationDTO.getEmail());
//        organisation.setPassword(organisationDTO.getPassword());
//        organisation.setSubscription(organisationDTO.getSubscription());
//
//        // Save the organisation to the database
//        Organisation savedOrganisation = organisationRepository.save(organisation);
//
//        // Automatically create an admin for this organisation
//        OrganisationAdmin admin = new OrganisationAdmin(
//                savedOrganisation.getName(),
//                savedOrganisation.getEmail(),
//                savedOrganisation
//        );
//
//        organisationAdminRepository.save(admin);
//
//        return savedOrganisation;
//    }
//}








package Check.Authentication.Services;

import Check.Authentication.DTO.OrganisationDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Entities.OrganisationAdmin;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.OrganisationAdminRepository;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Repositories.UserRepository;
import Check.Authentication.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private OrganisationAdminRepository organisationAdminRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;


    // ✅ Get all organisations
    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }

    // ✅ Get organisation by ID
    public Optional<Organisation> getOrganisationById(UUID id) {
        return organisationRepository.findById(id);
    }

    // ✅ Get organisation by email (return Optional)
    public Optional<Organisation> findByEmail(String email) {
        return organisationRepository.findByEmail(email);  // No need for Optional.ofNullable()
    }


    // ✅ Create a new organisation and assign an admin
    public Organisation createOrganisation(OrganisationDTO organisationDTO) {
        // Prevent duplicate email registration
        if (organisationRepository.findByEmail(organisationDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }

        // Convert DTO to entity
        Organisation organisation = new Organisation();
        organisation.setName(organisationDTO.getName());
        organisation.setEmail(organisationDTO.getEmail());
        organisation.setPassword(organisationDTO.getPassword());
        organisation.setSubscription(organisationDTO.getSubscription());

        // Save organisation
        Organisation savedOrganisation = organisationRepository.save(organisation);

        // ✅ Automatically create an admin
        OrganisationAdmin admin = new OrganisationAdmin(
                savedOrganisation.getName(),
                savedOrganisation.getEmail(),
                savedOrganisation
        );

        organisationAdminRepository.save(admin);

        return savedOrganisation;
    }

    // ✅ Save an organisation (generic method)
    public Organisation saveOrganisation(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    // ✅ Process incoming data from Payment Gateway
    public void processPaymentData(OrganisationDTO organisationDTO) {
        Optional<Organisation> existingOrganisation = organisationRepository.findByEmail(organisationDTO.getEmail());

        if (existingOrganisation.isPresent()) {
            Organisation organisation = existingOrganisation.get();
            organisation.setSubscription(organisationDTO.getSubscription()); // ✅ Update subscription
            organisationRepository.save(organisation);
            System.out.println("Organisation subscription updated for: " + organisationDTO.getEmail());
        } else {
            System.out.println("Organisation not found for email: " + organisationDTO.getEmail());
        }
    }
//
//    public void inviteMember(String username, String inviteEmail, String role) {
//        Organisation org = organisationRepository.findByEmail(username)
//                .orElseThrow(() -> new RuntimeException("Organization not found"));
//
//        UUID orgId = org.getId();
//
//        // 1. Save the user with inactive status
//        createUser(inviteEmail, role, orgId);
//
//        // 2. Send invite email via Notification API
//        String notificationUrl = "http://localhost:8094/notification/api/inviteMail";
//        RestTemplate restTemplate = new RestTemplate();
//
//        Map<String, String> payload = new HashMap<>();
//        payload.put("userEmail", inviteEmail);
//        payload.put("orgName", org.getName());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);
//
//        try {
//            ResponseEntity<String> response = restTemplate.postForEntity(notificationUrl, request, String.class);
//            System.out.println("Notification sent: " + response.getBody());
//        } catch (Exception e) {
//            System.out.println("Failed to send invite email: " + e.getMessage());
////            throw new RuntimeException("Failed to send invite email", e);
//        }
//    }
//
//
//    private void createUser(String inviteEmail, String role, UUID orgId) {
//        Organisation org = organisationRepository.findById(orgId)
//                .orElseThrow(() -> new RuntimeException("Organization not found by ID"));
//
//        User user = new User();
//        user.setEmail(inviteEmail);
//        user.setRole(Role.valueOf(role));
//        user.setOrganisation(org);
//        user.setActive(false); // user inactive initially
//        user.setName("");
//        user.setPassword("");
//
//        userRepository.save(user);
//
//    }



}
