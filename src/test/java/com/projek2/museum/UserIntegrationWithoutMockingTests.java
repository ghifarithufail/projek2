/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum;

import com.projek2.museum.models.User;
import com.projek2.museum.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Asus
 */
@SpringBootTest
public class UserIntegrationWithoutMockingTests {
    
    @Autowired
    UserService service;
    
    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setEmail("kentaro@mail.com");
        user.setName("kentaro");
        user.setPassword("3456");
        
        service.register(user);
        User checkUser = service.auth("kentaro@mail.com", "3456");
        
        Assertions.assertEquals(user.getEmail(), checkUser.getEmail());
    }
}
