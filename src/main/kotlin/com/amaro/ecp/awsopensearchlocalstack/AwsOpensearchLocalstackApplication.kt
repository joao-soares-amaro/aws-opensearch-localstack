package com.amaro.ecp.awsopensearchlocalstack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.amaro.ecp.awsopensearchlocalstack")
class AwsOpensearchLocalstackApplication

fun main(args: Array<String>) {
	runApplication<AwsOpensearchLocalstackApplication>(*args)
}
