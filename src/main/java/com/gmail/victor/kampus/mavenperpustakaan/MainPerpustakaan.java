/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.victor.kampus.mavenperpustakaan;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPerpustakaan {

    public static void main(String[] args) {
        boolean isTambah = true;
        Scanner input = new Scanner(System.in);
        Perpustakaan perpus = new Perpustakaan();
        String isbn;
        char keyakinan;
        Map<String, Book> daftarBuku = new LinkedHashMap<String, Book>();
        while (isTambah) {
            System.out.println(" ***********************************************************");
            System.out.println(" Tambah Data Buku ! ");
            System.out.print(" Judul Buku : ");
            Book book = new Book();
            book.setTitle(input.next());
            System.out.print(" Pengarang : ");
            book.setAuthor(input.next());
            System.out.print(" No ISBN : ");
            isbn = input.next();
            System.out.println("Yakin menambahkan data berikut ? " + book.getAuthor() + " / " + book.getTitle() + " Y/F");
            keyakinan = input.next().charAt(0);
            if (keyakinan == 'Y') {
                daftarBuku.put(isbn, book);
            } else if (keyakinan == 'F') {
                System.out.println(book.getAuthor() + " / " + book.getTitle() + " tidak jadi ditambahkan ");
            }

            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
        for (Map.Entry<String, Book> entry : daftarBuku.entrySet()) {
            System.out.println(entry.getKey());
            Book buku = entry.getValue();
            System.out.println(" Judul  Buku : " + buku.getTitle() + "  penarang " + buku.getAuthor());
        }
        System.out.println("____________________________________________________________________ ");
        System.out.println(" ***********************************************************");
        System.out.println(" Hapus buku dengan No ISBN :  ");
        isbn = input.next();
        System.out.println("Yakin menghapus buku dengan No ISBN ? " + isbn +  " Y/F");
        keyakinan = input.next().charAt(0);
        if (keyakinan == 'Y') {
            daftarBuku.remove(input.next());
        } else if (keyakinan == 'F') {
            System.out.println( "Buku dengan No "+ isbn + " tidak jadi dihapus ");
        }

        System.out.println("____________________________________________________________________ ");
        for (Map.Entry<String, Book> entry : daftarBuku.entrySet()) {
            System.out.println(" ***********************************************************");
            System.out.println(entry.getKey());
            Book buku = entry.getValue();
            System.out.println(" Judul  Buku : " + buku.getTitle() + "  penarang " + buku.getAuthor());
        }
        System.out.println("____________________________________________________________________ ");
    }

}
