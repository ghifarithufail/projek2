/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum;

import com.projek2.museum.models.Data_diri;
import com.projek2.museum.models.Rsv;
import com.projek2.museum.models.Tipe_tiket;
import com.projek2.museum.repositories.RsvRepository;
import com.projek2.museum.services.RsvService;
import static org.hamcrest.Matchers.containsString;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 *
 * @author Asus
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestRsv {
        @Autowired
        private MockMvc mockMvc;
        @InjectMocks
        @Autowired
        RsvService service;

        @Mock
        RsvRepository repository; 
         
//         @Test
//    public void testCreateRsv() throws Exception{
//        
//        Tipe_tiket tipe =  new Tipe_tiket();
//        tipe.setId(1);
//        
//        Data_diri data =  new Data_diri();
//        data.setId(4);
//        
//        Rsv rsv = new Rsv();
//        rsv.setCount(3);
//        rsv.setDateR("02/01/06");
//        rsv.setData_diri(data);
//        rsv.setTipe_tiket(tipe);
//        
//        mockMvc.perform(post("/rsv/stores")
//                .flashAttr("rsv", rsv))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/home"));
//    }
    
         @Test
    public void createRsvWithEmptyDate() throws Exception {
        Throwable e = null;
        String message = null;
        
         Tipe_tiket tipe =  new Tipe_tiket();
        tipe.setId(1);
        
        Data_diri data =  new Data_diri();
        data.setId(4);
        
        
  
        try {
             Rsv rsv = new Rsv();
             rsv.setCount(3);
             rsv.setDateR("");
             rsv.setData_diri(data);
             rsv.setTipe_tiket(tipe);

            when(repository.save(rsv))
                    .thenThrow(new Exception("Password cannot be null"));
            service.store(rsv);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
}