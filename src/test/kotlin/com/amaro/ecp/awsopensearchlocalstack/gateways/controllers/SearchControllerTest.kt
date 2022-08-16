package com.amaro.ecp.awsopensearchlocalstack.gateways.controllers

import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.beans.factory.annotation.Autowired
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.opensearch.client.RestHighLevelClient
import org.springframework.boot.test.mock.mockito.MockBean

@ExtendWith(MockitoExtension::class)
@WebMvcTest
@ContextConfiguration(
    classes = [
        SearchController::class,
    ]
)
internal class SearchControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var client: RestHighLevelClient

    @Nested
    @DisplayName("GET /search")
    inner class GetSearch {
        @Test
        fun `search should return Ok`() {
            mockMvc.perform(get("/search"))
                .andExpect(status().isOk)
                .andReturn()
        }
    }
}