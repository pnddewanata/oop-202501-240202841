# Laporan Praktikum Minggu 7 
Topik: Collections dan Implementasi Keranjang Belanja
## Identitas
- Nama  : Muhammad Pandu Dewanata Yaseh Hidayat
- NIM   : 240202841
- Kelas : 3IKRA

---

## Tujuan
1. Mahasiswa memahami konsep Collection Framework di Java (List, Map, Set).
2. Mampu mengimplementasikan keranjang belanja menggunakan ArrayList.
3. Mampu melakukan operasi dasar: menambah, menghapus, dan menghitung total harga.
4. Memahami perbedaan penggunaan List dan Map dalam konteks nyata (Agri-POS).

---

## Dasar Teori
1. List (misal ArrayList) menyimpan elemen berurut dan memperbolehkan duplikat.
2. Map (misal HashMap) menyimpan pasangan key–value dan cocok untuk mengelola kuantitas.
3. Set (misal HashSet) tidak mengizinkan duplikat dan tidak menjamin urutan.
4. Collection Framework memungkinkan pengelolaan data dinamis tanpa ukuran tetap seperti array.
5. Dalam keranjang belanja, List cocok untuk skenario sederhana, sedangkan Map lebih efisien bila perlu menghitung jumlah per produk.


---

## Langkah Praktikum
1. Membuat class Product dengan atribut code, name, dan price (immutable).
2. Mengimplementasikan ShoppingCart menggunakan ArrayList<Product>.
3. Menambahkan method: addProduct(), removeProduct(), getTotal(), dan printCart().
4. Membuat MainCart.java untuk menguji fungsionalitas keranjang.
5. (Opsional) Membuat versi alternatif ShoppingCartMap menggunakan Map<Product, Integer>.
6. Menjalankan program, mengambil screenshot output, dan menyusun laporan.
7. Melakukan commit dengan pesan:
   ```
   week7-collections: implementasi keranjang belanja dengan ArrayList
   ```

---

