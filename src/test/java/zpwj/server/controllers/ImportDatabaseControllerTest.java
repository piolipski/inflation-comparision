package zpwj.server.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;
import org.testcontainers.utility.MountableFile;
import zpwj.server.models.AverageIncome;
import zpwj.server.models.BaseRetirementIncome;
import zpwj.server.payload.request.*;
import zpwj.server.repository.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class ImportDatabaseControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    AverageIncomeRepository averageIncomeRepository;
    @Autowired
    BaseRetirementIncomeRepository baseRetirementIncomeRepository;
    @Autowired
    GdpRepository gdpRepository;
    @Autowired
    InflationRepository inflationRepository;
    @Autowired
    MinimalIncomeRepository minimalIncomeRepository;

    @Container
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.2.0")
            .withDatabaseName("database").
            withInitScript("database_schema.sql");

    @DynamicPropertySource
    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username",mySQLContainer::getUsername);
        registry.add("spring.datasource.password",mySQLContainer::getPassword);
    }

    @BeforeAll
    static void setupDatabase() throws IOException {
        Path path = Paths.get("src/test/resources/database_schema.sql");
        String content = Files.lines(path).collect(Collectors.joining("\n"));

        try (PrintWriter out = new PrintWriter("target/test-classes/database_schema.sql")) {
            out.println(content);
        }

        MountableFile mountableFile = MountableFile.forClasspathResource("database_schema.sql");
        mySQLContainer.withCopyFileToContainer(mountableFile, "/docker-entrypoint-initdb.d/database_schema.sql");
    }


    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void testAddAverageIncome() throws Exception {
        ClassPathResource resource = new ClassPathResource("averageincome.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(resource.getURI()));
        ObjectMapper objectMapper = new ObjectMapper();

        List<AverageIncomeRequest> averageIncomeRequests = objectMapper.readValue(jsonData, new TypeReference<>() {});

        MvcResult mvcresult = mvc.perform(
                MockMvcRequestBuilders.post("/api/database/averageincome")
                        .content(objectMapper.writeValueAsString(averageIncomeRequests))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);

        mvcresult = mvc.perform(MockMvcRequestBuilders.get("/api/database/averageincome")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void testAddBaseRetirementIncome() throws Exception {
        ClassPathResource resource = new ClassPathResource("baseretirementincome.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(resource.getURI()));
        ObjectMapper objectMapper = new ObjectMapper();

        List<BaseRetirementRequest> baseRetirementRequests = objectMapper.readValue(jsonData, new TypeReference<>() {});

        MvcResult mvcresult = mvc.perform(
                        MockMvcRequestBuilders.post("/api/database/baseretirementincome")
                                .content(objectMapper.writeValueAsString(baseRetirementRequests))
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);

        mvcresult = mvc.perform(MockMvcRequestBuilders.get("/api/database/baseretirementincome")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void testAddGdp() throws Exception {
        ClassPathResource resource = new ClassPathResource("gdp.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(resource.getURI()));
        ObjectMapper objectMapper = new ObjectMapper();

        List<GdpRequest> gdpRequests = objectMapper.readValue(jsonData, new TypeReference<>() {});

        MvcResult mvcresult = mvc.perform(
                        MockMvcRequestBuilders.post("/api/database/gdp")
                                .content(objectMapper.writeValueAsString(gdpRequests))
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);

        mvcresult = mvc.perform(MockMvcRequestBuilders.get("/api/database/gdp")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void testAddInflation() throws Exception {
        ClassPathResource resource = new ClassPathResource("inflation.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(resource.getURI()));
        ObjectMapper objectMapper = new ObjectMapper();

        List<InflationRequest> inflationRequests = objectMapper.readValue(jsonData, new TypeReference<>() {});

        MvcResult mvcresult = mvc.perform(
                        MockMvcRequestBuilders.post("/api/database/inflation")
                                .content(objectMapper.writeValueAsString(inflationRequests))
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);

        mvcresult = mvc.perform(MockMvcRequestBuilders.get("/api/database/inflation")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void testAddMinimalIncome() throws Exception {
        ClassPathResource resource = new ClassPathResource("minimalincome.json");
        byte[] jsonData = Files.readAllBytes(Paths.get(resource.getURI()));
        ObjectMapper objectMapper = new ObjectMapper();

        List<MinimalIncomeRequest> minimalIncomeRequests = objectMapper.readValue(jsonData, new TypeReference<>() {});

        MvcResult mvcresult = mvc.perform(
                        MockMvcRequestBuilders.post("/api/database/minimalincome")
                                .content(objectMapper.writeValueAsString(minimalIncomeRequests))
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);

        mvcresult = mvc.perform(MockMvcRequestBuilders.get("/api/database/minimalincome")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        content = mvcresult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }
}