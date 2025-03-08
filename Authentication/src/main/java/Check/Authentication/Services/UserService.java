package Check.Authentication.Services;

import Check.Authentication.DTO.LoginRequest;
import Check.Authentication.DTO.LoginResponse;
import Check.Authentication.DTO.UserDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganisationRepository organisationRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    // Create a new user
    public User createUser(UserDTO userDTO) {
        // Fetch the organisation by ID
        Organisation organisation = organisationRepository.findById(userDTO.getOrganisationId())
                .orElseThrow(() -> new RuntimeException("Organisation not found with id: " + userDTO.getOrganisationId()));

        // Create a new User entity
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setPassword(userDTO.getPassword()); // Note: Password should be hashed before saving
        user.setOrganisation(organisation);

        // Save the user to the database
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(UUID id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());
            user.setPassword(userDTO.getPassword()); // Note: Password should be hashed before saving

            // Fetch and update the organisation
            Organisation organisation = organisationRepository.findById(userDTO.getOrganisationId())
                    .orElseThrow(() -> new RuntimeException("Organisation not found with id: " + userDTO.getOrganisationId()));
            user.setOrganisation(organisation);

            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    // Delete user by ID
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    // Login method
    public User login(String email, String password) {
        // Find the user by email
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if the password matches
            if (user.getPassword().equals(password)) {
                return user; // Return the user if login is successful
            } else {
                throw new RuntimeException("Invalid password");
            }
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }

    // Login method
    public LoginResponse login(LoginRequest loginRequest) {
        // Find the user by email
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if the password matches
            if (user.getPassword().equals(loginRequest.getPassword())) {
                // Return login response
                return new LoginResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole()
                );
            } else {
                throw new RuntimeException("Invalid password");
            }
        } else {
            throw new RuntimeException("User not found with email: " + loginRequest.getEmail());
        }
    }
}