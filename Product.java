package assgn2; public class Product {
private int id; private String name; private double price; private int stock;
private TaxCategory taxCategory;

public Product(int id, String name, double price, TaxCategory taxCategory) { this.id = id;
this.name = name; this.price = price;
this.taxCategory = taxCategory; this.stock = 0;
}

public int getId() { return id; }
public String getName() { return name; } public double getPrice() { return price; } public int getStock() { return stock; }
public TaxCategory getTaxCategory() { return taxCategory; } public void increaseStock(int quantity) { stock += quantity; } public void decreaseStock(int quantity) { stock -= quantity; }
}

Supplier.java package assgn2; public class Supplier {
private int id; private String name;
public Supplier(int id, String name) { this.id = id;
this.name = name;
}
public int getId() { return id; }
public String getName() { return name; }
}
