package Check.Authentication.Services;

import Check.Authentication.DTO.UserDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Repositories.UserRepository;
//import Check.Authentication.util.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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





@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerNewUser(UserDTO dto) throws Exception {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("User already exists with this email.");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Hash password before saving (recommended)

        userRepository.save(user);
    }
}