/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum.services;


import com.projek2.museum.interfaces.Tipe_tiketInterface;
import com.projek2.museum.models.Tipe_tiket;
import com.projek2.museum.repositories.Tipe_tiketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class Tipe_tiketService implements Tipe_tiketInterface {

    @Autowired
    private Tipe_tiketRepository Tipe_tiketRepository;

    @Override
    public List<Tipe_tiket> getAll() {
        return Tipe_tiketRepository.findAll();
    }
}