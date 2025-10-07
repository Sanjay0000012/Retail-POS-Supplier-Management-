package assgn2; import java.util.*;
public class RetailPOS {
private static List<Product> products = new ArrayList<>(); private static List<Supplier> suppliers = new ArrayList<>(); public static void main(String[] args) {
Scanner sc = new Scanner(System.in); System.out.println("--- Retail POS Menu ---"); System.out.println("1. Add Product"); System.out.println("2. Add Supplier"); System.out.println("3. Create Purchase Order"); System.out.println("4. Make Sale"); System.out.println("5. Display Inventory"); System.out.println("6. Exit");
int choice; do {
System.out.print("\nEnter choice: "); choice = sc.nextInt();
sc.nextLine(); switch (choice) {
case 1: addProduct(sc); break; case 2: addSupplier(sc); break;
case 3: createPurchaseOrder(sc); break; case 4: makeSale(sc); break;
case 5: displayInventory(); break;
case 6: System.out.println("Exiting..."); break;
default: System.out.println("Invalid choice, try again.");
}
} while (choice != 6);

sc.close();
}
private static void addProduct(Scanner sc) { System.out.print("Enter product id: "); int id = sc.nextInt(); sc.nextLine();
System.out.print("Enter product name: "); String name = sc.nextLine(); System.out.print("Enter product price: ");
 
double price = sc.nextDouble(); sc.nextLine(); TaxCategory tax = new TaxCategory("GST", 0.18); products.add(new Product(id, name, price, tax));
}
private static void addSupplier(Scanner sc) { System.out.print("Enter supplier id: ");
int id = sc.nextInt(); sc.nextLine(); System.out.print("Enter supplier name: "); String name = sc.nextLine(); suppliers.add(new Supplier(id, name));
}
private static void createPurchaseOrder(Scanner sc) { if (suppliers.isEmpty() || products.isEmpty()) {
System.out.println("Suppliers or Products missing."); return;
}
System.out.println("Choose Supplier:"); for (int i = 0; i < suppliers.size(); i++)
System.out.println((i + 1) + ". " + suppliers.get(i).getName()); int sIndex = sc.nextInt() - 1;
Supplier sup = suppliers.get(sIndex); PurchaseOrder po = new PurchaseOrder(sup); char more;
do {
System.out.println("Choose Product:"); for (int i = 0; i < products.size(); i++)
System.out.println((i + 1) + ". " + products.get(i).getName()); int pIndex = sc.nextInt() - 1;
Product p = products.get(pIndex); System.out.print("Enter quantity: "); int qty = sc.nextInt();
System.out.print("Enter cost per unit: "); double cost = sc.nextDouble(); sc.nextLine(); po.addItem(p, qty, cost); System.out.print("Add more items? (y/n): "); more = sc.next().charAt(0);
} while (more == 'y' || more == 'Y'); po.receive();
po.printReceipt();
}
private static void makeSale(Scanner sc) { if (products.isEmpty()) {
System.out.println("No products available for sale."); return;
 
}
Sale sale = new Sale(); char more;
do {
System.out.println("Choose Product:"); for (int i = 0; i < products.size(); i++) {
Product p = products.get(i);
System.out.println((i + 1) + ". " + p.getName() + " (Stock: " + p.getStock() + ")");
}
int pIndex = sc.nextInt() - 1; Product p = products.get(pIndex); System.out.print("Enter quantity: "); int qty = sc.nextInt(); sc.nextLine();

if (qty > p.getStock())
System.out.println("Insufficient stock for " + p.getName()); else
sale.addItem(p, qty);

System.out.print("Add more items? (y/n): "); more = sc.next().charAt(0);
} while (more == 'y' || more == 'Y');

System.out.print("Enter discount percentage for this sale (0 for none): "); double discountPercent = sc.nextDouble(); sc.nextLine(); sale.setDiscount(discountPercent / 100.0);


sale.confirm(); sale.printBill();
}
private static void displayInventory() { System.out.println("Inventory:"); for (Product p : products)
System.out.println(p.getName() + " - Stock: " + p.getStock());
}
}
