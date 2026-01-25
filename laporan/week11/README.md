# Laporan Praktikum Minggu 14 
 
Topik: Integrasi Aplikasi Agri-POS Lengkap 
 
## Identitas 
- Nama  : Muhammad Pandu Dewanata Yaseh Hidayat 
- NIM   : 240202841 
- Kelas : 3IKRA 
 
## Tujuan 
(Tuliskan maksud pelaksanaan praktikum minggu ini.  
Contoh: *Mengintegrasikan seluruh materi Minggu 1–13 ke dalam satu aplikasi yang utuh.*) 
 
## Dasar Teori 
(Tuliskan rangkuman teori singkat (3–5 butir) yang menjadi landasan praktikum.  
Contoh:  
1. OOP (Object-Oriented Programming) memungkinkan aplikasi dibangun secara modular, dapat digunakan kembali, dan terstruktur. 
2. DAO (Data Access Object) memisahkan logika akses data dari logika bisnis aplikasi. 
3. Arsitektur MVC memisahkan Tampilan, Pengendali, dan Model agar aplikasi mudah dikembangkan.) 
 
## Langkah Percobaan 
(5. Implementasi Fitur 
A. Manajemen Produk 
Menambahkan produk ke basis data melalui ProductService → ProductDAO. 
Menghapus produk dari basis data melalui tombol GUI. 
Validasi masukan dilakukan dengan pengecualian khusus (mis. kode kosong, harga tidak valid). 
 
B. Keranjang Belanja 
Pengguna dapat menambahkan produk ke keranjang. 
Total belanja dihitung berdasarkan isi keranjang. 
Keranjang diproses melalui CartService. 
C. Pola dan Pengujian 
Pola Desain: 
Singleton digunakan pada koneksi basis data (JDBC Connection). 
Pengujian Unit: 
CartServiceTest menguji perhitungan total belanja keranjang.) 
 
## Implementasi Kode 
\`\`\`java 
package com.upb.agripos; 
 
import java.sql.Connection; 
import java.sql.DriverManager; 
 
import com.upb.agripos.controller.PosController; 
import com.upb.agripos.dao.ProductDAO; 
import com.upb.agripos.dao.ProductDAOImpl; 
import com.upb.agripos.service.CartService; 
import com.upb.agripos.service.ProductService; 
import com.upb.agripos.view.PosView; 
 
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
 
public class AppJavaFX extends Application { 
 
    @Override 
    public void start(Stage stage) { 
        try { 
            // Cetak identitas ke console (sesuai Minggu 1) 
            System.out.println("Hello World, I am Muhammad Pandu Dewanata Yaseh Hidayat-240202841"); 
 
            // 1. Setup Database Connection (Minggu 11) 
            Connection conn = DriverManager.getConnection( 
                "jdbc:postgresql://localhost:5432/agripos",  
                "postgres",  
                "123456" 
            ); 
 
            // 2. Setup MVC + Service + DAO Architecture (Minggu 6, 11, 12, 13) 
            ProductDAO productDAO = new ProductDAOImpl(conn); 
            ProductService productService = new ProductService(productDAO); 
            CartService cartService = new CartService(productService); 
 
            // 3. Create View (Minggu 12-13) 
            PosView view = new PosView(); 
 
            // 4. Create Controller (Minggu 12-13) 
            new PosController(productService, cartService, view); 
 
            // 5. Display Scene 
            Scene scene = new Scene(view, 1000, 800); 
            stage.setTitle("Agri-POS Minggu 14 - Muhammad Pandu Dewanata Yaseh Hidayat (240202841)"); 
            stage.setScene(scene); 
            stage.show(); 
 
        } catch (Exception e) { 
            System.err.println("Error starting application: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
    } 
 
    public static void main(String[] args) { 
        launch(args); 
    } 
} 
\`\`\` 
 
## Hasil Pelaksanaan 
(Aplikasi Agri-POS berhasil dijalankan dengan semua fitur terintegrasi: manajemen produk, keranjang belanja, dan checkout.) 
![Cuplikan layar hasil aplikasi](screenshots/main%20program.png) 
![Cuplikan layar hasil testing](screenshots/test.png) 
 
## Analisis 
( 
- Menambahkan produk ke basis data melalui ProductService → ProductDAO.  
- Kendala: Kesalahan sinkronisasi TableView setelah menghapus data 
- Solusi: Memanggil ulang metode muatData() setelah operasi hapus. 
) 
 
## Kesimpulan 
( *Praktikum Minggu 14 berhasil mengintegrasikan seluruh materi dari Minggu 1 hingga Minggu 13 ke dalam satu aplikasi Agri-POS yang utuh. Aplikasi telah menerapkan prinsip OOP, arsitektur MVC, DAO, Collections, penanganan pengecualian, pola desain, pengujian unit, serta GUI JavaFX secara konsisten dan terstruktur. Aplikasi ini siap dikembangkan lebih lanjut sebagai dasar tugas akhir atau UAS.*) 
 
## Penilaian 
Fokus  Minggu 14: 
- Integrasi end-to-end (OOP + DB + GUI) berjalan. 
- Konsistensi UML (Minggu 6) dengan implementasi. 
- Kerapian arsitektur (SOLID/DIP) dan pemisahan lapisan. 
- Ketepatan penggunaan Collections, pengecualian, pola, dan pengujian. 
 
 
## 📊 Ringkasan Pencapaian 
 
### ✅ Minggu 10: Design Pattern 
- Implementasi Singleton Pattern untuk koneksi database 
- Penerapan arsitektur MVC (Model-View-Controller) 
- Unit testing dengan JUnit untuk validasi kode 
 
- Koneksi database PostgreSQL dengan JDBC 
- Implementasi Data Access Object (DAO) pattern 
- Operasi CRUD (Create, Read, Update, Delete) lengkap 
 
### ✅ Minggu 12: GUI Dasar JavaFX 
- Pembuatan antarmuka grafis dengan JavaFX 
- Event-driven programming untuk interaksi pengguna 
- Integrasi GUI dengan service layer 
 
### ✅ Minggu 13: GUI Lanjutan 
- Penggunaan TableView untuk menampilkan data tabular 
- ObservableList untuk sinkronisasi data real-time 
- Lambda expressions untuk event handling 
 
### ✅ Minggu 14: Integrasi Lengkap 
- Aplikasi Agri-POS full-featured 
- Manajemen produk dengan database 
- Sistem keranjang belanja dengan checkout 
- Testing dan validasi lengkap 
 
## 🎯 Kompetensi yang Dikuasai 
1. **Pemrograman Berorientasi Objek**: Class, Object, Inheritance, Polymorphism 
2. **Design Patterns**: Singleton, MVC, DAO 
3. **Database Programming**: JDBC, PostgreSQL, CRUD Operations 
4. **GUI Development**: JavaFX, Event Handling, TableView 
5. **Software Testing**: JUnit, Unit Testing, Test Coverage 
6. **Version Control**: Git, GitHub, Collaboration 
7. **Software Architecture**: Layered Architecture, SOLID Principles 
 
## 📞 Kontak 
- **Nama**: Muhammad Pandu Dewanata Yaseh Hidayat 
- **NIM**: 240202841 
- **Kelas**: 3IKRA 
- **Email**: [pnddewanata@github.com](mailto:pnddewanata@github.com) 
- **GitHub**: [github.com/pnddewanata](https://github.com/pnddewanata) 
- **Repository**: [https://github.com/pnddewanata/oop-202501-240202841](https://github.com/pnddewanata/oop-202501-240202841) 
