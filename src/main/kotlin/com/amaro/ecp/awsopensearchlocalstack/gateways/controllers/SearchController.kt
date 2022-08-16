package com.amaro.ecp.awsopensearchlocalstack.gateways.controllers

import org.opensearch.action.search.SearchRequest
import org.opensearch.client.RequestOptions
import org.opensearch.client.RestHighLevelClient
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("search")
class SearchController(
    val client: RestHighLevelClient,
) {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    fun getSearch(searchRequest: SearchRequest) = client.search(searchRequest, RequestOptions.DEFAULT)
}