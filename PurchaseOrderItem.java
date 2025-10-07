package assgn2;
public class PurchaseOrderItem { private Product product; private int quantity;
private double cost;
 
public PurchaseOrderItem(Product product, int quantity, double cost) { this.product = product;
this.quantity = quantity; this.cost = cost;
}
public Product getProduct() { return product; } public int getQuantity() { return quantity; } public double getCost() { return cost; }
public double getTotal() { return cost * quantity; }
}
