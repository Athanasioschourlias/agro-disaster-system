package gr.hua.dit.agrodisastersystem.service;

import gr.hua.dit.agrodisastersystem.model.Role;
import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.repository.RoleRepository;
import gr.hua.dit.agrodisastersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByTin(String TIN) {
        return userRepository.findByTinNumber(TIN);
    }


    public String createUser(User user, Set<String> roleNames) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Set<Role> roles = new HashSet<>();
        StringBuilder errorBuilder = new StringBuilder();

        for (String roleName : roleNames) {
            Role foundRole = roleRepository.findByName(roleName)
                    .orElse(null);
            if (foundRole != null) {
                roles.add(foundRole);
            } else {
                errorBuilder.append("Role not found: ").append(roleName).append("; ");
            }
        }

        if (!errorBuilder.isEmpty()) {
            return errorBuilder.toString();
        }

        try {
            user.setRoles(roles);
            userRepository.save(user);
            return "User created successfully";
        } catch (DataIntegrityViolationException e) {
            return "Error creating user: " + e.getMessage();
        }
    }
}
