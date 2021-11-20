package com.iii.amirutham;

import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AmiruthamApiApplication {

	@Value(value = "${amirutham.payment.key}")
	private String razorPayKey;
	
	@Value(value = "${amirutham.payment.secret}")
	private String razorPaysecret;
	
	public static void main(String[] args) {
		SpringApplication.run(AmiruthamApiApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		// SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}

	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	  @Bean
	    public LocalValidatorFactoryBean validator() {
	        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	        bean.setValidationMessageSource(messageSource());
	        return bean;
	    }
	  
	  @Bean
	  public ModelMapper modelMapper() {
		  ModelMapper modelMapper = new ModelMapper();
		  ObjectMapper objectMapper;
		  modelMapper.getConfiguration().setAmbiguityIgnored(true);
		  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		    objectMapper = new ObjectMapper();
		    objectMapper.registerModule(new Jdk8Module());
			return modelMapper;
	  }
	  
	  @Bean
	  public RazorpayClient razorpayClient() {
		  
		  try {
			return new RazorpayClient(razorPayKey,razorPaysecret);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			log.error("Error creating bean. {}",e.getMessage());
			e.printStackTrace();
		}
		return null;
	       
	    }

}
