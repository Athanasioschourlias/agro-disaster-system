package gr.hua.dit.agrodisastersystem.config;

import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        createUserIfNotFound("219113", "admin", "admin", "admin", "ADMIN", "admin@gmail.com");
        createUserIfNotFound("165905546", "farmer", "farmer", "farmer", "FARMER", "farmer@gmail.com");
        createUserIfNotFound("081086489", "employee", "employee", "employee", "EMPLOYEE", "employee@gmail.com");
    }

    private void createUserIfNotFound(String tinNumber, String firstName, String lastName, String password, String role, String email) {
        User userOptional = userRepository.findByTinNumber(tinNumber);

        if (userOptional==null) {
            User user = new User();
            user.setTin_number(tinNumber);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(role);
            user.setEmail(email);
            userRepository.save(user);
        }
    }
}
