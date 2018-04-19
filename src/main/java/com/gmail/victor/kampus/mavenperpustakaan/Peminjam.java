/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.victor.kampus.mavenperpustakaan;

import java.util.List;
import java.util.Map;

/**
 *
 * @author victo
 */
public class Peminjam {

    private String Nama;
    private String Alamat;
    private Map<String, Book> buku;

    public Map<String, Book> getBuku() {
        return buku;
    }

    public void setBuku(Map<String, Book> buku) {
        this.buku = buku;
    }

    



    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
}
