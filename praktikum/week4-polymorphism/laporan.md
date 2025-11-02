# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Muhammad Pandu Dewanata Yaseh Hidayat
- NIM   : 240202841
- Kelas : 3IKRA

---

## Tujuan
Tujuan saya dalam praktikum ini adalah untuk memahami dan menerapkan konsep pewarisan (inheritance) serta polymorphism pada pemrograman berorientasi objek. Melalui tugas ini, saya belajar membuat kelas induk Produk dan beberapa kelas turunan seperti Benih, Pupuk, dan AlatPertanian yang memiliki atribut dan metode khusus masing-masing. Selain itu, saya juga berlatih menampilkan data dari setiap objek untuk melihat bagaimana polymorphism bekerja dalam program.

---

## Dasar Teori
1. Inheritance memungkinkan suatu class mewarisi atribut dan method dari class lain.
2. Polymorphism membuat objek dari class turunan dapat diperlakukan seperti objek class induk.
3. Method overriding digunakan untuk mengganti perilaku method dari class induk di class turunan.
4. Encapsulation melindungi data agar hanya bisa diakses melalui method tertentu.
5. Instansiasi objek dilakukan untuk membuat objek nyata dari suatu class agar bisa digunakan dalam program.

---

## Langkah Praktikum
1. Membuat struktur folder dan file Java sesuai package (model dan util).
2. Membuat class induk Produk serta subclass Benih, Pupuk, dan AlatPertanian.
3. Menambahkan atribut dan method khusus di setiap subclass.
4. Membuat class MainPolymorphism untuk menginstansiasi objek dan menampilkan data.
5. Menjalankan program dan memastikan output sesuai.
6. Melakukan commit dengan pesan seperti: "Menambahkan class turunan dan implementasi polymorphism".

---

## Kode Program
```java
// Alat Pertanian
package main.java.com.upb.agripos.model;

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

    @Override
    public void getInfo() {
        System.out.println("--- Detail ALAT PERTANIAN ---");
        System.out.println(" Kode: " + getKode());
        System.out.println(" Nama: " + getNama());
        System.out.println(" Material Utama: " + material);
        System.out.println(" Harga (Rp): " + getHarga());
        System.out.println(" Stok: " + getStok() + " unit.");
    }
}
```
```java
// Benih
package main.java.com.upb.agripos.model;

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

     @Override
    public void getInfo() {
        System.out.println("--- Detail BENIH ---");
        System.out.println(" Kode: " + getKode());
        System.out.println(" Nama: " + getNama());
        System.out.println(" Varietas: " + varietas);
        // Menggunakan getHarga() dan getStok() dari Produk untuk keamanan
        System.out.println(" Harga (Rp): " + getHarga()); 
        System.out.println(" Stok: " + getStok() + " bungkus.");
    }
}
```
```java
// Obat Hama
package main.java.com.upb.agripos.model;

public class ObatHama extends Produk {
    private String bentuk; 

    
    public ObatHama(String kode, String nama, double harga, int stok, String bentuk) {
        super(kode, nama, harga, stok);
        this.bentuk = bentuk;
    }

    public String getBentuk() { return bentuk; }
    public void setBentuk(String bentuk) { this.bentuk = bentuk; }

    
    @Override
    public void getInfo() {
        System.out.println("--- Detail OBAT HAMA ---");
        System.out.println(" Kode: " + getKode());
        System.out.println(" Nama: " + getNama());
        System.out.println(" Bentuk Fisik: " + bentuk);
        System.out.println(" Harga (Rp): " + getHarga()); 
        System.out.println(" Stok: " + getStok() + " botol/kemasan.");
    }
}
```
```java
// Produk
package main.java.com.upb.agripos.model;

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

     public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
            System.out.println("Stok " + nama + " bertambah " + jumlah + " (int). Stok baru: " + this.stok);
        } else {
            // Mengubah pesan agar lebih sesuai konteks
            System.out.println("Gagal: Jumlah stok yang ditambahkan harus lebih dari nol!");
        }
    }

    public void tambahStok(double jumlah) {
        int jumlahInt = (int) Math.round(jumlah);
        if (jumlahInt > 0) {
            this.stok += jumlahInt;
            System.out.println("Stok " + nama + " bertambah " + jumlah + " (double/dibulatkan jadi " + jumlahInt + "). Stok baru: " + this.stok);
        } else {
            System.out.println("Gagal: Jumlah stok yang ditambahkan (setelah dibulatkan) harus lebih dari nol!");
        }
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
            System.out.println("Stok " + nama + " berkurang " + jumlah + ". Stok baru: " + this.stok);
        } else {
            System.out.println("Stok tidak mencukupi untuk " + nama + "! Tersedia: " + this.stok);
        }
    }

    public void tampilkanInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
    }

     public void getInfo() {
        System.out.println("--- Detail Produk Umum ---");
        System.out.println(" Kode: " + kode);
        System.out.println(" Nama: " + nama);
        System.out.println(" Harga (Rp): " + harga);
        System.out.println(" Stok Tersedia: " + stok);
    }

}
```
```java
// Pupuk
package main.java.com.upb.agripos.model;

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

     @Override
    public void getInfo() {
        System.out.println("--- Detail PUPUK ---");
        System.out.println(" Kode: " + getKode());
        System.out.println(" Nama: " + getNama());
        System.out.println(" Jenis Pupuk: " + jenis);
        System.out.println(" Harga (Rp): " + getHarga()); 
        System.out.println(" Stok: " + getStok() + " karung.");
    }
}
```
---
## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
- Cara kerja kode: Program membuat objek dari class turunan (Benih, Pupuk, AlatPertanian) yang mewarisi atribut dan method dari class Produk, lalu menampilkan data melalui metode tampilkanInfo() dan deskripsi().

- Perbedaan minggu ini: Fokus minggu ini pada konsep inheritance dan polymorphism, sedangkan minggu sebelumnya hanya membuat class dasar dan enkapsulasi.

- Kendala dan solusi: Kendala utama ada pada struktur package dan kesalahan import. Solusinya dengan memastikan deklarasi package sesuai dengan letak file dan memperbaiki sintaks anotasi @Override.
---

## Kesimpulan
Dengan menerapkan konsep inheritance dan polymorphism, saya dapat membuat program yang lebih efisien, terstruktur, serta mudah dikembangkan karena setiap subclass bisa menambah atau memodifikasi fitur tanpa mengubah class induk.

---

## Quiz
1. Apa perbedaan overloading dan overriding?
Jawaban: Overloading terjadi saat dua atau lebih method memiliki nama yang sama tetapi berbeda parameter dalam satu class, sedangkan overriding terjadi ketika subclass menulis ulang method dari superclass dengan isi (implementasi) yang berbeda.

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?
Jawaban: Java menentukan method yang dipanggil berdasarkan tipe objek sebenarnya saat program dijalankan (runtime), bukan berdasarkan tipe referensinya.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.
Jawaban: Misalnya pada sistem POS restoran — class Menu memiliki subclass seperti Makanan, Minuman, dan Dessert yang masing-masing mengimplementasikan method tampilkanInfo() dengan cara berbeda sesuai jenisnya.
