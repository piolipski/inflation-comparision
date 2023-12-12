package zpwj.server;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import zpwj.server.models.ERole;
import zpwj.server.models.Role;
import zpwj.server.models.User;
import zpwj.server.repository.RoleRepository;
import zpwj.server.repository.UserRepository;

import java.util.HashSet;

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
        roleAdmin.setName(ERole.ROLE_ADMIN);
        roleRepository.save(roleAdmin);

        HashSet<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleAdmin);

        User user = new User("administrator", passwordEncoder.encode("administrator"));
        user.setRoles(adminRoles);
        userRepository.save(user);
        */
    }
}
