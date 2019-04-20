package com.didispace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "com.didispace.mapper")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}
