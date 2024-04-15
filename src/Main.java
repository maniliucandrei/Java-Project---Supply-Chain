
import java.util.*;

class SupplyChainManagement {
    private List<Product> products = new ArrayList<>();
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SupplyChainManagement scm = new SupplyChainManagement();
        scm.run();
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Add Supplier");
            System.out.println("4. View Suppliers");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    addSupplier();
                    break;
                case 4:
                    viewSuppliers();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 6:
                    viewOrders();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter stock quantity: ");
        int stock = scanner.nextInt();
        products.add(new Product(id, name, price, stock));
        System.out.println("Product added.");
    }

    private void viewProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void addSupplier() {
        System.out.print("Enter supplier ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter supplier name: ");
        String name = scanner.nextLine();
        System.out.print("Enter supplier address: ");
        String address = scanner.nextLine();
        suppliers.add(new Supplier(id, name, address));
        System.out.println("Supplier added.");
    }

    private void viewSuppliers() {
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }
    }

    private void placeOrder() {
        System.out.print("Enter order ID: ");
        String orderId = scanner.nextLine();
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();
        Product product = products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        if (quantity > product.getStock()) {
            System.out.println("Insufficient stock.");
            return;
        }
        orders.add(new Order(orderId, product, quantity));
        product.setStock(product.getStock() - quantity);
        System.out.println("Order placed.");
    }

    private void viewOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}