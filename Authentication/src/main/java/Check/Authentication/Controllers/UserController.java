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

////
////import Check.Authentication.DTO.UserDTO;
////import Check.Authentication.Entities.User;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////import java.util.UUID;
////
////@RestController
////@RequestMapping("/api/users")
////public class UserController {
////
////    @Autowired
////    private UserService userService;
////
////    // Get all users
////    @GetMapping
////    public ResponseEntity<List<User>> getAllUsers() {
////        return ResponseEntity.ok(userService.getAllUsers());
////    }
////
////    // Get user by ID
////    @GetMapping("/{id}")
////    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
////        return userService.getUserById(id)
////                .map(ResponseEntity::ok)
////                .orElse(ResponseEntity.notFound().build());
////    }
////
////    // Create a new user
////    @PostMapping
////    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
////        User savedUser = userService.createUser(userDTO);
////        return ResponseEntity.status(201).body(savedUser);
////    }
////
////    // Update an existing user
////    @PutMapping("/{id}")
////    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody UserDTO userDTO) {
////        User updatedUser = userService.updateUser(id, userDTO);
////        return ResponseEntity.ok(updatedUser);
////    }
////
////    // Delete user by ID
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
////        userService.deleteUser(id);
////        return ResponseEntity.noContent().build();
////    }
////
////    // Login endpoint
////    @PostMapping("/login")
////    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
////        User user = userService.login(email, password);
////        return ResponseEntity.ok(user);
////    }
////
////}
//
//
//
//
//
//
//package Check.Authentication.Controllers;
//
//import Check.Authentication.DTO.UserDTO;
//import Check.Authentication.Entities.User;
//import Check.Authentication.Services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
//        try {
//            User registered = userService.registerUser(userDTO);
//            return ResponseEntity.ok("User registered successfully! Email sent to: " + registered.getEmail());
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error: " + e.getMessage());
//        }
//    }
//}
//
//
//
//
//
//



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
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
//        try {
//            userService.registerNewUser(userDTO);
//            return ResponseEntity.ok("User registered successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
//        }
//    }

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