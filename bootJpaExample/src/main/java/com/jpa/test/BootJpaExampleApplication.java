package com.jpa.test;

import org.springframework.context.ApplicationContext;

import java.util.List;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.Entity.User;
import com.jpa.test.dao.UserRepository;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootJpaExampleApplication.class, args);
		
        UserRepository userRep = context.getBean(UserRepository.class);
//        User user1 = new User();
//        user1.setCity("kotd");
//        user1.setName("gUSAIN");
//        user1.setStatus("java programmer");
//        
//        User user2 = new User();
//        user2.setCity("kotd");
//        user2.setName("Ashish");
//        user2.setStatus("java programmer");
//        
//      List<User> users= List.of(user1,user2);
//        
//        userRep.saveAll(users);
        Iterable<User> u=userRep.findByNameEndingWith("ish");
   if(u.equals(null)) {
	   System.out.println("it;s null");
   }
//        System.out.println(u);
   
   		userRep.getAllUser("gusain").forEach(user->{System.out.println(user);});
     System.out.println("\n");
   		u.forEach(user->{System.out.println(user);});
        
        
        
	}

}
