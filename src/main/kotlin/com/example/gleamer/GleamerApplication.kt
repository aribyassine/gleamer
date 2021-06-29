package com.example.gleamer

import com.example.gleamer.storage.StorageProperties
import com.example.gleamer.storage.StorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties::class)
class GleamerApplication{
	@Bean
	fun init(storageService: StorageService): CommandLineRunner? {
		return CommandLineRunner {
			storageService.deleteAll()
			storageService.init()
		}
	}
}
fun main(args: Array<String>) {
	runApplication<GleamerApplication>(*args)
}
