package Check.Authentication.DTO;

import java.util.UUID;

public class LoginResponse {

    private UUID userId; // User ID
    private String name; // User's name
    private String email; // User's email
    private String role; // User's role

    // Default constructor
    public LoginResponse() {
    }

    // Parameterized constructor
    public LoginResponse(UUID userId, String name, String email, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}