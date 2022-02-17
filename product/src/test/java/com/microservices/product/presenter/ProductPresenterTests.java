package com.microservices.product.presenter;

import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class ProductPresenterTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProducts() throws Exception {
        RequestBuilder requestBuilders = MockMvcRequestBuilders
                .get("/products")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilders)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void getSingleProduct() throws Exception {
        RequestBuilder requestBuilders = MockMvcRequestBuilders
                .get("/products/" + new Random().nextLong())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilders)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void createNewProductWithPayload() throws Exception {
        JSONObject payload = new JSONObject();
        payload.put("name", "Indomilk");
        payload.put("stock", new Random().nextInt());

        RequestBuilder requestBuilders = MockMvcRequestBuilders
                .post("/products")
                .accept(MediaType.APPLICATION_JSON)
                .content(payload.toJSONString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilders)
                .andReturn();

        // Assertion
        assertEquals(201, response.getResponse().getStatus());
    }

    @Test
    void createNewProductWithoutPayload() throws Exception {
        RequestBuilder requestBuilders = MockMvcRequestBuilders
                .post("/products")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilders)
                .andReturn();

        // Assertion
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    void updateWithPayloadProduct() throws Exception {
        JSONObject payload = new JSONObject();
        payload.put("name", "Indomilk");
        payload.put("stock", new Random().nextInt());

        RequestBuilder requestBuilders = MockMvcRequestBuilders
                .put("/products/" + new Random().nextLong())
                .accept(MediaType.APPLICATION_JSON)
                .content(payload.toJSONString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilders)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void updateWithoutPayloadProduct() throws Exception {
        RequestBuilder requestBuilders = MockMvcRequestBuilders
                .put("/products/" + new Random().nextLong())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilders)
                .andReturn();

        // Assertion
        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    void deleteProductById() throws Exception {
        RequestBuilder requestBuilders = MockMvcRequestBuilders
                .put("/products/" + new Random().nextLong())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilders)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }
}