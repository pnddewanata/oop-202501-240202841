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
