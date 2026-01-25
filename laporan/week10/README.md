# Laporan Praktikum Minggu 10 
 
Topik: Design Pattern (Singleton, MVC) dan Unit Testing menggunakan JUnit 
 
## Identitas 
- Nama  : Muhammad Pandu Dewanata Yaseh Hidayat 
- NIM   : 240202841 
- Kelas : 3IKRA 
 
## Tujuan 
(Tuliskan maksud pelaksanaan praktikum minggu ini.  
 *Melalui praktikum minggu kesepuluh ini, diharapkan peserta dapat menguasai prinsip pola desain dalam rekayasa perangkat lunak, terutama Pola Singleton dan Model–View–Controller (MVC), serta memiliki kemampuan untuk mengimplementasikan pengujian unit memanfaatkan JUnit guna menjamin mutu dan keakuratan kode program.*) 
 
## Dasar Teori 
(Tuliskan rangkuman teori singkat (3–5 butir) yang menjadi landasan praktikum.  
Contoh:  
1. Pola Desain merupakan solusi umum yang sudah teruji untuk menangani masalah desain perangkat lunak.  
2. Pola Singleton menjamin suatu kelas hanya mempunyai satu instansi selama aplikasi dijalankan.  
3. MVC (Model–View–Controller) memisahkan logika data, antarmuka, dan kontrol agar struktur kode lebih rapi.  
4. Pengujian unit dipakai untuk menguji bagian terkecil dari program secara terisolasi.  
5. JUnit merupakan kerangka kerja pengujian yang lazim digunakan dalam pemrograman Java.) 
 
## Langkah Percobaan 
(Tuliskan Tahapan-tahapan dalam praktikum, contoh: 
1. Membangun kelas `DatabaseConnection` dengan menerapkan Pola Singleton.  
2. Menerapkan arsitektur MVC sederhana pada fitur Produk.  
3. Membuat kelas `Product`, `ConsoleView`, dan `ProductController`.  
4. Menyusun pengujian unit memakai JUnit untuk menguji kelas `Product`.  
5. Menjalankan program beserta pengujian unit menggunakan Maven.) 
 
## Implementasi Kode 
\`\`\`java 
//Singleton – DatabaseConnection 
package com.upb.agripos.config; 
 
public class DatabaseConnection { 
    private static DatabaseConnection instansi; 
 
    private DatabaseConnection() {} 
 
    public static DatabaseConnection dapatkanInstansi() { 
        if (instansi == null) { 
            instansi = new DatabaseConnection(); 
        } 
        return instansi; 
    } 
} 
\`\`\` 
 
## Hasil Pelaksanaan 
(Kode program berhasil dijalankan dan pengujian unit menggunakan JUnit berhasil dijalankan tanpa kendala.) 
 
## Analisis 
( 
Program mengimplementasikan Pola Singleton untuk memastikan koneksi basis data hanya dibuat satu kali. 
Pola MVC memisahkan tanggung jawab antara data (Model), antarmuka (View), dan pengendali (Controller) sehingga kode lebih tertata dan mudah dipelihara. 
Pengujian unit dengan JUnit membantu memverifikasi bahwa metode pada kelas Product berfungsi sesuai ekspektasi. 
Kendala yang ditemui adalah kesalahan konfigurasi paket dan Maven, yang diatasi dengan menyesuaikan struktur folder dan deklarasi paket. 
) 
 
## Kesimpulan 
(*Dengan mengaplikasikan Pola Singleton, MVC, dan pengujian unit menggunakan JUnit, aplikasi menjadi lebih terorganisir, mudah dikembangkan, serta memiliki kualitas kode yang lebih baik dan lebih mudah diuji.*) 
 
## Kuis 
( 
1. Mengapa konstruktor pada Singleton harus bersifat privat?  
   **Jawaban: Agar objek tidak dapat dibuat langsung dari luar kelas dan hanya dapat diakses melalui metode getInstance().**  
 
2. Apa keuntungan penerapan MVC? 
   **Jawaban: Agar kode lebih terstruktur, mudah dipelihara, dan mempercepat pengembangan serta pengujian.** 
 
3. Apa peran pengujian unit dalam pengembangan perangkat lunak? 
   **Jawaban: Untuk memastikan setiap komponen kecil dari program berjalan dengan tepat dan menemukan bug sejak awal.**  
   ) 
