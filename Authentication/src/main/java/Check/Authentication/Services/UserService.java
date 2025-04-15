//package Check.Authentication.Services;

//import Check.Authentication.DTO.UserDTO;
//import Check.Authentication.Entities.Organisation;
//import Check.Authentication.Entities.User;
//import Check.Authentication.Repositories.OrganisationRepository;
//import Check.Authentication.Repositories.UserRepository;
////import Check.Authentication.util.MailUtility;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;

//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private MailUtility mailUtility;
//
//    @Autowired
//    private OrganisationRepository organisationRepository;
//
//
//    public User registerUser(UserDTO dto) throws Exception {
//        User user = new User();
//        user.setName(dto.getName());
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword()); // Optional: encode with BCrypt
//        user.setRole("MEMBER"); // ✅ Set a default role
//
//
//        // ✅ Assign an existing organisation
//        Organisation org = organisationRepository.findById(UUID.fromString("3897cf16-e23d-4a30-b94b-55c09717d879"))
//                .orElseThrow(() -> new RuntimeException("Organisation not found"));
//
//        user.setOrganisation(org); // ✅ this line fixes the organisation_id null issue
//
//
//
//        User savedUser = userRepository.save(user);
//
//        mailUtility.sendUserRegistrationMail(
//                savedUser.getEmail(),
//                savedUser.getName(),
//                "Welcome to Our App!"
//        );
//
//        return savedUser;
//    }
//}

package Check.Authentication.Services;

import Check.Authentication.DTO.UserDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private JavaMailSender mailSender;

    // ✅ Register user and assign to organization
    public User registerUser(UserDTO dto) throws Exception {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("User already exists with this email.");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // You should encode the password (BCrypt)

        // Optional: set a default role
        user.setRole("MEMBER");

        // Assign default organisation
        Organisation org = organisationRepository.findById(UUID.fromString("3897cf16-e23d-4a30-b94b-55c09717d879"))
                .orElseThrow(() -> new RuntimeException("Organisation not found"));
        user.setOrganisation(org);

        return userRepository.save(user);
    }

    // ✅ Send email invitation with pre-filled email link
    public void sendInvitation(String email) {
        String link = "http://localhost:8094/user-registration.html?email=" + email;

        String subject = "Complete Your Registration";
        String htmlContent = "<p>Hello,</p>" +
                "<p>Please complete your registration by clicking the link below:</p>" +
                "<a href=\"" + link + "\">Complete Registration</a>";

        sendMail(email, subject, htmlContent);
    }

    // ✅ Mail sender using JavaMailSender and HTML
    private void sendMail(String to, String subject, String htmlContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // true = isHtml

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void registerNewUser(UserDTO userDTO) {
        try {
            registerUser(userDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
