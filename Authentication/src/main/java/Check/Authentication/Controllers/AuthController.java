package Check.Authentication.Controllers;

import Check.Authentication.DTO.AuthResponse;
import Check.Authentication.DTO.LoginRequest;
import Check.Authentication.DTO.OrganisationDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")  // Allow requests from all origins
public class AuthController {

//    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    public AuthController(JwtUtil jwtUtil) {
        //this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest request) {
        Organisation organisation = organisationRepository.findByEmail(request.getEmail()).orElseThrow();
        if(organisation.getPassword().equals(request.getPassword())){
           String token = jwtUtil.generateToken(request.getEmail());
           return ResponseEntity.ok(token);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


