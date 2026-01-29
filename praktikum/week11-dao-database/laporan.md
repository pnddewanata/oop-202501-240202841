# Laporan Praktikum Minggu 11

Topik: Data Access Object (DAO) dan CRUD Database dengan JDBC

## Identitas

* Nama  : Muhammad Pandu Dewanata Yaseh Hidayat
* NIM   : 240202841
* Kelas : 3IKRA

---

## Tujuan

Tujuan dari praktikum minggu ke-11 ini adalah agar mahasiswa memahami konsep Data Access Object (DAO) dalam pengembangan aplikasi berbasis OOP, mampu menghubungkan aplikasi Java dengan database menggunakan JDBC, serta dapat mengimplementasikan operasi CRUD (Create, Read, Update, Delete) secara lengkap dan terstruktur.

---

## Dasar Teori

1. Data Access Object (DAO) merupakan pola desain yang memisahkan logika akses data dari logika bisnis aplikasi.
2. JDBC (Java Database Connectivity) digunakan sebagai penghubung antara aplikasi Java dan database relasional.
3. Operasi CRUD meliputi Create, Read, Update, dan Delete sebagai dasar pengelolaan data.
4. PreparedStatement digunakan untuk meningkatkan keamanan dan efisiensi akses database.
5. Pemisahan lapisan data dan aplikasi membuat kode lebih mudah dipelihara dan dikembangkan.

---

## Langkah Praktikum

1. Menyiapkan database PostgreSQL dengan nama database agripos dan tabel products sesuai spesifikasi.
2. Membuat class model Product untuk merepresentasikan data produk.
3. Membuat interface ProductDAO yang berisi method CRUD.
4. Mengimplementasikan ProductDAOImpl menggunakan JDBC dan PreparedStatement.
5. Mengintegrasikan DAO dengan class MainDAOTest sebagai class pengujian aplikasi.
6. Menjalankan program untuk menguji operasi insert, update, read, dan delete.
7. Mendokumentasikan hasil eksekusi CRUD dan melakukan commit dengan message: week11-dao-database: implementasi dao dan crud jdbc.

---

## Kode Program

Contoh penggunaan DAO pada class utama:

```java
package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;

public class MainDAOTest {
    public static void main(String[] args) throws Exception {

        System.out.println("Database Conection...");
        Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/agripos",
            "postgres",
            "123456"
        );
        System.out.println("Conection Success...");


        ProductDAO dao = new ProductDAOImpl(conn);

        // INSERT product
        System.out.println("Inserting Product...");
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 10);
        dao.insert(p1);
        System.out.println("Produk berhasil ditambahkan");


        // UPDATE product
        System.out.println("Updating Product...");
        Product pUpdate = new Product("P01", "Pupuk Organik Premium", 30000, 8);
        dao.update(pUpdate);
        System.out.println("Produk berhasil diperbarui...");


        // SELECT PRODUCT BY CODE
        System.out.println("Finding Product by Code...");
        Product p = dao.findByCode("P01");
        if (p != null) {
            System.out.println("Data produk:");
            System.out.println("Kode  : " + p.getCode());
            System.out.println("Nama  : " + p.getName());
            System.out.println("Harga : " + p.getPrice());
            System.out.println("Stok  : " + p.getStock());
        } else {
            System.out.println("Produk Not Found");
        }
 

        // DELETE PRODUCT BY CODE
        System.out.println("Deleting Product...");
        dao.delete("P01");
        System.out.println("Produk berhasil dihapus");


        conn.close();
        // CONECTION CLOSED
        System.out.println("Conection Closed...");
        System.out.println("credit by Muhammad Pandu Dewanata Yaseh Hidayat - 240202841");
    }
}
```

---

## Hasil Eksekusi

Program berhasil menjalankan seluruh operasi CRUD. Data produk dapat ditambahkan, ditampilkan, diperbarui, dan dihapus dari database PostgreSQL sesuai perintah yang dijalankan.

![Screenshot hasil](screenshots/week11.jpeg)

---

## Analisis

Pada praktikum ini, pola DAO digunakan untuk memisahkan proses akses database dari logika utama aplikasi. Class Product berperan sebagai model data, sedangkan ProductDAOImpl bertanggung jawab penuh terhadap interaksi dengan database menggunakan JDBC.

Pendekatan ini berbeda dengan praktikum sebelumnya yang masih berfokus pada struktur aplikasi dan design pattern, karena pada minggu ini aplikasi sudah terhubung langsung dengan database. Kendala yang dihadapi adalah kesalahan konfigurasi koneksi database dan query SQL, namun dapat diatasi dengan memastikan URL koneksi, username, password, serta struktur tabel sesuai dengan spesifikasi.

---

## Kesimpulan

Berdasarkan praktikum minggu ke-11, dapat disimpulkan bahwa penerapan DAO dan JDBC mampu membuat proses pengelolaan data menjadi lebih terstruktur, aman, dan mudah dikembangkan. Operasi CRUD yang diimplementasikan berjalan dengan baik dan sesuai dengan prinsip OOP.

---

## Quiz

1. Apa tujuan utama penggunaan Data Access Object (DAO)?
   **Jawaban:** Untuk memisahkan logika akses data dari logika bisnis aplikasi agar kode lebih terstruktur dan mudah dipelihara.

2. Mengapa PreparedStatement lebih disarankan dibanding Statement?
   **Jawaban:** Karena lebih aman dari SQL Injection dan lebih efisien dalam eksekusi query berulang.

3. Apa fungsi JDBC dalam aplikasi Java?
   **Jawaban:** Sebagai penghubung antara aplikasi Java dan database relasional untuk melakukan operasi pengolahan data.
