package com.upb.agripos;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // Mengurangi stok (dipakai saat checkout)
    public void reduceStock(int amount) throws InsufficientStockException {
        if (amount > stock) {
            throw new InsufficientStockException("Stok tidak cukup untuk " + name + ". Tersedia: " + stock);
        }
        this.stock -= amount;
    }

    @Override
    public String toString() {
        return name + " (Rp" + price + ", stok: " + stock + ")";
    }
}
