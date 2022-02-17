package com.microservices.user.presenter;

import com.microservices.user.service.UserServiceImpl;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class UserPresenterTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @Test
    public void getAllUsers() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void getSingleUser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/users/" + new Random().nextLong())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void createNewUserWithPayload() throws Exception {
        JSONObject payload = new JSONObject();
        payload.put("name", "Ardi");
        payload.put("address", "Bantul");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/users")
                .content(payload.toJSONString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void createNewUserWithoutPayload() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
   public void updateUserWithPayload() throws Exception {
        JSONObject payload = new JSONObject();
        payload.put("name", "Ardi");
        payload.put("address", "Bantul");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/users/" + new Random().nextLong())
                .content(payload.toJSONString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void updateUserWithoutPayload() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/users/" + new Random().nextLong())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    public void deleteUser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/users/" + new Random().nextLong())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }
}