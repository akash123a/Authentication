//package Check.Authentication.Controllers;
//
//import Check.Authentication.Entities.OrganisationAdmin;
//import Check.Authentication.Repositories.OrganisationAdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/organisation-admin")
//public class OrganisationAdminController {
//
//    @Autowired
//    private OrganisationAdminRepository organisationAdminRepository;
//
//    @GetMapping("/all")
//    public List<OrganisationAdmin> getAllAdmins() {
//        return organisationAdminRepository.findAll();
//    }
//}




package Check.Authentication.Controllers;

import Check.Authentication.Entities.OrganisationAdmin;
import Check.Authentication.Services.OrganisationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/organisation-admin")
@CrossOrigin(origins = "*") // Allow frontend access
public class OrganisationAdminController {

    @Autowired
    private OrganisationAdminService adminService;

    // ✅ Create a new admin (with duplicate check)
    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody OrganisationAdmin admin) {
        try {
            OrganisationAdmin savedAdmin = adminService.saveAdmin(admin);
            return ResponseEntity.ok(savedAdmin);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Fetch all admins
    @GetMapping("/all")
    public ResponseEntity<List<OrganisationAdmin>> getAllAdmins() {
        List<OrganisationAdmin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    // ✅ Fetch admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable UUID id) {
        Optional<OrganisationAdmin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
