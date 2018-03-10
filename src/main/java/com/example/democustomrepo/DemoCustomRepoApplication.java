package com.example.democustomrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoCustomRepoApplication {

    private final UserRepository userRepository;

    @Autowired
    public DemoCustomRepoApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DemoCustomRepoApplication.class, args);
	}

	@Bean
    public CommandLineRunner runner() {
	    return args -> Stream.of(User.builder()
                .name("fred")
                .build())
                .map(userRepository::save)
                .map(User::getId)
                .map(userRepository::testMethod)
                .forEach(System.out::println);
    }
}
