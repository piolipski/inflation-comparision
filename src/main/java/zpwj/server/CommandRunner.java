package zpwj.server;

import zpwj.server.models.ERole;
import zpwj.server.models.Role;
import zpwj.server.models.User;
import zpwj.server.repository.RoleRepository;
import zpwj.server.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.beans.Encoder;
import java.util.HashSet;

@Component
@AllArgsConstructor
public class CommandRunner implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role(null, ERole.ROLE_ADMIN);
        roleRepository.save(roleAdmin);
        roleRepository.save(new Role(null, ERole.ROLE_USER));

        HashSet<Role> userRole = new HashSet<>();
        userRole.add(roleAdmin);
        User user = new User("admin", passwordEncoder.encode("admin123"));
        user.setRoles(userRole);
        userRepository.save(user);
    }
}
