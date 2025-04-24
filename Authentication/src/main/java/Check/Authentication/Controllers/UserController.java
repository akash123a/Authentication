package Check.Authentication.Controllers;

import Check.Authentication.DTO.UserDTO;
import Check.Authentication.Repositories.UserRepository;
import Check.Authentication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * ✅ Handles registration after user clicks email link and submits form
     */

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        try {
            userService.registerUser(userDTO);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }


    /**
     * ✅ Sends invitation email with registration link
     */
    @PostMapping("/invite")
    public ResponseEntity<String> inviteUser(@RequestBody Map<String, String> payload) {
        try {
            String email = payload.get("email");
            if (email == null || email.isEmpty()) {
                return ResponseEntity.badRequest().body("Email is required.");
            }
            userService.sendInvitation(email);
            return ResponseEntity.ok("Invitation sent to " + email);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send invitation: " + e.getMessage());
        }
    }
}