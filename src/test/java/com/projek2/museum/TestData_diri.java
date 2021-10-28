/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum;

import com.projek2.museum.models.Data_diri;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Asus
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestData_diri {
     @Autowired
    private MockMvc mockMvc;
     
      @Test
    public void testCreateData_diri() throws Exception{
        Data_diri data_diri = new Data_diri();
        data_diri.setNama("Fiqri");
        data_diri.setTanggal_lahir("02/01/06");
        data_diri.setAlamat("Bekasi");
        data_diri.setEmail("fiqri@gmail.com");
        
        mockMvc.perform(post("/data_diri/store")
                .flashAttr("data_diri", data_diri))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/rsv/creates"));
    }
}
