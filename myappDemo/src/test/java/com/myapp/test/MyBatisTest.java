package com.myapp.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.service.UserService;

public class MyBatisTest {

    private static ObjectMapper getJsonMapper() {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.enable(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS);
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return mapper;
    }
  
    public static void main(String[] args) {
		
    	ApplicationContext 	ac = new ClassPathXmlApplicationContext(new String[] { "spring-context.xml", "spring-mybatis.xml" });
    	UserService userService = (UserService) ac.getBean("userService");
    	List<String> cities = userService.getWorldCityNames();
    	for (String cityName : cities) {
			System.out.println(cityName);
		}
	}

}
