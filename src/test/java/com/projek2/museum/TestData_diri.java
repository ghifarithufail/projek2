/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum;

import com.projek2.museum.models.Data_diri;
import com.projek2.museum.models.Rsv;
import com.projek2.museum.models.Tipe_tiket;
import com.projek2.museum.repositories.Data_diriRepository;
import com.projek2.museum.services.Data_diriService;
import net.bytebuddy.utility.RandomString;
import static org.hamcrest.Matchers.containsString;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 *
 * @author Asus
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestData_diri {
    
     @InjectMocks
    @Autowired
    Data_diriService service;

    @Mock
    Data_diriRepository repository;
     @Autowired
    private MockMvc mockMvc;
     
      @Test
    public void testCreateData_diri() throws Exception{
        Data_diri data_diri = new Data_diri();
        data_diri.setNama("Fiqri");
        data_diri.setTanggal_lahir("02/01/06");
        data_diri.setAlamat("timur");
        data_diri.setEmail("fiqri@gmail.com");
        
        mockMvc.perform(post("/data_diri/store")
                .flashAttr("data_diri", data_diri))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/rsv/creates"));
    }
         @Test
    public void createData_diriWithEmptyDate() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
             Data_diri data_diri = new Data_diri();
            data_diri.setNama("aisyah");
            data_diri.setTanggal_lahir("");
            data_diri.setAlamat("jakarta");
            data_diri.setEmail("aisyah@gmail.com");

            when(repository.save(data_diri))
                    .thenThrow(new Exception("please fill out this field"));
            service.store(data_diri);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }

    @Test
    public void CreateData_diriWithoutEmail() throws Exception{
         Throwable e = null;
        String message = null;
        
        try {
             Data_diri data_diri = new Data_diri();
            data_diri.setNama("aiga");
            data_diri.setTanggal_lahir("03/02/13");
            data_diri.setAlamat("jakarta");
            data_diri.setEmail("");

            when(repository.save(data_diri))
                    .thenThrow(new Exception("please fill out this field"));
            service.store(data_diri);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
}
    
        @Test
    public void CreateData_diriWithoutNama() throws Exception{
        Throwable e = null;
        String message = null;
        
        try {
             Data_diri data_diri = new Data_diri();
            data_diri.setNama("");
            data_diri.setTanggal_lahir("03/02/13");
            data_diri.setAlamat("jakarta");
            data_diri.setEmail("test@gamil.com");

            when(repository.save(data_diri))
                    .thenThrow(new Exception("please fill out this field"));
            service.store(data_diri);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
}
    
     @Test
     public void testData_diriThenReservasi() throws Exception {
        mockMvc.perform(get("/data_diri/create"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Data Diri")));
        
        
       
        Data_diri data_diri = new Data_diri();
        data_diri.setNama("Vania");
        data_diri.setTanggal_lahir("01/12/31");
        data_diri.setAlamat("Cibubur");
        data_diri.setEmail("Vania@gmail.com");

        mockMvc.perform(post("/data_diri/store")
                .flashAttr("data_diri",data_diri))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/rsv/creates"));

        mockMvc.perform(get("/rsv/creates"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Reservasi")));

        
        Tipe_tiket tipe =  new Tipe_tiket();
        tipe.setId(1);
        
        Data_diri data =  new Data_diri();
        data.setId(4);
         
        Rsv rsv = new Rsv();
        rsv.setCount(3);
        rsv.setDateR("12/03/04");
        rsv.setData_diri(data);
        rsv.setTipe_tiket(tipe);
        
        mockMvc.perform(post("/rsv/stores")
                .flashAttr("rsv", rsv))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/home"))
                .andDo(print());
    }
}