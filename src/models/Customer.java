package models;
import java.util.ArrayList;
import java.util.Scanner;
public class Customer extends Person implements View{
    public enum Gender {
        male, female;
    }
    private double balance;
    private String address;
    private ArrayList<Category> intrests;
    private Gender gender;
    Order order;
    public Customer(String username , String password , int day, int month , int year ,String gender , String address)
    {
        super(username,password,day,month,year);
        this.address = address;
        this.gender = Gender.valueOf(gender.toLowerCase());
        order = new Order(username,address);
        intrests = new ArrayList<Category>();

    }
    public Customer(){
        super();
        this.address = "NULL";
        gender = Gender.valueOf("NULL");
        order = new Order(username,address);
        intrests = new ArrayList<Category>();
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Order getOrder() {
        return order;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Category> getIntrests() {
        return intrests;
    }

    public void addIntrests(String category){
        if(Category.checkValidity(category.toLowerCase())){
            for (Category cat : intrests) {
                if(category.toLowerCase().equals(cat.gettype().toLowerCase())){
                    System.out.println("This Category is already added to your intrests");
                    return;
                }
            }
            intrests.add(new Category(category));
            System.out.println(category +" Added to intrests");
        }
        else
            System.out.println("Category you entered does not exist in our store");
    }

    public Gender getGender() {
        return gender;
    }

    public void add_to_cart(SupplierProduct Add){
        for(CustomerProduct product : (order.getMyCart()).cartItems){
            if(Add.getName().equals(product.getName()) ){
                product.setQuantity(product.getQuantity()+1);
                return;
            }
        }
        order.getMyCart().AddToCart(new CustomerProduct(Add));
        System.out.println("Item added to cart");
    }
     public void remove_from_cart(CustomerProduct Remove){
        for(CustomerProduct product : (order.getMyCart()).cartItems){
            if(Remove.getName().equals(product.getName())){
                order.getMyCart().removeFromCart(Remove);
                System.out.println("Item has been removed");
                return;
            }
        }
        System.out.println("Item not in cart");
    }
    public void viewByCategory(String category1) {
        if (Category.checkValidity(category1)) {
            for (Supplier supp : Database.suppliers)
                supp.viewByCategory(category1);
        } else {
            System.out.println("no existo");
        }
    }
    public void viewByIntrests() {
        if(intrests.isEmpty()){
            System.out.println("You have no intrests");
            return;
        }
        for( Category category : intrests){
            viewByCategory(category.gettype());
        }

    }
    public void viewAllProducts(){

        for(Supplier supplier : Database.suppliers){
            supplier.viewAllProducts();
        }

    }
    public void viewAllSuppliers()
    {
        for(Supplier supplier : Database.suppliers)
        {
            if(!supplier.getProducts().isEmpty())
            {
             System.out.println(supplier.getcompName());
            }
        }
        

    }

    public void view_by_supp(Supplier enteredSupplier){
        for(Supplier supplier : Database.suppliers){
            if(supplier == enteredSupplier){
                supplier.viewAllProducts();
                return;
            }
        }
    }
    public void viewMyCart(){
        System.out.println("Your cart:");
        order.getMyCart().viewcart();
    }
    public void finaliseOrder(String paymentmethod){
        if(this.Validate_final()) {
            if (paymentmethod.toLowerCase().equals("cash")) {
                order.payByCash();
            } else if (paymentmethod.toLowerCase().equals("balance")) {
                order.payByBalance(balance);
            } else {
                System.out.println("Invalid payment method");
                return;
            }
            order.finalizeOrder();
            Database.orders.add(order);
            order = new Order(username, address);
        }
    }
    public SupplierProduct select(String sel){
        String [] split = sel.split("\\.");
        int suppIndex = Integer.parseInt(split[0]);
        int prodIndex = Integer.parseInt(split[1]);
        return Database.suppliers.get(suppIndex).getProducts().get(prodIndex);
    }
    public void viewDetails(){
        System.out.println("Username : " + username);
    }
    public boolean Validate_final(){
        for(CustomerProduct product : (order.getMyCart()).cartItems)
        {
            if(product.getQuantity()>product.getSupplierProd().getStock()){
                System.out.println("The Quantity You are asking for the item " +product.getName() + " isn't available");
                System.out.println("Available Stock:"+product.getSupplierProd().getStock());
                return false;
            }
        }
        return true;
    }

}











