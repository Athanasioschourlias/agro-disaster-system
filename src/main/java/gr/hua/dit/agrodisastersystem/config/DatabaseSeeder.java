package gr.hua.dit.agrodisastersystem.config;

import gr.hua.dit.agrodisastersystem.model.Role;
import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.repository.RoleRepository;
import gr.hua.dit.agrodisastersystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public DatabaseSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Create roles
        Role adminRole = createRoleIfNotFound("ROLE_ADMIN");
        Role farmerRole = createRoleIfNotFound("ROLE_FARMER");
        Role employeeRole = createRoleIfNotFound("ROLE_EMPLOYEE");

        // Create users with these roles
        createUserIfNotFound("219113", "admin", "admin", "admin", Set.of(adminRole), "admin@gmail.com");
        createUserIfNotFound("165905546", "farmer", "farmer", "farmer", Set.of(farmerRole), "farmer@gmail.com");
        createUserIfNotFound("081086489", "employee", "employee", "employee", Set.of(employeeRole), "employee@gmail.com");
    }

    private Role createRoleIfNotFound(String name) {
        Optional<Role> roleOpt = roleRepository.findByName(name);
        if (roleOpt.isEmpty()) {
            Role newRole = new Role();
            newRole.setName(name);
            return roleRepository.save(newRole);
        }
        return roleOpt.get();
    }

    private void createUserIfNotFound(String tinNumber, String firstName, String lastName, String password, Set<Role> roles, String email) {
        User userOptional = userRepository.findByTinNumber(tinNumber);

        if (userOptional==null) {
            User user = new User();
            user.setTin_number(tinNumber);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles(roles);
            user.setEmail(email);
            userRepository.save(user);
        }
    }
}
