# Laporan Praktikum Minggu 2
Topik: Membuat Program Pengelolaan Stok Produk Menggunakan Konsep Class dan Object

## Identitas
- Nama  : Muhammad Pandu Dewanata Yaseh Hidayat
- NIM   : 240202841
- Kelas : 3IKRA

---

## Tujuan
Mahasiswa memahami konsep class dan object dalam pemrograman berorientasi objek (OOP), serta mampu mengimplementasikan prinsip enkapsulasi melalui pembuatan class Produk dengan atribut dan method yang sesuai.
Selain itu, mahasiswa dapat:
   - Membuat class pendukung seperti CreditBy untuk menampilkan identitas mahasiswa.
   - Melakukan instansiasi object dari class Produk dan menampilkan datanya di console.
   - Menggunakan method tambahan seperti tambahStok() dan kurangiStok() untuk mengelola stok produk dengan logika kondisi tertentu.
---

## Dasar Teori
   1. Pemrograman Berorientasi Objek (OOP)
      OOP adalah paradigma pemrograman yang berfokus pada objek, yaitu representasi nyata dari entitas dunia nyata yang memiliki atribut (data) dan perilaku (fungsi). Tujuan utamanya adalah membuat kode yang modular, mudah dipelihara, dan dapat digunakan kembali.

   2. Class dan Object
      Class adalah blueprint atau cetakan untuk membuat object. Di dalam class didefinisikan atribut (variabel) dan method (fungsi). Object adalah instansiasi dari class yang memiliki nilai nyata untuk atributnya.
      Contohnya: class Produk digunakan untuk membuat beberapa object produk seperti p1, p2, dan p3.

   3. Enkapsulasi (Encapsulation)
      Enkapsulasi adalah konsep membungkus data dan method dalam satu kesatuan (class), serta membatasi akses terhadap data menggunakan access modifier seperti private dan public. Hal ini bertujuan untuk melindungi data agar tidak diubah secara sembarangan.

   4. Method Getter dan Setter
      Method getter digunakan untuk mengambil nilai dari atribut yang bersifat privat, sedangkan setter digunakan untuk mengubah nilainya. Dalam class Produk, getter dan setter digunakan untuk mengakses atribut seperti kode, nama, harga, dan stok.

   5. Instansiasi dan Pemanggilan Method
      Proses membuat objek dari sebuah class disebut instansiasi. Setelah objek dibuat, method di dalam class dapat dipanggil untuk melakukan operasi tertentu, seperti tambahStok() dan kurangiStok() pada produk untuk mengelola jumlah stok.

---

## Langkah Praktikum
   1. Membuat struktur project
      - Membuat folder project dengan struktur package:
      ```
      com.upb.agripos
      ├── model
      │    └── Produk.java
      ├── util
      │    └── CreditBy.java
      └── MainProduk.java
      ```
      - Struktur ini digunakan agar program terorganisir sesuai standar Java.

   2. Membuat class Produk
      - Class Produk dibuat di dalam package model.
      - Berisi atribut: kode, nama, harga, dan stok dengan access modifier private.
      - Menambahkan constructor, getter-setter, serta method tambahan:
         - tambahStok(int jumlah) untuk menambah stok.
         - kurangiStok(int jumlah) untuk mengurangi stok dengan validasi jika stok tidak mencukupi.

   3. Membuat class CreditBy
      - Class ini diletakkan di package util.
      - Berisi method statis print(String nim, String nama) yang menampilkan identitas mahasiswa dengan format:
         ```
         credit by: <NIM> - <Nama>
         ```

   4. Membuat class MainProduk
      - Class utama untuk menjalankan program.
      - Melakukan instansiasi tiga produk pertanian:
         ```
         Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
         Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
         Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);
         ```
      - Menampilkan informasi setiap produk menggunakan System.out.println().
      - Menguji method tambahStok() dan kurangiStok() untuk memperbarui stok produk.
      - Menambahkan logika agar muncul pesan ketika stok tidak mencukupi atau habis.
      - Menampilkan identitas mahasiswa menggunakan:
         ```
         CreditBy.print("240202841", "Pandu Dewanata");
         ```

   5. Menjalankan program dan mengamati hasil output
      - Program dijalankan melalui MainProduk.java.
      - Hasilnya menampilkan daftar produk, perubahan stok, pesan stok habis/tidak cukup, dan identitas mahasiswa di bagian akhir console.

---

## Kode Program 
```java
//Produk
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    // Constructor
    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    // Method tambahan untuk stok
    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}

//CreditBy
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}

//MainProduk
package com.upb.agripos;

import com.upb.agripos.model.Produk;
import com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        // Instansiasi 3 produk pertanian
        Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
        Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
        Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);

        // Tampilkan informasi produk
        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        // Tambahkan sedikit simulasi stok
        System.out.println("\nMenambah stok Benih Padi IR64 sebanyak 20...");
        p1.tambahStok(20);
        System.out.println("Stok baru: " + p1.getStok());

        System.out.println("Mengurangi stok Pupuk Urea sebanyak 5...");
        p2.kurangiStok(1000);
        System.out.println("Stok baru: " + p2.getStok());

        System.out.println("Mengurangi stok Cangkul Baja:"+p3.getStok());
        p3.kurangiStok(12);
        System.out.println("Stok baru: " + p3.getStok());

        // Tampilkan identitas mahasiswa
        CreditBy.print("240202841", "Pandu Dewanata");
    }   
    
}
---
```
## Hasil Eksekusi
(
![Screenshot hasil](/praktikum/week2-class-object/screenshots/Class%20Object.png)
)
---

