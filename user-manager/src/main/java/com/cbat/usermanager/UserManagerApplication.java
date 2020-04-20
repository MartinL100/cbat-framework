package com.cbat.usermanager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.cbat.usermanager","com.cbat.exceptionhandler"})
@SpringBootApplication
public class UserManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagerApplication.class, args);
	}
//	@Bean("shiroFilterMap")
//	public Map getFilterMap(){
//		Map map = new HashMap();
//		map.put("/addUser","authc");
//		map.put("/delUser","perms[1]");
//		return map;
//	}
}
