package assgn2; import java.util.*;
public class Sale {
private List<SaleItem> items; private double total;
private double totalTax; public Sale() {
this.items = new ArrayList<>(); this.total = 0.0;
this.totalTax = 0.0;
}
public void addItem(Product product, int quantity) { items.add(new SaleItem(product, quantity));
}
public void confirm() { total = 0;
totalTax = 0;
for (SaleItem item : items) { Product p = item.getProduct(); int qty = item.getQuantity(); p.decreaseStock(qty);
double subtotal = p.getPrice() * qty;
double tax = subtotal * p.getTaxCategory().getRate(); total += subtotal;
totalTax += tax;
}
}
private double discountRate = 0; public void setDiscount(double rate) {
 
this.discountRate = rate;
}
public void printBill() { System.out.println("Sale Bill:"); for (SaleItem item : items) {
Product p = item.getProduct(); int qty = item.getQuantity();
double subtotal = p.getPrice() * qty;
double tax = subtotal * p.getTaxCategory().getRate(); System.out.println(p.getName() + " x " + qty + " = " + subtotal + " + Tax: " + tax);
}
double discountAmount = (total + totalTax) * discountRate; System.out.println("Total Tax: " + totalTax);
if (discountRate > 0) System.out.println("Discount: -" + discountAmount); System.out.println("Grand Total: " + ((total + totalTax) - discountAmount));
}
}
