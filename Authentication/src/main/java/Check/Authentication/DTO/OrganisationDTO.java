package Check.Authentication.DTO;

import Check.Authentication.enums.Subscription;

public class OrganisationDTO {

    private String name;
    private String email;
    private String password;
    private Subscription subscription;

    // Default constructor
    public OrganisationDTO() {
    }

    // Parameterized constructor
    public OrganisationDTO(String name, String email, String password, Subscription subscription) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscription = subscription;
    }

    // Getters and Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}