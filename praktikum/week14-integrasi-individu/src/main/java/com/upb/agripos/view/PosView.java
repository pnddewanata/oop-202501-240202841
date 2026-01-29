package com.upb.agripos.view;

import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PosView extends VBox {

    private TextField txtProductCode;
    private TextField txtProductName;
    private TextField txtProductPrice;
    private TextField txtProductStock;
    private Button btnAddProduct;
    private Button btnDeleteProduct;
    private TableView<Product> productTable;

    private TextField txtQuantity;
    private Button btnAddToCart;
    private Button btnRemoveFromCart;
    private Button btnClearCart;
    private Button btnCheckout;
    private TableView<CartItem> cartTable;
    private Label lblCartCount;
    private Label lblCartTotal;

    public PosView() {
        initializeView();
    }

    private void initializeView() {
        setPadding(new Insets(0));
        setSpacing(0);
        setStyle("""
            -fx-background-color: linear-gradient(to bottom, #0f766e 0%, #134e4a 50%, #06513f 100%);
        """);

        HBox headerBox = createHeader();

        HBox mainContent = new HBox(15);
        mainContent.setPadding(new Insets(15));

        VBox leftColumn = createProductSection();
        VBox rightColumn = createCartSection();

        HBox.setHgrow(leftColumn, Priority.ALWAYS);
        HBox.setHgrow(rightColumn, Priority.ALWAYS);

        mainContent.getChildren().addAll(leftColumn, rightColumn);

        VBox summarySection = createSummarySection();

        getChildren().addAll(headerBox, mainContent, summarySection);
        VBox.setVgrow(mainContent, Priority.ALWAYS);
    }

    private HBox createHeader() {
        HBox header = new HBox(20);
        header.setPadding(new Insets(20, 28, 20, 28));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("""
            -fx-background-color: linear-gradient(to right, #0d9488 0%, #0f766e 50%, #06513f 100%);
            -fx-border-radius: 0 0 20 20;
            -fx-background-radius: 0 0 20 20;
            -fx-effect: dropshadow(gaussian, #00000033, 12, 0.3, 0, 4);
        """);

        Label title = new Label("🌿 AGRI-POS SYSTEM 🌿");
        title.setStyle("-fx-font-size: 28; -fx-font-weight: bold; -fx-text-fill: #ecfdf5; -fx-letter-spacing: 2px;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label version = new Label("Manajemen Produk & Transaksi Pertanian");
        version.setStyle("-fx-font-size: 14; -fx-text-fill: #a7f3d0; -fx-font-style: italic; -fx-font-weight: 500;");

        header.getChildren().addAll(title, spacer, version);
        return header;
    }

    private VBox createProductSection() {
        VBox section = new VBox(16);
        section.setPadding(new Insets(24, 24, 20, 24));
        section.setStyle("""
            -fx-background-color: linear-gradient(to bottom, #f0fdfa 0%, #e1f5fe 100%);
            -fx-border-color: linear-gradient(to right, #5eead4, #38bdf8);
            -fx-border-width: 2;
            -fx-border-radius: 16;
            -fx-background-radius: 16;
            -fx-effect: dropshadow(gaussian, #0d948844, 8, 0.2, 0, 4);
        """);

        Label title = new Label("📦 Manajemen Produk");
        title.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #0d7377; -fx-letter-spacing: 1px;");

        GridPane form = new GridPane();
        form.setHgap(12);
        form.setVgap(12);
        form.setStyle("-fx-padding: 10;");

        txtProductCode = createInput();
        txtProductName = createInput();
        txtProductPrice = createInput();
        txtProductStock = createInput();

        Label lbCode = new Label("Kode");
        lbCode.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d7377;");
        Label lbName = new Label("Nama");
        lbName.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d7377;");
        Label lbPrice = new Label("Harga");
        lbPrice.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d7377;");
        Label lbStock = new Label("Stok");
        lbStock.setStyle("-fx-font-weight: bold; -fx-text-fill: #0d7377;");

        form.add(lbCode, 0, 0); form.add(txtProductCode, 1, 0);
        form.add(lbName, 0, 1); form.add(txtProductName, 1, 1);
        form.add(lbPrice, 0, 2); form.add(txtProductPrice, 1, 2);
        form.add(lbStock, 0, 3); form.add(txtProductStock, 1, 3);

        btnAddProduct = primaryButton("✓ Tambah Produk");
        btnDeleteProduct = dangerButton("✕ Hapus Produk");

        HBox buttons = new HBox(10, btnAddProduct, btnDeleteProduct);
        buttons.setAlignment(Pos.CENTER_LEFT);

        productTable = new TableView<>();
        productTable.setStyle("-fx-font-size: 12;");
        createProductTableColumns();
        VBox.setVgrow(productTable, Priority.ALWAYS);

        section.getChildren().addAll(title, form, buttons, productTable);
        return section;
    }

    private VBox createCartSection() {
        VBox section = new VBox(16);
        section.setPadding(new Insets(24, 24, 20, 24));
        section.setStyle("""
            -fx-background-color: linear-gradient(to bottom, #ecfdf5 0%, #dcfce7 100%);
            -fx-border-color: linear-gradient(to right, #10b981, #34d399);
            -fx-border-width: 2;
            -fx-border-radius: 16;
            -fx-background-radius: 16;
            -fx-effect: dropshadow(gaussian, #0d948844, 8, 0.2, 0, 4);
        """);

        Label title = new Label("🛒 Keranjang Belanja");
        title.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #065f46; -fx-letter-spacing: 1px;");

        txtQuantity = createInput();
        txtQuantity.setPrefWidth(100);

        btnAddToCart = primaryButton("➕ Tambah ke Keranjang");
        HBox qtyBox = new HBox(10, new Label("Qty:"), txtQuantity, btnAddToCart);
        qtyBox.setAlignment(Pos.CENTER_LEFT);
        qtyBox.setStyle("-fx-padding: 8; -fx-background-color: #f0fdf4; -fx-background-radius: 10;");

        cartTable = new TableView<>();
        cartTable.setStyle("-fx-font-size: 12;");
        createCartTableColumns();
        VBox.setVgrow(cartTable, Priority.ALWAYS);

        lblCartCount = new Label("Total Item: 0");
        lblCartCount.setStyle("-fx-font-size: 13; -fx-text-fill: #065f46; -fx-font-weight: 600;");
        lblCartTotal = new Label("Total: Rp. 0");
        lblCartTotal.setStyle("-fx-font-weight: bold; -fx-text-fill: #047857; -fx-font-size: 14;");

        HBox totalBox = new HBox(10, lblCartCount, new Region(), lblCartTotal);
        totalBox.setStyle("-fx-padding: 12; -fx-background-color: #dcfce7; -fx-background-radius: 10; -fx-border-color: #86efac; -fx-border-width: 1;");
        HBox.setHgrow(totalBox.getChildren().get(1), Priority.ALWAYS);

        btnRemoveFromCart = dangerButton("🗑️ Hapus Item");
        btnClearCart = warningButton("⚠️ Clear");
        HBox cartButtons = new HBox(10, btnRemoveFromCart, btnClearCart);
        cartButtons.setAlignment(Pos.CENTER_LEFT);

        btnCheckout = checkoutButton("💳 CHECKOUT");
        btnCheckout.setPrefHeight(48);

        section.getChildren().addAll(title, qtyBox, cartTable, totalBox, cartButtons, btnCheckout);
        return section;
    }

    private VBox createSummarySection() {
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.getChildren().add(new Label("Checkout dilakukan dari keranjang belanja"));
        return box;
    }

    /* ===== UTIL STYLE ===== */
    private TextField createInput() {
        TextField tf = new TextField();
        tf.setStyle("""
            -fx-padding: 12;
            -fx-background-radius: 10;
            -fx-border-radius: 10;
            -fx-border-color: linear-gradient(to right, #5eead4, #38bdf8);
            -fx-border-width: 2;
            -fx-font-size: 13;
            -fx-background-color: #f0fdfa;
            -fx-text-fill: #0d7377;
            -fx-control-inner-background: #f0fdfa;
        """);
        return tf;
    }

    private Button primaryButton(String text) {
        Button b = new Button(text);
        b.setStyle("""
            -fx-background-color: linear-gradient(to right, #0d9488 0%, #06b6d4 50%, #0369a1 100%);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #0d948844, 4, 0.2, 0, 2);
        """);
        b.setOnMouseEntered(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #14b8a6 0%, #22d3ee 50%, #0ea5e9 100%);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #0d948866, 6, 0.3, 0, 3);
        """));
        b.setOnMouseExited(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #0d9488 0%, #06b6d4 50%, #0369a1 100%);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #0d948844, 4, 0.2, 0, 2);
        """));
        return b;
    }

    private Button dangerButton(String text) {
        Button b = new Button(text);
        b.setStyle("""
            -fx-background-color: linear-gradient(to right, #dc2626, #b91c1c);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #dc262644, 4, 0.2, 0, 2);
        """);
        b.setOnMouseEntered(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #ef4444, #dc2626);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #dc262666, 6, 0.3, 0, 3);
        """));
        b.setOnMouseExited(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #dc2626, #b91c1c);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #dc262644, 4, 0.2, 0, 2);
        """));
        return b;
    }

    private Button warningButton(String text) {
        Button b = new Button(text);
        b.setStyle("""
            -fx-background-color: linear-gradient(to right, #f59e0b, #d97706);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #f59e0b44, 4, 0.2, 0, 2);
        """);
        b.setOnMouseEntered(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #fbbf24, #f59e0b);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #f59e0b66, 6, 0.3, 0, 3);
        """));
        b.setOnMouseExited(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #f59e0b, #d97706);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 10;
            -fx-padding: 14 20;
            -fx-font-size: 14;
            -fx-effect: dropshadow(gaussian, #f59e0b44, 4, 0.2, 0, 2);
        """));
        return b;
    }

    private Button checkoutButton(String text) {
        Button b = new Button(text);
        b.setStyle("""
            -fx-background-color: linear-gradient(to right, #0d9488 0%, #10b981 50%, #059669 100%);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 12;
            -fx-padding: 16 24;
            -fx-font-size: 16;
            -fx-effect: dropshadow(gaussian, #0d948855, 6, 0.3, 0, 3);
        """);
        b.setOnMouseEntered(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #14b8a6 0%, #34d399 50%, #10b981 100%);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 12;
            -fx-padding: 16 24;
            -fx-font-size: 16;
            -fx-effect: dropshadow(gaussian, #0d948877, 8, 0.4, 0, 4);
        """));
        b.setOnMouseExited(e -> b.setStyle("""
            -fx-background-color: linear-gradient(to right, #0d9488 0%, #10b981 50%, #059669 100%);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 12;
            -fx-padding: 16 24;
            -fx-font-size: 16;
            -fx-effect: dropshadow(gaussian, #0d948855, 6, 0.3, 0, 3);
        """));
        return b;
    }

    /* ===== TABLE SETUP ===== */
    private void createProductTableColumns() {
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colCode.setPrefWidth(90);

        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colName.setPrefWidth(160);

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colPrice.setPrefWidth(100);

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colStock.setPrefWidth(80);

        productTable.getColumns().clear();
        productTable.getColumns().addAll(colCode, colName, colPrice, colStock);
    }

    private void createCartTableColumns() {
        TableColumn<CartItem, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
            cellData.getValue().getProduct().getCode()
        ));
        colCode.setPrefWidth(90);

        TableColumn<CartItem, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
            cellData.getValue().getProduct().getName()
        ));
        colName.setPrefWidth(160);

        TableColumn<CartItem, Integer> colQty = new TableColumn<>("Qty");
        colQty.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("quantity"));
        colQty.setPrefWidth(60);

        TableColumn<CartItem, Double> colSubtotal = new TableColumn<>("Subtotal");
        colSubtotal.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(
            cellData.getValue().getSubtotal()
        ));
        colSubtotal.setPrefWidth(100);

        cartTable.getColumns().clear();
        cartTable.getColumns().addAll(colCode, colName, colQty, colSubtotal);
    }

    /* ===== GETTERS & CONTROLLER CONTRACT ===== */
    public Button getBtnAddProduct() { return btnAddProduct; }
    public Button getBtnDeleteProduct() { return btnDeleteProduct; }
    public Button getBtnAddToCart() { return btnAddToCart; }
    public Button getBtnRemoveFromCart() { return btnRemoveFromCart; }
    public Button getBtnClearCart() { return btnClearCart; }
    public Button getBtnCheckout() { return btnCheckout; }
    public TableView<Product> getProductTable() { return productTable; }
    public TableView<CartItem> getCartTable() { return cartTable; }

    public Product getProductFromInput() {
        String code = txtProductCode.getText().trim();
        String name = txtProductName.getText().trim();
        String priceStr = txtProductPrice.getText().trim();
        String stockStr = txtProductStock.getText().trim();

        if (code.isEmpty() || name.isEmpty() || priceStr.isEmpty() || stockStr.isEmpty()) {
            throw new IllegalArgumentException("Semua field produk wajib diisi.");
        }
        double price;
        int stock;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Harga harus berupa angka.");
        }
        try {
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Stok harus berupa angka bulat.");
        }
        return new Product(code, name, price, stock);
    }

    public int getQuantityFromInput() {
        return Integer.parseInt(txtQuantity.getText());
    }

    public void clearProductInput() {
        txtProductCode.clear();
        txtProductName.clear();
        txtProductPrice.clear();
        txtProductStock.clear();
    }

    public void clearQuantityInput() {
        txtQuantity.clear();
    }

    public void updateCartSummary(int itemCount, double total) {
        lblCartCount.setText("Total Item: " + itemCount);
        lblCartTotal.setText(String.format("Total: Rp. %.2f", total));
    }
}