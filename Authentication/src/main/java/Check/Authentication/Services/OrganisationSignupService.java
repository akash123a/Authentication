//package Check.Authentication.Services;
//
//import Check.Authentication.Entities.OrganisationSignup;
//import Check.Authentication.Repositories.OrganisationSignupRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//@Service
//public class OrganisationSignupService {
//
//    @Autowired
//    private OrganisationSignupRepository organisationSignupRepository;
//
//    public String registerOrganisation(OrganisationSignup organisationSignup) {
//        Optional<OrganisationSignup> existingOrg = organisationSignupRepository.findByEmail(organisationSignup.getEmail());
//        if (existingOrg.isPresent()) {
//            return "Email already registered!";
//        }
//
//        // Ensure default payment status is always "pending"
//        organisationSignup.setPayment("pending");
//
//        // Save the organisation details
//        organisationSignupRepository.save(organisationSignup);
//        return "Organisation registered successfully! Payment pending.";
//    }
//}



//
//package Check.Authentication.Services;
//
//import Check.Authentication.Entities.OrganisationSignup;
//import Check.Authentication.Repositories.OrganisationSignupRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
//
//@Service
//public class OrganisationSignupService {
//
//    @Autowired
//    private OrganisationSignupRepository signupRepository;
//
//    public OrganisationSignup saveSignup(OrganisationSignup signup) {
//        return signupRepository.save(signup);
//    }
//
//
//    public OrganisationSignup findById(UUID id) {
//        Optional<OrganisationSignup> optionalSignup = signupRepository.findById(id);
//        return optionalSignup.orElse(null); // ✅ Return the entity or null if not found
//    }
//}









package Check.Authentication.Services;

import Check.Authentication.Entities.OrganisationSignup;
import Check.Authentication.Repositories.OrganisationSignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganisationSignupService {

    @Autowired
    private OrganisationSignupRepository organisationSignupRepository;

    public OrganisationSignup saveSignup(OrganisationSignup organisationSignup) {
        Optional<OrganisationSignup> existingOrg = organisationSignupRepository.findByEmail(organisationSignup.getEmail());
        if (existingOrg.isPresent()) {
            throw new RuntimeException("Email already registered!");
        }

        // Ensure default payment status is always "pending"
        organisationSignup.setPayment("pending");

        // Save and return the organisation details
        return organisationSignupRepository.save(organisationSignup);
    }

    public String registerOrganisation(OrganisationSignup organisationSignup) {
        OrganisationSignup savedOrganisation = saveSignup(organisationSignup);
        return "Organisation registered successfully! ID: " + savedOrganisation.getId();
    }

}
