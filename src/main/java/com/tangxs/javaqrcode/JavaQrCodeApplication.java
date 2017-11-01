package com.tangxs.javaqrcode;

import com.tangxs.javaqrcode.task.TaskThreadPoolProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author  tangxs
 * @EnableConfigurationProperties 开启配置属性支持
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableConfigurationProperties({TaskThreadPoolProperties.class} )
public class JavaQrCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaQrCodeApplication.class, args);
	}
}
