package com.tangxs.javaqrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author  tangxs
 */
@SpringBootApplication
@EnableCaching
public class JavaQrCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaQrCodeApplication.class, args);
	}
}
