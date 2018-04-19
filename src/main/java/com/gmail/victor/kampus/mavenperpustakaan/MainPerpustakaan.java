/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.victor.kampus.mavenperpustakaan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainPerpustakaan {

    public static void main(String[] args) {
        boolean isTambah = true;
        Scanner input = new Scanner(System.in);
        Perpustakaan perpus = new Perpustakaan();
        String isbn;
        String keyakinan;
        Map<String, Book> daftarBuku = new LinkedHashMap<String, Book>();
        Map<String, Peminjam> daftarManusia = new LinkedHashMap<String, Peminjam>();
        Map<String, Book> bukuDipinjam = new LinkedHashMap<String, Book>();
        Peminjam manusia = new Peminjam();

        add(input, daftarBuku, isTambah);
//        update(input, daftarBuku);
//        delete(input, daftarBuku);
        addPeminjam(input, isTambah, daftarManusia);
        
        meminjam(daftarBuku, daftarManusia, input, isTambah);

    }

    private static void meminjam(Map<String, Book> daftarBuku, Map<String, Peminjam> daftarManusia, Scanner input, Boolean isTambah) {
        String isbn;
        String keyakinan;
        System.out.println("ID Peminjam");
        String idPeminjam = input.next();
        System.out.println("Nama : "+daftarManusia.get(idPeminjam).getNama()+ " Alamat : "+ daftarManusia.get(idPeminjam).getAlamat() );
        Map<String, Book> mBuku = new LinkedHashMap<String, Book>();
        while (isTambah) {
            System.out.println(" ***********************************************************");
            System.out.println("Pinjam Buku");
            System.out.print(" ISBN : ");
            isbn = input.next();
            System.out.println("judul "+daftarBuku.get(isbn).getTitle()+" pengaran"+ daftarBuku.get(isbn).getAuthor() + "yakin menambahkan buku berikut? Y/F");
            keyakinan = input.next();

            if (keyakinan.equals("Y")) {
                Book buku = new Book();
                buku.setTitle(daftarBuku.get(isbn).getTitle());
                buku.setAuthor(daftarBuku.get(isbn).getAuthor());
                
                mBuku.put(isbn, buku);
                daftarManusia.get(idPeminjam).setBuku(mBuku);
            } else if (keyakinan.equals("F")) {
                System.out.println("Tidak Jadi Meminjam");
            }

            System.out.print(" Tambah data Pinjaman Kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
        System.out.println("Judul buku yang "+daftarManusia.get(idPeminjam).getNama()+" adalah" );
        for (Map.Entry<String, Book> entry : daftarManusia.get(idPeminjam).getBuku().entrySet()) {
            System.out.println(entry.getKey());
            Book buku = entry.getValue();
            System.out.println(" Judul  : " + buku.getTitle() + "  Pengaran " + buku.getAuthor());
        }
    }

    private static void addPeminjam(Scanner input, Boolean isTambah, Map<String, Peminjam> daftarManusia) {
        String id;
        String keyakinan;
        while (isTambah) {
            System.out.println(" ***********************************************************");
            System.out.println(" Tambah Data Peminjam ! ");
            System.out.print(" Nama : ");
            Peminjam manusia = new Peminjam();
            manusia.setNama(input.next());
            System.out.print(" Alamat : ");
            manusia.setAlamat(input.next());
            System.out.print(" ID : ");
            id = input.next();
            System.out.println("Yakin menambahkan data berikut ? " + manusia.getNama() + " / " + manusia.getAlamat() + " Y/F");
            keyakinan = input.next();

            if (keyakinan.equals("Y")) {
                daftarManusia.put(id, manusia);
            } else if (keyakinan.equals("F")) {
                System.out.println(manusia.getNama() + " / " + manusia.getAlamat() + " tidak jadi ditambahkan ");
            }

            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
        for (Map.Entry<String, Peminjam> entry : daftarManusia.entrySet()) {
            System.out.println(entry.getKey());
            Peminjam manusia = entry.getValue();
            System.out.println(" Nama : " + manusia.getNama() + "  Alamat " + manusia.getAlamat());
        }
    }

    private static void add(Scanner input, Map<String, Book> daftarBuku, Boolean isTambah) {
        String isbn;
        String keyakinan;
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
            keyakinan = input.next();

            if (keyakinan.equals("Y")) {
                daftarBuku.put(isbn, book);
            } else if (keyakinan.equals("F")) {
                System.out.println(book.getAuthor() + " / " + book.getTitle() + " tidak jadi ditambahkan ");
            }

            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
        for (Map.Entry<String, Book> entry : daftarBuku.entrySet()) {
            System.out.println(entry.getKey());
            Book buku = entry.getValue();
            System.out.println(" Judul  Buku : " + buku.getTitle() + "  pengarang " + buku.getAuthor());
        }
    }

    private static void delete(Scanner input, Map<String, Book> daftarBuku) {
        String isbn;
        String keyakinan;
        System.out.println("____________________________________________________________________ ");
        System.out.println(" ***********************************************************");
        System.out.println(" Hapus buku dengan No ISBN :  ");
        isbn = input.next();
        System.out.println("Yakin menghapus buku dengan No ISBN ? " + isbn + " Y/F");

        keyakinan = input.next();

        if (keyakinan.equals("Y")) {
            daftarBuku.remove(isbn);
            System.out.println("data telah dihapus");
        } else if (keyakinan.equals("F")) {
            System.out.println("Buku dengan No " + isbn + " tidak jadi dihapus ");
        } else {
            System.out.println(keyakinan);
            System.out.println("error");
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

    private static void update(Scanner input, Map<String, Book> daftarBuku) {
        String isbn;
        String keyakinan;
        //Upadate
        System.out.println("____________________________________________________________________ ");
        System.out.println(" ***********************************************************");
        System.out.println(" update buku dengan No ISBN :  ");
        isbn = input.next();
        System.out.print(" Judul Buku : ");
        Book book = new Book();
        book.setTitle(input.next());
        System.out.print(" Pengarang : ");
        book.setAuthor(input.next());

        System.out.println("Yakin memperbaharui buku dengan No ISBN ? " + isbn + " Pengarang menjadi : " + book.getAuthor() + " dan Judul Buku menjadi :" + book.getTitle() + " Y/F");
        keyakinan = input.next();
        if (keyakinan.equals("Y")) {
            daftarBuku.put(isbn, book);
        } else if (keyakinan.equals("F")) {
            System.out.println("Buku dengan No " + isbn + " tidak jadi diperbaharui ");
        }

        System.out.println("____________________________________________________________________ ");
        for (Map.Entry<String, Book> entry : daftarBuku.entrySet()) {
            System.out.println(" ***********************************************************");
            System.out.println(entry.getKey());
            Book buku = entry.getValue();
            System.out.println(" Judul  Buku : " + buku.getTitle() + "  pegnarang " + buku.getAuthor());
        }
        System.out.println("____________________________________________________________________ ");
    }

}
