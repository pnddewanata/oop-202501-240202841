package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Tambah barang ke keranjang (hanya validasi jumlah)
    public void addProduct(Product product, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Jumlah barang harus lebih dari 0, input: " + quantity);
        }
        items.merge(product, quantity, Integer::sum); // tambah atau update jumlah
    }

    // Hapus barang dari keranjang
    public void removeProduct(Product product) throws ProductNotFoundException {
        if (!items.containsKey(product)) {
            throw new ProductNotFoundException("Produk tidak ditemukan di keranjang: " + product.getName());
        }
        items.remove(product);
    }

    // Checkout: validasi stok semua barang
    public void checkout() throws InsufficientStockException {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            product.reduceStock(qty); // ini akan melempar exception jika stok tidak cukup
        }
        System.out.println("✅ Checkout berhasil! Semua stok diperbarui.");
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("🛒 Keranjang belanja kosong.");
            return;
        }
        System.out.println("\n--- KERANJANG BELANJA ---");
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int q = entry.getValue();
            double subtotal = p.getPrice() * q;
            System.out.println(p.getName() + " x" + q + " = Rp" + subtotal);
            total += subtotal;
        }
        System.out.println("Total: Rp" + total);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
