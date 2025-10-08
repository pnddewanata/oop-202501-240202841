# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: “Eksplorasi Paradigma Pemrograman Java: Dari Prosedural ke OOP hingga Fungsional”0

## Identitas
- Nama  : Nama Muhammad Pandu Dewanata Yaseh Hidayat
- NIM   : NIM 240202841
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
// HelloProcedural.java
public class HelloProcedural {
   public static void main(String[] args) {
      
      String NIM = "240202841";
      String NAMA = "MUHAMMAD PANDU DEWANATA YASEH HIDAYAT";

      // Prosedural dengan method
        PANGGIL("MUHAMMAD PANDU DEWANATA YASEH HIDAYAT", "2402022841");
      // Bisa dipanggil secara berulang

   }
 // Method 
    public static void PANGGIL(String NAMA, String NIM){
        System.out.println("HELLO WORD, IM "+ NAMA + " -"+ NIM);
    }
}

// HelloOOP.java
class MAHASISWA {
    String NAMA; int NIM;
    MAHASISWA(String NM, int NI){NAMA=NM; NIM=NI; }
    void PANGGIL(){ System.out.println("HELLO WORD, IM "+ NAMA + " -"+ NIM);}
}

public class HelloOOP {
    public static void main(String[] args) {
        MAHASISWA RAJIN = new MAHASISWA("MUHAMMAD PANDU DEWANATA YASEH HIDAYAT", 240202841);
        RAJIN.PANGGIL();
    }
}

// HelloFunctional.java
import java.util.function.BiConsumer;
public class HelloFunctional {
    public static void main(String[] args) {
        BiConsumer<String, Integer> PANGGIL =
            (NAMA, NIM)-> System.out.println("HELLO WORD, IM "+ NAMA + "-"+ NIM);
            PANGGIL.accept("MUHAMMAD PANDU DEWANATA YASEH HIDAYAT", 240202841);
        
    }
}

---

## Hasil Eksekusi
(
1. Procedural
![Screenshot hasil](screenshots/HelloProcedural.png)

2. OOP
![Screenshot hasil](screenshots/HelloOOP.png)

3. Functional
![Screenshot hasil](screenshots/HelloFunctional.png)
)

---

## Analisis
(
- Jelaskan bagaimana kode berjalan.
  1. Pada HelloProcedural, program berjalan dengan mendeklarasikan variabel NAMA dan NIM, kemudian memanggil method PANGGIL() secara langsung. Setiap kali method dipanggil, program akan mencetak output sesuai parameter yang dikirimkan.

  2. Pada HelloOOP, program dimulai dengan membuat class MAHASISWA yang memiliki atribut NAMA dan NIM. Object RAJIN dibuat menggunakan constructor, lalu method PANGGIL() dipanggil untuk menampilkan informasi mahasiswa.

  3. Pada HelloFunctional, program menggunakan functional interface BiConsumer dengan lambda expression. Objek PANGGIL didefinisikan sebagai fungsi yang menerima dua parameter (NAMA dan NIM), lalu dijalankan dengan method .accept().
 
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya. 
  Ini baru minggu pertama jadi saya belum bisa membandingkannya.

- Kendala yang dihadapi dan cara mengatasinya. 
  Kendala:
  - Pada awalnya terjadi kesalahan sintaks dalam penggunaan lambda pada HelloFunctional.java.
 
  - Beberapa error muncul karena penulisan parameter pada constructor MAHASISWA kurang konsisten.

  - Output terkadang berulang di terminal karena program dijalankan berkali-kali tanpa membersihkan hasil eksekusi sebelumnya.

  Cara Mengatasi:
  - Mengecek kembali dokumentasi Java terkait penggunaan BiConsumer dan lambda expression.

  - Memperbaiki kesalahan kecil pada constructor dan parameter method.

  - Membersihkan terminal sebelum menjalankan ulang program agar output lebih jelas terbaca. 
)

---

## Kesimpulan
(1. Praktikum ini berhasil memperkenalkan tiga paradigma pemrograman dalam Java, yaitu prosedural, berorientasi objek (OOP), dan fungsional.

 2. Pada pendekatan prosedural, program disusun dalam bentuk method dan instruksi yang dijalankan secara berurutan.

 3. Pada pendekatan OOP, program disusun ke dalam class dan object sehingga kode lebih terstruktur, modular, dan mudah dikembangkan.

 4. Pada pendekatan fungsional, program menggunakan lambda expression dan functional interface untuk menuliskan kode yang lebih ringkas, deklaratif, dan efisien.

 5. Ketiga paradigma menghasilkan output yang sama, namun memiliki cara implementasi yang berbeda. Hal ini menunjukkan bahwa pemilihan paradigma bergantung pada kebutuhan program yang sedang dikembangkan.

 6. Melalui praktikum ini, mahasiswa dapat memahami kelebihan dan kekurangan dari masing-masing paradigma sehingga dapat memilih pendekatan yang paling sesuai dalam menyelesaikan suatu permasalahan pemrograman.

)

---

## Quiz
(
1. Apakah OOP selalu lebih baik dari prosedural?
   **Jawaban:** 
   Tidak selalu. OOP memang lebih unggul untuk aplikasi besar dan kompleks karena modular, mudah dikembangkan, dan mendukung reuse code. Namun, untuk program kecil dan sederhana, prosedural bisa lebih cepat dan efisien karena tidak membutuhkan struktur class dan object yang rumit.

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?
   **Jawaban:**
   Functional programming lebih cocok digunakan ketika program membutuhkan pemrosesan data dalam jumlah besar, operasi yang sifatnya paralel/asynchronous, atau manipulasi data dengan cara deklaratif (misalnya filtering, mapping, reducing). Paradigma ini membantu menulis kode yang ringkas dan mudah dibaca.

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?
   **Jawaban:** 
   - Prosedural: mudah ditulis, tetapi sulit di-maintain jika kode semakin besar karena struktur tidak modular.

   - OOP: meningkatkan maintainability dengan membagi kode ke dalam class dan object. Sangat mendukung scalability karena bisa diperluas dengan inheritance atau interface.

   - Fungsional: meningkatkan maintainability dengan kode yang singkat, minim efek samping, dan mudah diuji. Skalabilitas juga didukung karena fungsi dapat diparalelkan dengan lebih mudah.

4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
   **Jawaban:**
   Aplikasi POS (Point of Sale) biasanya memiliki banyak entity (contoh: Produk, Transaksi, Pelanggan, Karyawan) yang saling berhubungan. OOP lebih cocok karena dapat merepresentasikan entity tersebut sebagai class dan object, sehingga lebih terstruktur, mudah diperluas, dan memudahkan pengelolaan data serta fitur aplikasi.

5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (*boilerplate code*)?
   **Jawaban:**
   Paradigma fungsional menggunakan lambda expression dan higher-order function, sehingga developer tidak perlu menulis kode berulang untuk operasi yang sama. Misalnya, operasi map(), filter(), atau reduce() bisa menggantikan loop yang panjang. Dengan begitu, kode lebih ringkas, ekspresif, dan mudah dipelihara.
)
