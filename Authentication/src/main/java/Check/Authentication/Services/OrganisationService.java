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
import Check.Authentication.Repositories.OrganisationAdminRepository;
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

    @Autowired
    private OrganisationAdminRepository organisationAdminRepository;

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



}
