package com.mvpolx.olx;

import org.springframework.boot.SpringApplication;

public class TestOlxApplication {

	public static void main(String[] args) {
		SpringApplication.from(OlxApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
