package com.patsuyash.cartRest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.patsuyash.cartRest.service.ProductService;
import com.patsuyash.cartRest.service.UserService;

/**
 * @author Suyash
 *
 */
@SpringBootApplication
public class ShoppingCartApplication {
	@Value("${cartRest.cors.allowedOrigin:http://localhost:8180}")
	private String allowedHost;

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ShoppingCartApplication.class, args);

		ProductService productService = applicationContext.getBean(ProductService.class);
		productService.saveInitialBatch();

		UserService userService = applicationContext.getBean(UserService.class);
		userService.saveInitialBatch();

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		System.out.println("sssssssssssssssssssssssssssssss" + allowedHost);
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(allowedHost).allowedMethods("PUT", "DELETE", "GET", "POST");
			}
		};
	}
}
