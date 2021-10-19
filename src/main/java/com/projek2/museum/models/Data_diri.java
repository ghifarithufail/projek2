/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="data_diri")
public class Data_diri {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="nama")
    private String nama;
    
    @Column(name="tanggal_lahir")
    private String tanggal_lahir;
    
    @Column(name="alamat")
    private String alamat;
    
    @Column(name="email")
    private String email;
    
    @Column(name="no_telp")
    private long no_telp;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setNo_telp(long no_telp) {
        this.no_telp = no_telp;
    }

    public long getNo_telp() {
        return no_telp;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}