//package Check.Authentication.Services;
//
//import Check.Authentication.Entities.OrganisationAdmin;
//import Check.Authentication.Repositories.OrganisationAdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrganisationAdminService {
//
//    @Autowired
//    private OrganisationAdminRepository adminRepository;
//
//    public OrganisationAdmin saveAdmin(OrganisationAdmin admin) {
//        return adminRepository.save(admin);
//    }
//}



package Check.Authentication.Services;

import Check.Authentication.Entities.OrganisationAdmin;
import Check.Authentication.Repositories.OrganisationAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganisationAdminService {

    @Autowired
    private OrganisationAdminRepository adminRepository;

    // ✅ Save admin (checks for duplicate email)
//    public OrganisationAdmin saveAdmin(OrganisationAdmin admin) {
//        Optional<OrganisationAdmin> existingAdmin = adminRepository.findByEmail(admin.getEmail());
//        if (existingAdmin.isPresent()) {
//            throw new RuntimeException("Admin with this email already exists!");
//        }
//        return adminRepository.save(admin);
//    }

    public OrganisationAdmin saveAdmin(OrganisationAdmin admin) {
        Optional<OrganisationAdmin> existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin.isPresent()) {
            throw new RuntimeException("Admin with this email already exists!");
        }

        // 🔐 Set default role if not already set
        if (admin.getRole() == null || admin.getRole().isBlank()) {
            admin.setRole("ADMIN");
        }

        return adminRepository.save(admin);
    }










    // ✅ Find admin by email
    public Optional<OrganisationAdmin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    // ✅ Get admin by ID
    public Optional<OrganisationAdmin> getAdminById(UUID id) {
        return adminRepository.findById(id);
    }

    public List<OrganisationAdmin> getAllAdmins() {
        return List.of();
    }
}
