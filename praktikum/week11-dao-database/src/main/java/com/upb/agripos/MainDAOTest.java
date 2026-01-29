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