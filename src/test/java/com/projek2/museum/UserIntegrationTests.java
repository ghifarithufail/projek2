/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum;

/**
 *
 * @author Asus
 */

import com.projek2.museum.models.User;
import com.projek2.museum.repositories.UserRepository;
import com.projek2.museum.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserIntegrationTests {

    @InjectMocks
    @Autowired
    UserService service;

    @Mock
    UserRepository repository;

    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setEmail("bunga@mail.com");
        user.setName("Bunga");
        user.setPassword("password");

        when(repository.save(user)).thenReturn(user);
        service.register(user);

        when(repository.findByEmail("test@mail.com")).thenReturn(user);

        User checkUser = this.repository.findByEmail("test@mail.com");

        Assertions.assertEquals(user, checkUser);
    }

    @Test
    public void createUserTestWithEmptyName() throws Exception {
        User user = new User();
        user.setEmail("ghifari@mail.com");
        user.setName("");
        user.setPassword("password");

        when(repository.save(user)).thenReturn(user);
        service.register(user);

        when(repository.findByEmail("test@mail.com")).thenReturn(user);

        User checkUser = this.repository.findByEmail("test@mail.com");

        Assertions.assertEquals(user, checkUser);
    }

    @Test
    public void createUserTestWithEmptyEmail() throws Exception {
        Throwable e = null;
        String message = null;
  
        try {
            User user = new User();
            user.setEmail("");
            user.setName("Ghifari");
            user.setPassword("password");

            when(repository.save(user))
                    .thenThrow(new Exception("Email cannot be null"));
            service.register(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
    @Test
    public void createUserTestWithEmptyPassword() throws Exception {
        Throwable e = null;
        String message = null;
  
        try {
            User user = new User();
            user.setEmail("Tester@gmail.com");
            user.setName("bunga");
            user.setPassword("");

            when(repository.save(user))
                    .thenThrow(new Exception("Password cannot be null"));
            service.register(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
}
