# <p align="center"><img src="src/main/resources/readme/medias/icon.png" width="140"> aws-opensearch-localstack</p>

<h4 align="center">AKA. aws-opensearch-localstack.</h4>

# How to install AWS OpenSearch with LocalStack

### Require
* Docker Compose
* Pip

Install Localstack `awslocal`. It uses awscli version 1.
_Reference: [LocalStack awslocal limitations](https://github.com/localstack/awscli-local#Limitations)_

```console
pip install awscli-local[ver1]
```

Now download `docker-compose.yml`, open terminal at the root of the project and run the following command
_Reference: [LocalStack install OpenSearch](https://docs.localstack.cloud/aws/opensearch/)_

```console
docker-compose -f ./docker/opensearch/docker-compose.yml up -d
```

Now run the following command to create OpenSearch domain

```console
awslocal opensearch create-domain --domain-name my-domain --endpoint-url http://localhost:4566
```

## How to use in Spring Boot

Create this configuration class

```kt
@Configuration
class OpenSearchConfig {
    @Bean
    fun restHighLevelClient(): RestHighLevelClient {
        val builder = RestClient.builder(
            HttpHost.create("http://localhost.localstack.cloud:4566"))
            .setPathPrefix("/opensearch/us-east-1/my-domain")
        return RestHighLevelClient(builder)
    }
}
```

and this controller

```kt
@RestController
@RequestMapping("search")
class SearchController(
    val client: RestHighLevelClient,
) {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    fun getSearch(searchRequest: SearchRequest) = client.search(searchRequest, RequestOptions.DEFAULT)
}
```

Now you can GET [http://localhost:8080/search](http://localhost:8080/search)

or

GET [http://localhost.localstack.cloud:4566/opensearch/us-east-1/my-domain](http://localhost.localstack.cloud:4566/opensearch/us-east-1/my-domain)

## FAQ

[https://github.com/localstack/localstack/issues/5723#issuecomment-1075311321](https://github.com/localstack/localstack/issues/5723#issuecomment-1075311321)