## Kode Program
```java
// MainCart
package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am Muhammad Pandu Dewanata Yaseh Hidayat-240202841 (Week7)");

        Product p1 = new Product("P01", "Beras", 50000.0);  
        Product p2 = new Product("P02", "Pupuk", 30000.0);  

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}
```
```java
// Product
package com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
```
```java
// ShoppingCart
package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}
```
```java
// ShoppingCartMap
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
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
- Cara Kode Berjalan:
   Program dimulai dari MainCart.java, yang membuat dua objek Product (Beras dan Pupuk) dengan harga bertipe double. Objek-objek ini ditambahkan ke dalam ShoppingCart yang menggunakan ArrayList<Product> sebagai wadah. Saat addProduct() dipanggil, produk dimasukkan ke daftar. Method printCart() menampilkan semua produk beserta total harga dengan menjumlahkan harga setiap produk melalui iterasi. Ketika removeProduct() dipanggil, produk yang sesuai dihapus dari daftar, dan tampilan diperbarui. Seluruh proses berjalan secara sinkron dan linear, tanpa input pengguna, hanya melalui logika hardcoded dalam main.

- Perbedaan dengan Minggu Sebelumnya:
   Pada minggu-minggu sebelumnya, fokus utama adalah pada konsep dasar OOP seperti class, object, enkapsulasi, dan method. Program biasanya melibatkan satu atau beberapa objek statis. Sedangkan pada minggu ini, fokus beralih ke manajemen koleksi objek secara dinamis menggunakan struktur data dari Java Collections Framework (ArrayList). Ini menandai pergeseran dari manipulasi objek tunggal ke pengelolaan sekumpulan objek, yang lebih mendekati skenario aplikasi nyata seperti sistem POS.

- Kendala dan Solusi:
   Kendala utama adalah ketidaksesuaian tipe data dan struktur class — awalnya harga ditulis sebagai int (misal 50000), tetapi konstruktor Product menerima double, menyebabkan error kompilasi. Selain itu, file Product.java dari praktikum minggu lain (misal Week 9) yang tidak memiliki field code atau method getCode() ikut terbaca, sehingga method seperti p.getCode() gagal. Masalah ini diatasi dengan:
   1. mengganti literal harga menjadi 50000.0 agar sesuai tipe double,
   2. memastikan hanya menggunakan file Product.java dan ShoppingCart.java yang sesuai template Week 7,
   3. membersihkan direktori dari file duplikat atau tidak relevan.


---

## Kesimpulan
Dengan menggunakan Collections seperti ArrayList, program keranjang belanja menjadi lebih efisien dalam mengelola data yang bersifat dinamis, mudah dikembangkan untuk fitur tambahan (seperti kuantitas atau diskon), dan mencerminkan penerapan struktur data yang tepat dalam pengembangan aplikasi nyata seperti Agri-POS.

---

## Quiz
1. Jelaskan perbedaan mendasar antara List, Map, dan Set.
List (misal: ArrayList)
→ Menyimpan elemen secara berurut (indexed), memperbolehkan duplikat, dan mempertahankan urutan penambahan.
→ Akses elemen berdasarkan indeks (misal: list.get(0)).
Set (misal: HashSet)
→ Menyimpan elemen tanpa duplikat dan tidak menjamin urutan.
→ Bergantung pada implementasi equals() dan hashCode() untuk menjamin keunikan.
Map (misal: HashMap)
→ Menyimpan data dalam bentuk pasangan key–value.
→ Setiap key harus unik, tetapi value boleh duplikat.
→ Akses data berdasarkan key, bukan indeks.

   Inti perbedaan:
   - List = urutan + duplikat diizinkan
   - Set = keunikan + tanpa urutan
   - Map = asosiasi (key → value)

2. Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?
Karena dalam keranjang belanja sederhana, pengguna biasanya:
   - Bisa memasukkan produk yang sama lebih dari sekali (misal: 2 bungkus beras → dianggap sebagai dua entri terpisah),
   - Ingin melihat produk sesuai urutan saat dimasukkan,
   - Tidak perlu menghitung kuantitas per produk secara eksplisit.
ArrayList mendukung semua ini secara alami: ia mempertahankan urutan, memungkinkan duplikat, dan mudah digunakan untuk operasi tambah/hapus.

3. Bagaimana struktur Set mencegah duplikasi data?
   Set (seperti HashSet) menggunakan kombinasi dari metode equals() dan hashCode() dari objek untuk menentukan keunikan:
   - Saat menambahkan elemen baru, Set memeriksa apakah sudah ada elemen dengan hashCode() yang sama.
   - Jika ya, lalu dicek dengan equals() untuk memastikan benar-benar sama.
   - Jika equals() mengembalikan true, elemen tidak ditambahkan (karena dianggap duplikat).
   Jadi, duplikasi dicegah secara otomatis selama kelas objek meng-override equals() dan    hashCode() dengan benar.

4. Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.
   Gunakan Map ketika Anda perlu:
   - Mengaitkan data dengan kunci tertentu, atau
   - Melacak jumlah (kuantitas) per item secara efisien.

   Contoh:
   Dalam keranjang belanja yang mendukung kuantitas, alih-alih menyimpan 5 objek Beras di List, lebih efisien menyimpan:
   ```java
   Map<Product, Integer> keranjang = new HashMap<>();
   keranjang.put(beras, 5);  // "Beras" → jumlah 5
   ```
   Keuntungan Map:
   - Hemat memori (tidak simpan objek berulang),
   - Mudah memperbarui jumlah (keranjang.put(beras, 6)),
   - Total harga dihitung cepat: harga × kuantitas.
   Sedangkan List cocok hanya jika setiap entri dianggap unik terlepas dari jenis produknya        (misal: log transaksi).
