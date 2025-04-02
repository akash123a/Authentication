package Check.Authentication.Entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "organisationsignup")
public class OrganisationSignup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String password;
    private String companyName;
    private String subscription;

    private String payment = "pending"; // Default payment status

    public OrganisationSignup() {
        this.payment = "pending"; // Ensure default value
    }

    // Getters and Setters
    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getSubscription() { return subscription; }

    public void setSubscription(String subscription) { this.subscription = subscription; }

    public String getPayment() { return payment; }

    public void setPayment(String payment) { this.payment = payment; }
}
