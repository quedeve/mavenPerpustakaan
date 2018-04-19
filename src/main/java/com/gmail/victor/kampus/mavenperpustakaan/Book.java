/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.victor.kampus.mavenperpustakaan;

public class Book {

    private String title;
    private String author;
    private boolean isPinjam;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isPinjam() {
        return isPinjam;
    }

    public void setPinjam(boolean isPinjam) {
        this.isPinjam = isPinjam;
    }

}
