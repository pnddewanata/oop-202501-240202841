# Laporan Praktikum Minggu 9
Topik: Exception Handling, Custom Exception, dan Penerapan dalam Aplikasi Keranjang Belanja

## Identitas
- Nama  : Muhammad Pandu Dewanata Yaseh Hidayat
- NIM   : 240202841
- Kelas : 3IKRA

---

## Tujuan
Mahasiswa memahami konsep exception handling, mampu membedakan error dan exception, serta dapat membuat dan menangani custom exception seperti InvalidQuantityException, ProductNotFoundException, dan InsufficientStockException dalam implementasi aplikasi keranjang belanja yang menerapkan enkapsulasi dan validasi bisnis.

---

## Dasar Teori
1. Exception adalah kondisi tidak normal yang terjadi saat runtime dan dapat ditangani, sedangkan error adalah masalah serius yang biasanya tidak dapat dipulihkan oleh program.
2. Blok try-catch-finally digunakan untuk menangkap dan menangani exception: try berisi kode berisiko, catch menangani exception tertentu, dan finally selalu dijalankan terlepas ada atau tidaknya exception.
3. Custom exception adalah exception buatan programmer yang diturunkan dari kelas Exception, digunakan untuk merepresentasikan error spesifik dalam konteks bisnis aplikasi.
4. Exception handling memungkinkan program berjalan gracefully (tidak crash) meskipun terjadi kesalahan input atau kondisi tak terduga.
5. Dalam aplikasi POS (Point of Sale), exception digunakan untuk memvalidasi input pengguna, ketersediaan data, dan ketersediaan stok secara real-time.
---

## Langkah Praktikum
1. Membuat struktur direktori proyek sesuai ketentuan: 
```
praktikum/week9-exception-handling/src/main/java/com/upb/agripos/.
```
2. Menulis enam file kode Java: tiga custom exception 
InvalidQuantityException.java, ProductNotFoundException.java, InsufficientStockException.java, serta kelas Product.java, ShoppingCart.java, dan MainExceptionDemo.java.
3. Melakukan pengujian berbagai skenario exception melalui MainExceptionDemo.java dan mengamati output di konsol.
4. Mengambil screenshot hasil eksekusi dan menyimpannya di screenshots/hasil.png.
5. Menyusun laporan praktikum dalam format Markdown.
6. Melakukan commit dengan pesan: feat: implement 
```
exception handling for shopping cart with custom exceptions and shopping cart logic
```
---

## Kode Program
Berikut contoh penggunaan custom exception dalam keranjang belanja:
```java
// Menambah produk dengan jumlah tidak valid
try {
    cart.addProduct(beras, 0);
} catch (InvalidQuantityException e) {
    System.err.println("❌ Error: " + e.getMessage());
}

// Checkout saat stok tidak cukup
try {
    cart.checkout();
} catch (InsufficientStockException e) {
    System.err.println("❌ Gagal checkout: " + e.getMessage());
}
```
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/week%209.png)
)
---

## Analisis
- Bagaimana kode berjalan: Program dimulai dari MainExceptionDemo yang menguji berbagai skenario error. Setiap operasi berisiko (tambah barang, hapus barang, checkout) dibungkus dalam try-catch. Jika terjadi kondisi tidak valid, custom exception dilempar dan ditangkap, lalu ditampilkan pesan kesalahan spesifik tanpa menghentikan program.
- Perbedaan dengan minggu sebelumnya: Minggu sebelumnya fokus pada pembuatan struktur class dan object (OOP dasar), sedangkan minggu ini fokus pada ketahanan program melalui penanganan error dan validasi bisnis yang realistis.
- Kendala dan solusi:
   - Awalnya bingung menempatkan validasi stok (di addProduct atau checkout). Solusi: validasi stok dipindah ke checkout karena stok bisa berubah dinamis.
   - Lupa bahwa custom exception bersifat checked, sehingga harus ditangani. Solusi: tambahkan throws di method dan try-catch di main.
   - Output tidak terstruktur. Solusi: tambahkan label uji dan pembatas untuk memudahkan verifikasi.
---

## Kesimpulan
Dengan menerapkan exception handling dan custom exception, program keranjang belanja menjadi lebih andal, mudah didebug, dan mampu memberikan umpan balik kesalahan yang jelas kepada pengguna tanpa mengalami crash.

---

## Quiz
1. Jelaskan perbedaan error dan exception.
   - Error adalah kondisi fatal yang terjadi di luar kendali program dan tidak dapat ditangani (misalnya: OutOfMemoryError, StackOverflowError).
   - Exception adalah kondisi tidak normal namun dapat ditangani selama program berjalan, seperti input tidak valid atau stok tidak cukup. Exception dibagi menjadi checked (harus ditangani) dan unchecked (opsional).

2. Apa fungsi finally dalam blok try–catch–finally?
   - Blok finally selalu dijalankan, baik exception terjadi maupun tidak. Fungsinya untuk menjalankan kode pembersihan atau finalisasi, seperti menutup koneksi, membersihkan resource, atau menampilkan status akhir (misalnya: "Jumlah item dalam keranjang: X").

3. Mengapa custom exception diperlukan?
   Custom exception diperlukan agar kesalahan bisnis spesifik dapat:
   - Diidentifikasi secara jelas,
   - Ditangani secara terpisah dari exception umum,
   - Memberikan pesan error yang informatif kepada pengguna atau developer.
   Tanpa custom exception, semua error akan ditangani  secara generik, sehingga sulit melacak akar masalah.

4. Berikan contoh kasus bisnis dalam POS yang membutuhkan custom exception.
   Dalam sistem AgriPos (Point of Sale pertanian), contoh kasusnya:
   - InvalidQuantityException: saat kasir memasukkan jumlah barang ≤ 0.
   - InsufficientStockException: saat pelanggan membeli lebih dari stok tersedia.
   - ProductNotFoundException: saat mencoba menghapus produk yang tidak ada di keranjang.
   Ketiga exception ini memastikan integritas data, pengalaman pengguna yang baik, dan logika bisnis yang aman.
