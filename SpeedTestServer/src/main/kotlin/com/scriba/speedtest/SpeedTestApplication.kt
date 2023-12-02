package com.scriba.speedtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EntityScan
class SpeedTestApplication

fun main(args: Array<String>) {
	runApplication<SpeedTestApplication>(*args)
}
