package com.iii.amirutham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmiruthamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmiruthamApiApplication.class, args);
	}

	/*
	 * @Bean public LocaleResolver localeResolver() { // SessionLocaleResolver
	 * localeResolver = new SessionLocaleResolver(); AcceptHeaderLocaleResolver
	 * localeResolver = new AcceptHeaderLocaleResolver();
	 * localeResolver.setDefaultLocale(Locale.ENGLISH); return localeResolver; }
	 */
}
