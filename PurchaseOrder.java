package assgn2; import java.util.*;
public class PurchaseOrder { private Supplier supplier;
private List<PurchaseOrderItem> items;

public PurchaseOrder(Supplier supplier) { this.supplier = supplier;
this.items = new ArrayList<>();
}
public void addItem(Product product, int quantity, double cost) { items.add(new PurchaseOrderItem(product, quantity, cost));
}
public void receive() {
for (PurchaseOrderItem item : items) { item.getProduct().increaseStock(item.getQuantity());
}
}
public void printReceipt() { double total = 0;
double totalTax = 0;
System.out.println("Purchase from Supplier: " + supplier.getName()); for (PurchaseOrderItem item : items) {
double tax = item.getProduct().getTaxCategory().getRate() * item.getTotal(); totalTax += tax;
System.out.println(item.getProduct().getName() + " x " + item.getQuantity() + " = " + item.getTotal() + " + Tax: " + tax);
total += item.getTotal();
}
System.out.println("Total Tax: " + totalTax); System.out.println("Grand Total: " + (total + totalTax));
}

}