## Analisis
   1. Penjelasan Jalannya Kode Program
      - Program dimulai dari method main() pada class MainProduk.
      - Di dalamnya dibuat tiga objek dari class Produk, masing-masing menyimpan data produk pertanian (kode, nama, harga, dan stok).
      - Selanjutnya, program menampilkan data ketiga produk menggunakan method getKode(), getNama(), getHarga(), dan getStok().
      - Method tambahStok() dan kurangiStok() kemudian dipanggil untuk menambah dan mengurangi stok produk.
      - Jika stok yang dikurangi melebihi jumlah yang tersedia, program menampilkan pesan “Stok tidak mencukupi”.
      - Setelah semua proses selesai, program menampilkan identitas mahasiswa menggunakan method print() dari class CreditBy.

   2. Perbedaan Pendekatan dengan Minggu Sebelumnya
      Pada minggu sebelumnya, pendekatan yang digunakan masih bersifat prosedural, yaitu semua logika program ditulis dalam satu file dan tidak menggunakan konsep class dan object.
      Sedangkan pada minggu ini sudah menggunakan pendekatan OOP (Object-Oriented Programming), di mana kode dibagi menjadi beberapa class dengan tanggung jawab masing-masing:
      - Produk berfungsi sebagai blueprint data dan perilaku produk.
      - CreditBy menangani informasi identitas mahasiswa.
      - MainProduk berperan sebagai class utama yang menjalankan program.
      Pendekatan ini membuat kode lebih terstruktur, modular, dan mudah dikembangkan.

   3. Kendala yang Dihadapi dan Cara Mengatasinya
      - Kendala 1: Error saat memanggil class dari package berbeda karena struktur folder belum sesuai dengan deklarasi package.
        Solusi: Menyesuaikan struktur folder sesuai nama package (misalnya com/upb/agripos/model untuk class Produk).

      - Kendala 2: Program tidak menampilkan output stok yang benar karena variabel stok tidak diperbarui setelah pemanggilan method.
        Solusi: Menambahkan System.out.println() setelah setiap pemanggilan method untuk memastikan nilai stok terbaru ditampilkan.

      - Kendala 3: Lupa menambahkan parameter yang sesuai pada pemanggilan CreditBy.print().
        Solusi: Mengecek ulang definisi method di class CreditBy dan memastikan argumen yang dikirimkan sesuai dengan tipe datanya (String nim, String nama).
---

## Kesimpulan
   Dari praktikum minggu ini dapat disimpulkan bahwa saya telah memahami dan mampu mengimplementasikan konsep dasar pemrograman berorientasi objek (OOP), khususnya pada penerapan class, object, dan enkapsulasi.
   Class Produk berhasil dibuat dengan atribut dan method yang sesuai, termasuk method tambahan untuk mengelola stok seperti tambahStok() dan kurangiStok().
   Selain itu, saya juga mampu memisahkan tanggung jawab program ke dalam beberapa class, seperti CreditBy untuk menampilkan identitas mahasiswa dan MainProduk sebagai class utama yang menjalankan logika program.

   Praktikum ini menunjukkan bahwa penggunaan pendekatan OOP membuat program lebih terstruktur, mudah dipahami, serta mudah dikembangkan dibanding pendekatan prosedural.
   Melalui latihan ini, saya juga belajar menangani kondisi logika seperti stok habis atau tidak mencukupi dengan menggunakan pernyataan if-else.

---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?
   Jawaban:
   Atribut sebaiknya dideklarasikan sebagai private agar data dalam class tidak dapat diakses atau diubah secara langsung dari luar class. Hal ini menjaga keamanan data dan mencegah perubahan yang tidak diinginkan, sesuai dengan prinsip enkapsulasi dalam OOP.

2. Apa fungsi getter dan setter dalam enkapsulasi?
   Jawaban:
   Getter berfungsi untuk mengambil nilai dari atribut private, sedangkan setter berfungsi untuk mengubah nilainya dengan cara yang terkontrol. Dengan getter dan setter, data tetap terlindungi namun tetap bisa digunakan oleh class lain dengan aman.

3. Bagaimana cara class Produk mendukung pengembangan aplikasi POS yang lebih kompleks?
   Jawaban:
   Class Produk dapat menjadi fondasi dalam sistem POS (Point of Sale) karena menyimpan data penting seperti nama produk, harga, dan stok. Dengan menambahkan method seperti penghitungan total, pengurangan stok otomatis, atau integrasi dengan class lain (misalnya Transaksi atau Pelanggan), aplikasi POS dapat dikembangkan menjadi sistem yang lebih kompleks dan efisien.
