package com.example.recordofficeDB.controllers;



import com.example.recordofficeDB.Model.Roles;
import com.example.recordofficeDB.Model.User;
import com.example.recordofficeDB.Repository.RoleRepository;
import com.example.recordofficeDB.Repository.UserRepository;
import com.example.recordofficeDB.Services.AuthenticationService;
import com.example.recordofficeDB.Services.JwtService;
import com.example.recordofficeDB.dto.LoginResponse;
import com.example.recordofficeDB.dto.LoginUserDto;
import com.example.recordofficeDB.dto.RegisterUserDto;
import com.example.recordofficeDB.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/record/auth")
@RestController
@CrossOrigin
public class AuthenticationController {
    private final JwtService jwtService;

    @Autowired
    private RoleRepository roleRepository;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    public UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        loginResponse.setUserId(authenticatedUser.getUserId());
        loginResponse.setActive(authenticatedUser.isActive());
        loginResponse.setUsername(authenticatedUser.getUsername());
        loginResponse.setEmail(authenticatedUser.getEmail());
        loginResponse.setRoleName(authenticatedUser.getRoles().getRoleName());
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/activate")
    public ResponseEntity<String> activateUser(@RequestParam String token) {
        Optional<User> optionalUser = userRepository.findByActivationToken(token);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(true); // Activate the user
            user.setActivationToken(null); // Clear the activation token
            userRepository.save(user); // Save the changes

            return ResponseEntity.ok("User successfully activated.");
        } else {
            return ResponseEntity.badRequest().body("Invalid activation token.");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Roles> saveRole(@RequestBody RoleDTO roleDTO) {
        Roles savedRole = authenticationService.saveRole(roleDTO);
        return ResponseEntity.ok(savedRole);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = authenticationService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PutMapping("/updaterole/{roleId}")
    public ResponseEntity<Roles> updateRole(@PathVariable String roleId, @RequestBody RoleDTO roleDTO) {
        Roles updatedRole = authenticationService.updateRole(roleId, roleDTO);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/deleterole/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable String roleId) {
        authenticationService.deleteRole(roleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{roleId}/hide")
    public ResponseEntity<Roles> hideRole(@PathVariable String roleId) {
        Roles hiddenRole = authenticationService.hideRole(roleId);
        return ResponseEntity.ok(hiddenRole);
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<Roles> getRoleById(@PathVariable String roleId) {
        Roles role = authenticationService.getRoleById(roleId);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countUsersByRole(@RequestParam String roleName) {
        Optional<Roles> role = roleRepository.findByRoleName(roleName);

        if (role.isPresent()) {
            long count = authenticationService.countUsersByRole(role.get());
            return ResponseEntity.ok(count);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0L);
        }
    }
}

