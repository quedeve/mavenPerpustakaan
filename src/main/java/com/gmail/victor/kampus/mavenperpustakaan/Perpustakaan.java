/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.victor.kampus.mavenperpustakaan;

import java.util.Map;

public class Perpustakaan {

    private Map<String, Book> daftarBuku;
    private String namaPerpustakaan;

    
    public Map<String, Book> getDaftarBuku() {
        return daftarBuku;
    }

    public void setDaftarBuku(Map<String, Book> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public String getNamaPerpustakaan() {
        return namaPerpustakaan;
    }

    public void setNamaPerpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
    }

}
