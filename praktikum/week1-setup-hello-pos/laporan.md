# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: “Eksplorasi Paradigma Pemrograman Java: Dari Prosedural ke OOP hingga Fungsional”0

## Identitas
- Nama  : Nama Muhammad Pandu Dewanata Yaseh Hidayat
- NIM   : 240202841
- Kelas : 3IKRA

---

## Tujuan
1. Mahasiswa memahami perbedaan paradigma pemrograman prosedural, berorientasi objek, dan fungsional dalam Java.
2. Mahasiswa dapat mengimplementasikan program sederhana menggunakan pendekatan prosedural dengan method.
3. Mahasiswa mampu membuat program berbasis OOP dengan memanfaatkan class, object, atribut, dan method.
4. Mahasiswa mengenal konsep functional programming di Java dengan memanfaatkan functional interface   seperti BiConsumer.
5. Mahasiswa mampu membandingkan hasil keluaran dari ketiga pendekatan untuk memahami kelebihan dan kekurangan masing-masing paradigma.

---

## Dasar Teori
1. Pemrograman Prosedural
Pemrograman prosedural adalah paradigma pemrograman yang menyusun program ke dalam prosedur atau fungsi. Pendekatan ini menekankan urutan langkah (step by step) dalam menyelesaikan masalah, sehingga mudah dipahami namun sulit dikelola untuk program yang kompleks.

2. Pemrograman Berorientasi Objek (Object-Oriented Programming / OOP)
OOP adalah paradigma yang menyusun program ke dalam objek yang memiliki atribut (data/variabel) dan method (fungsi). Konsep inti OOP meliputi enkapsulasi, inheritance, polimorfisme, dan abstraksi. Dengan OOP, program menjadi lebih modular, mudah dikembangkan, dan lebih dekat dengan representasi dunia nyata.

3. Pemrograman Fungsional
Pemrograman fungsional menekankan pada penggunaan fungsi sebagai first-class citizen dan menghindari perubahan data secara langsung (immutability). Dalam Java, pendekatan ini dapat dilakukan menggunakan lambda expression dan functional interface seperti Consumer, Supplier, atau BiConsumer.

4. Perbandingan Paradigma
   - Prosedural → fokus pada urutan instruksi.
   - OOP → fokus pada objek yang merepresentasikan data dan perilaku.
   - Fungsional → fokus pada fungsi dan ekspresi untuk mengolah data.
     Masing-masing paradigma memiliki kelebihan dan cocok digunakan sesuai kebutuhan program.

---

## Langkah Praktikum
1. Membuat Project Baru
   - Membuat project Java pada editor (misalnya VS Code atau IDE lain).
   - Menyusun struktur folder sesuai ketentuan praktikum.

2. Implementasi Pemrograman Prosedural
   - Membuat file HelloProcedural.java.
   - Mendeklarasikan variabel NAMA dan NIM.
   - Membuat method PANGGIL (String NAMA, String NIM) untuk menampilkan data mahasiswa.
   - Memanggil method tersebut dari dalam main().

3. Implementasi Pemrograman Berorientasi Objek (OOP)
   - Membuat file HelloOOP.java.
   - Mendefinisikan class MAHASISWA dengan atribut NAMA dan NIM.
   - Membuat constructor untuk inisialisasi atribut.
   - Membuat method PANGGIL() untuk menampilkan data mahasiswa.
   - Membuat objek dari class MAHASISWA pada method main() lalu memanggil method PANGGIL().

4. Implementasi Pemrograman Fungsional
   - Membuat file HelloFunctional.java.
   - Mengimpor package java.util.function.BiConsumer.
   - Mendeklarasikan variabel BiConsumer<String, Integer> untuk menerima dua parameter (nama dan NIM).
   - Menggunakan lambda expression untuk menampilkan data mahasiswa.
   - Memanggil method accept() pada objek BiConsumer dengan parameter nama dan NIM.

5. Menjalankan Program
   - Menjalankan masing-masing file (HelloProcedural, HelloOOP, dan HelloFunctional) menggunakan terminal atau fitur Run di IDE.
   - Mengamati hasil keluaran dari setiap paradigma pemrograman.

6. Membandingkan Hasil
   - Mencatat perbedaan pendekatan antara prosedural, OOP, dan fungsional.
   - Menyimpulkan kelebihan dan kekurangan masing-masing metode.

---

## Kode Program

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
