package com.pm.pmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@EnableScheduling
@SpringBootApplication
public class PopulationMapBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopulationMapBeApplication.class, args);
	}

}
