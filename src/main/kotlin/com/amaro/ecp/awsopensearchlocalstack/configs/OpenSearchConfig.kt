package com.amaro.ecp.awsopensearchlocalstack.configs

import org.apache.http.HttpHost
import org.opensearch.client.RestClient
import org.opensearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenSearchConfig {
    @Bean
    fun restHighLevelClient(): RestHighLevelClient {
        val builder = RestClient.builder(
            HttpHost.create("http://localhost.localstack.cloud:4566"))
            .setPathPrefix("/opensearch/us-east-1/dm-demo")
        return RestHighLevelClient(builder)
    }
}