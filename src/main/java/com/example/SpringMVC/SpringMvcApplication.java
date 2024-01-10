package com.example.SpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApplication {
	//Componentscan의 범위는 SpringApplication의 package의 하위 패키지이다.
	//그래서 위부 디렉토리에 @Componnen 스캔을 하더라도 컴포넌트 스캔의 대상이
	//되지 않기 때문에, 스프링 빈으로 등록하지 않는다.

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
