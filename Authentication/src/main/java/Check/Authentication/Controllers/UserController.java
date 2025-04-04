//package Check.Authentication.Controllers;
//
//import Check.Authentication.DTO.UserDTO;
//import Check.Authentication.Entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    // Get all users
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
//
//    // Get user by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
//        return userService.getUserById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Create a new user
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
//        User savedUser = userService.createUser(userDTO);
//        return ResponseEntity.status(201).body(savedUser);
//    }
//
//    // Update an existing user
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody UserDTO userDTO) {
//        User updatedUser = userService.updateUser(id, userDTO);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    // Delete user by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Login endpoint
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
//        User user = userService.login(email, password);
//        return ResponseEntity.ok(user);
//    }
//
//
//
//
//
//
//
//}