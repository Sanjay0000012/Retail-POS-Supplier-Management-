package assgn2; public class SaleItem {
private Product product; private int quantity;
public SaleItem(Product product, int quantity) { this.product = product;
this.quantity = quantity;
}
public Product getProduct() { return product; } public int getQuantity() { return quantity; }
public double getSubtotal() { return product.getPrice() * quantity; }
public double getTaxAmount() { return getSubtotal() * product.getTaxCategory().getRate(); }
}
