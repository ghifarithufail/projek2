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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="rsv")
public class Rsv {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="count")
    private long count;
    
    @Column(name="dateR")
    private String dateR;
    
   
    
    @ManyToOne
    @JoinColumn(name="data_id")
    private Data_diri data_diri;
    
    
    @ManyToOne
    @JoinColumn(name="tiket_id")
    private Tipe_tiket tipe_tiket;

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
    
    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public String getDateR() {
        return dateR;
    }
    
    
    public void setData_diri(Data_diri data_diri) {
        this.data_diri = data_diri;
    }

    public Data_diri getData_diri() {
        return data_diri;
    }
    
    public void setTipe_tiket(Tipe_tiket tipe_tiket) {
        this.tipe_tiket = tipe_tiket;
    }

    public Tipe_tiket getTipe_tiket() {
        return tipe_tiket;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
