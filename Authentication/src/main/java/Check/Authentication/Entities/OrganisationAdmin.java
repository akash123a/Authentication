//package Check.Authentication.Entities;
//
//import jakarta.persistence.*;
//import java.util.UUID;
//
//@Entity
//@Table(name = "organisation_admin")
//public class OrganisationAdmin {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    private String adminName;
//    private String email;
//
//    @OneToOne
//    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
//    private Organisation organisation;
//
//    public OrganisationAdmin() {}
//
//    public OrganisationAdmin(String adminName, String email, Organisation organisation) {
//        this.adminName = adminName;
//        this.email = email;
//        this.organisation = organisation;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getAdminName() {
//        return adminName;
//    }
//
//    public void setAdminName(String adminName) {
//        this.adminName = adminName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Organisation getOrganisation() {
//        return organisation;
//    }
//
//    public void setOrganisation(Organisation organisation) {
//        this.organisation = organisation;
//    }
//}













package Check.Authentication.Entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "organisation_admin")
public class OrganisationAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String adminName;

    private String email;

    @Column(nullable = false)
    private String role = "ADMIN"; // default role

    @OneToOne
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;

    public OrganisationAdmin() {}

    public OrganisationAdmin(String adminName, String email, Organisation organisation) {
        this.adminName = adminName;
        this.email = email;
        this.organisation = organisation;
        this.role = "ADMIN"; // default when using constructor
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}









