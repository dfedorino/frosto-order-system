package com.frosto.order_system.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.frosto.order_system.controller.OrderController.BASE_URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void test_when_get_order_then_200_ok() throws Exception {
        long orderId = 1;
        mockMvc.perform(get(BASE_URL + "/" + orderId))
                .andExpect(status().isOk());
    }

    @Test
    void test_when_get_order_then_string_with_id() throws Exception {
        long orderId = 1;
        mockMvc.perform(get(BASE_URL + "/" + orderId))
                .andExpect(content().string("Request for order with id: " + orderId));
    }

    @Test
    void test_when_create_order_then_200_ok() throws Exception {
        mockMvc.perform(post(BASE_URL))
                .andExpect(status().isOk());
    }

    @Test
    void test_when_create_order_then_string() throws Exception {
        mockMvc.perform(post(BASE_URL))
                .andExpect(content().string("Request to create a new order"));
    }

    @Test
    void test_when_delete_order_then_200_ok() throws Exception {
        long orderId = 1;
        mockMvc.perform(delete(BASE_URL + "/" + orderId))
                .andExpect(status().isOk());
    }

    @Test
    void test_when_delete_order_then_string_with_id() throws Exception {
        long orderId = 1;
        mockMvc.perform(delete(BASE_URL + "/" + orderId))
                .andExpect(content().string("Request to delete the order with id: " + orderId));
    }
}