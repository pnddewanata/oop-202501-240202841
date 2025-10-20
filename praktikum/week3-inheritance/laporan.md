# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: Penerapan Konsep Inheritance dalam Sistem Kate+gori Produk Pertanian

## Identitas
- Nama  : Muhammad Pandu Dewanata Yaseh Hidayat
- NIM   : 240202841
- Kelas : 3IKRA
---

## Tujuan
Tujuan Pembelajaran
   1. Memahami konsep inheritance (pewarisan class) dalam pemrograman berorientasi objek (OOP).
   2. Menerapkan pembuatan superclass dan subclass untuk kategori produk pertanian.
   3. Menunjukkan hierarki class melalui implementasi kode yang saling berhubungan.
   4. Menggunakan keyword super untuk memanggil konstruktor dan method dari parent class.
   5. Menjelaskan perbedaan penggunaan inheritance dibandingkan dengan penggunaan class tunggal.
---

## Dasar Teori
   1. Inheritance adalah konsep dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain, sehingga kode dapat digunakan kembali (reusability).
   2. Superclass (class induk) berisi atribut dan perilaku umum yang dapat diwariskan ke class lain.
   3. Subclass (class turunan) mewarisi semua atribut dan method dari superclass, serta dapat menambahkan atribut atau perilaku khusus.
   4. Keyword super digunakan untuk memanggil konstruktor atau method dari superclass di dalam subclass.
   5. Penerapan inheritance membuat program lebih terstruktur, efisien, dan mudah dikembangkan karena menghindari duplikasi kode.
---

## Langkah Praktikum
   1. Membuat struktur package proyek
      - Buat folder utama dengan struktur:
        com.upb.agripos.model
        com.upb.agripos.util
      - Folder model digunakan untuk menyimpan class produk dan turunannya, sedangkan util untuk class tambahan seperti CreditBy.

   2. Membuat class induk Produk
      - Class ini berisi atribut umum seperti kode, nama, harga, dan stok.
      - Tambahkan konstruktor, getter dan setter, serta method umum (misalnya tampilkanInfo()).

   3. Membuat class turunan
      - Buat tiga class turunan dari Produk, yaitu:
         - Benih (dengan atribut tambahan varietas)
         - Pupuk (dengan atribut tambahan jenis)
         - AlatPertanian (dengan atribut tambahan material)
      - Masing-masing class menggunakan keyword extends Produk.
      - Override method tampilkanInfo() untuk menampilkan data lengkap tiap produk.
   
   4. Membuat class CreditBy
      - Class ini berfungsi untuk menampilkan identitas pembuat program seperti NIM dan nama.

   5. Membuat class utama MainInheritance
      - Buat object dari masing-masing class (Benih, Pupuk, AlatPertanian).
      - Panggil method tampilkanInfo() untuk menampilkan data produk.
      - Panggil CreditBy.print() untuk menampilkan identitas pembuat.

   6. Menjalankan program
      - Jalankan file MainInheritance.java.
      - Hasilnya akan menampilkan data setiap produk pertanian beserta identitas pembuat program di terminal.
---

## Kode Program
```java
//Alat Pertanian
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Material: " + material);
    }
}
```
```java
//Benih
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Varietas: " + varietas);
    }
}
```
```java
//Produk
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tampilkanInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
    }
}
```
```java
//Pupuk
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Pupuk: " + jenis);
    }
}
```
```java
//Mainlnheritance
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih benih = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk pupuk = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian alat = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("=== Data Produk Pertanian ===");
        System.out.println("\n-- Benih --");
        benih.tampilkanInfo();

        System.out.println("\n-- Pupuk --");
        pupuk.tampilkanInfo();

        System.out.println("\n-- Alat Pertanian --");
        alat.tampilkanInfo();

        CreditBy.print("240202841", "Pandu Dewanata Yaseh Hidayat");
    }
}
```
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](/praktikum/week3-inheritance/screenshots/Output%20Week3.png)
)
---

## Analisis
1. Kode berjalan dengan benar menampilkan semua produk dari subclass masing-masing.
2. Pendekatan inheritance membuat kode lebih terstruktur dibanding minggu sebelumnya yang hanya menggunakan class tunggal Produk.
3. Kendala awal muncul saat memanggil constructor AlatPertanian karena jumlah parameter tidak sesuai, diperbaiki dengan memisahkan material dan keterangan menggunakan koma. 
---

## Kesimpulan
   Kesimpulan dari praktikum minggu ini adalah bahwa konsep inheritance (pewarisan) dalam pemrograman berorientasi objek memungkinkan satu class untuk mewarisi atribut dan method dari class lain, sehingga kode menjadi lebih efisien dan mudah dikembangkan. Melalui praktikum ini, class Produk berperan sebagai class induk yang menampung atribut umum, sedangkan class Benih, Pupuk, dan AlatPertanian menjadi class turunan yang memiliki atribut dan perilaku khusus masing-masing. Dengan adanya pewarisan, setiap class turunan dapat menambahkan atau mengubah fungsi tertentu tanpa mengubah struktur dasar dari class induk. Secara keseluruhan, praktikum ini memberikan pemahaman yang lebih baik tentang bagaimana inheritance dapat meningkatkan keteraturan, reusabilitas, dan efisiensi dalam pengembangan program berbasis objek.
---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
   Jawaban:
   Keuntungan menggunakan inheritance adalah kode menjadi lebih reusable, terstruktur, dan mudah dikembangkan. Dengan pewarisan, kita tidak perlu menulis ulang atribut atau method yang sama di setiap class, karena class turunan dapat mewarisi dari class induk.

2. Bagaimana cara subclass memanggil konstruktor superclass?
   Jawaban:
   Subclass dapat memanggil konstruktor dari superclass dengan menggunakan keyword super di dalam konstruktor subclass. Keyword ini berfungsi untuk mengakses konstruktor atau atribut milik class induk.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.
   Jawaban:
   Contoh lain yang bisa dijadikan subclass antara lain Bibit Tanaman, Herbisida, dan Traktor Mini, karena masing-masing masih termasuk dalam kategori produk pertanian namun memiliki karakteristik dan atribut khusus sendiri.
 
