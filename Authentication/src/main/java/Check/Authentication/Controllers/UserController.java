package Check.Authentication.Controllers;

import Check.Authentication.DTO.UserDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Repositories.UserRepository;
import Check.Authentication.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/db/api/user")
public class UserController {

    @Autowired
    OrganisationRepository orgRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//


}