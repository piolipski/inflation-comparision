package zpwj.server.controllers;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import zpwj.server.models.ERole;
import zpwj.server.models.Role;
import zpwj.server.models.User;
import zpwj.server.payload.request.LoginRequest;
import zpwj.server.payload.request.SignupRequest;
import zpwj.server.repository.RoleRepository;
import zpwj.server.repository.UserRepository;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
@Transactional
class AuthControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.2.0");
    @DynamicPropertySource
    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username",mySQLContainer::getUsername);
        registry.add("spring.datasource.password",mySQLContainer::getPassword);
    }

    @Test
    public void testSignInEndpoint() throws Exception {
        Role roleUser = new Role(null, ERole.ROLE_USER);
        roleUser.setName(ERole.ROLE_USER);
        roleRepository.save(roleUser);

        HashSet<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);

        User user = new User("user", passwordEncoder.encode("user"));
        user.setRoles(userRoles);
        userRepository.save(user);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user");
        loginRequest.setPassword("user");

        MvcResult result = mvc.perform(MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .content(new ObjectMapper().writeValueAsString(loginRequest))
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    public void testSignUpEndpoint() throws Exception {
        Role roleUser = new Role(null, ERole.ROLE_USER);
        roleUser.setName(ERole.ROLE_USER);
        roleRepository.save(roleUser);

        SignupRequest signUpRequest = new SignupRequest();
        signUpRequest.setUsername("testUser");
        signUpRequest.setPassword("testPassword");

        MvcResult result = mvc.perform(MockMvcRequestBuilders
                        .post("/api/auth/signup")
                        .content(new ObjectMapper().writeValueAsString(signUpRequest))
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }
}