class Supplier {
    private String supplierId;
    private String name;
    private String address;

    public Supplier(String supplierId, String name, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Supplier ID: %s, Name: %s, Address: %s", supplierId, name, address);
    }
}