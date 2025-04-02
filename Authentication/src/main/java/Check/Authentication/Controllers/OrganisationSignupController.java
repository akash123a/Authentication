//package Check.Authentication.Controllers;
//
//import Check.Authentication.Entities.OrganisationSignup;
//import Check.Authentication.Services.OrganisationSignupService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/payment")
//@CrossOrigin(origins = "http://localhost:5173") // Allow frontend access
//public class OrganisationSignupController {
//
//    @Autowired
//    private OrganisationSignupService organisationSignupService;
//
//    @PostMapping("/beforepayment")
//    public ResponseEntity<String> registerOrganisation(@RequestBody OrganisationSignup organisationSignup) {
//        try {
//            String responseMessage = organisationSignupService.registerOrganisation(organisationSignup);
//            return ResponseEntity.ok(responseMessage);
//        } catch (Exception e) {
//            e.printStackTrace(); // Print error details in console
//            return ResponseEntity.status(500).body("Payment failed. Try again.");
//        }
//    }
//}




//
//package Check.Authentication.Controllers;
//
//import Check.Authentication.Entities.OrganisationSignup;
//import Check.Authentication.Services.OrganisationSignupService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/organisation")
//@CrossOrigin(origins = "*") // Allow requests from all origins
//public class OrganisationSignupController {
//
//    @Autowired
//    private OrganisationSignupService signupService;
//
//    @PostMapping
//    public ResponseEntity<?> registerOrganisation(@RequestBody OrganisationSignup signup) {
//        try {
//            OrganisationSignup savedSignup = signupService.saveSignup(signup);
//            return ResponseEntity.ok(savedSignup);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}





package Check.Authentication.Controllers;

import Check.Authentication.Entities.OrganisationSignup;
import Check.Authentication.Services.OrganisationSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organisation") // Match frontend's request URL
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend access
public class OrganisationSignupController {

    @Autowired
    private OrganisationSignupService organisationSignupService;

    @PostMapping("/before-payment")
    public ResponseEntity<String> registerOrganisation(@RequestBody OrganisationSignup organisationSignup) {
        try {
            System.out.println("Request received: " + organisationSignup); // Debugging
            String responseMessage = organisationSignupService.registerOrganisation(organisationSignup);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            e.printStackTrace(); // Print error details
            return ResponseEntity.status(500).body("Registration failed. Try again.");
        }
    }

}
