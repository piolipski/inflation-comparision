package zpwj.server;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import zpwj.server.repository.RoleRepository;
import zpwj.server.repository.UserRepository;

@Component
@AllArgsConstructor
public class CommandRunner implements CommandLineRunner {
    RoleRepository roleRepository;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        /*
        Role roleAdmin = new Role(ERole.ROLE_ADMIN);
        roleRepository.save(roleAdmin);
        roleRepository.save(new Role(ERole.ROLE_USER));

        HashSet<Role> userRole = new HashSet<>();
        userRole.add(roleAdmin);
        User user = new User("admin", passwordEncoder.encode("admin123"));
        user.setRoles(userRole);
        userRepository.save(user);
         */
    }
}