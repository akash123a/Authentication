package Check.Authentication.DTO;

import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String name;
    private String email;
    private String role;
    private String password;
    private UUID organisationId; // To associate the user with an organisation

    // Default constructor
    public UserDTO() {
    }

    // Parameterized constructor
    public UserDTO(UUID id, String name, String email, String role, String password, UUID organisationId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.organisationId = organisationId;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(UUID organisationId) {
        this.organisationId = organisationId;
    }
}