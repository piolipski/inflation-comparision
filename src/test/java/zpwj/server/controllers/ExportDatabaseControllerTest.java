package zpwj.server.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
class ExportDatabaseControllerTest {
    @Autowired
    MockMvc mvc;

    @Container
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.2.0")
            .withDatabaseName("database")
            .withInitScript("database.sql");
    @DynamicPropertySource
    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username",mySQLContainer::getUsername);
        registry.add("spring.datasource.password",mySQLContainer::getPassword);
    }

    @BeforeAll
    static void setupDatabase() throws IOException {
        Path path = Paths.get("src/test/resources/database.sql");
        String content = Files.lines(path).collect(Collectors.joining("\n"));

        try (PrintWriter out = new PrintWriter("target/test-classes/database.sql")) {
            out.println(content);
        }

        MountableFile mountableFile = MountableFile.forClasspathResource("database.sql");
        mySQLContainer.withCopyFileToContainer(mountableFile, "/docker-entrypoint-initdb.d/database.sql");
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetAllAverageIncome()  throws Exception {
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/database/averageincome")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetAverageIncomeByCountryName() throws Exception {
        String countryName = "POLAND";

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.get("/api/database/averageincome/{countryName}", countryName)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetAllMinimalIncome() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/database/minimalincome")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetMinimalIncomeByCountryName() throws Exception {
        String countryName = "POLAND";

        MvcResult mvcResult = mvc.perform(
                        MockMvcRequestBuilders.get("/api/database/minimalincome/{countryName}", countryName)
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetAllBaseRetirementIncome() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/database/baseretirementincome")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetBaseRetirementIncomeByCountryName() throws Exception {
        String countryName = "POLAND";

        MvcResult mvcResult = mvc.perform(
                        MockMvcRequestBuilders.get("/api/database/baseretirementincome/{countryName}", countryName)
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetAllGdp() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/database/gdp")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetGdpByCountryName() throws Exception {
        String countryName = "POLAND";

        MvcResult mvcResult = mvc.perform(
                        MockMvcRequestBuilders.get("/api/database/gdp/{countryName}", countryName)
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetAllInflation() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/database/inflation")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response Content: " + content);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void testGetInflationByCountryName() throws Exception {
        String countryName = "POLAND";

        MvcResult mvcResult = mvc.perform(
                        MockMvcRequestBuilders.get("/api/database/inflation/{countryName}", countryName)
                                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response content: " + content);
    }
}