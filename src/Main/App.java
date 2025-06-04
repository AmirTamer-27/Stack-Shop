package Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Views.*; // Adjust the import to match your project structure
import models.*; // Adjust the import to match your project structure
import Controllers.*; // Adjust the import to match your project structure

import java.io.IOException;

import javax.print.attribute.standard.MediaSize.NA;

public class App extends Application {
    public Customer c1;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Customer c1 = new Customer("Amir", "AmirtheGoat", 2, 7, 2005, "male", "Gardenia city");
        c1.setBalance(1000);
        c1.addIntrests("Electronics & Devices");
        c1.addIntrests("Clothing & Fashion");
        
        Customer c2 = new Customer("Sarah", "SarahTech", 15, 3, 1998, "female", "Silicon Valley");
        c2.setBalance(2500);
        c2.addIntrests("Electronics & Devices");
        c2.addIntrests("Sports & Outdoors");
        
        Customer c3 = new Customer("Omar", "OmarFit", 22, 11, 1995, "male", "Dubai Sports City");
        c3.setBalance(3000);
        c3.addIntrests("Sports & Outdoors");
        c3.addIntrests("Grocceries");
        
        Customer c4 = new Customer("Layla", "LaylaHome", 8, 9, 1990, "female", "Manhattan");
        c4.setBalance(5000);
        c4.addIntrests("Home & Kitchen");
        c4.addIntrests("Grocceries");
        
        Customer c5 = new Customer("Yusuf", "YusufStyle", 30, 4, 2000, "male", "Paris");
        c5.setBalance(1500);
        c5.addIntrests("Clothing & Fashion");
        c5.addIntrests("Electronics & Devices");
        
     
        Supplier samsung = new Supplier("Samsung", "samsung123", "Samsung Electronics");
        SupplierProduct samsungTV = new SupplierProduct("4K Smart TV", 2999, "Electronics & Devices", 15, samsung);
        SupplierProduct samsungPhone = new SupplierProduct("Galaxy S24", 999, "Electronics & Devices", 30, samsung);
        SupplierProduct samsungTablet = new SupplierProduct("Galaxy Tab S9", 849, "Electronics & Devices", 20, samsung);
        SupplierProduct samsungWatch = new SupplierProduct("Galaxy Watch 6", 299, "Electronics & Devices", 25, samsung);
        SupplierProduct samsungBuds = new SupplierProduct("Galaxy Buds Pro", 199, "Electronics & Devices", 40, samsung);
        samsung.add_product(samsungTV);
        samsung.add_product(samsungPhone);
        samsung.add_product(samsungTablet);
        samsung.add_product(samsungWatch);
        samsung.add_product(samsungBuds);

        Supplier apple = new Supplier("Apple", "apple", "Apple Inc");
        SupplierProduct iPhone = new SupplierProduct("iPhone 15 Pro", 1299, "Electronics & Devices", 25, apple);
        SupplierProduct macbook = new SupplierProduct("MacBook Pro M3", 1999, "Electronics & Devices", 15, apple);
        SupplierProduct ipad = new SupplierProduct("iPad Air", 599, "Electronics & Devices", 30, apple);
        apple.add_product(iPhone);
        apple.add_product(macbook);
        apple.add_product(ipad);

     
        Supplier nike = new Supplier("Nike", "nikeGlobal", "Nike Sports & Fashion");
        SupplierProduct nikeShoes = new SupplierProduct("Air Max 2024", 199, "Sports & Outdoors", 50, nike);
        SupplierProduct nikeTshirt = new SupplierProduct("Dri-FIT T-Shirt", 45, "Clothing & Fashion", 100, nike);
        SupplierProduct nikeJacket = new SupplierProduct("Windrunner Jacket", 120, "Sports & Outdoors", 30, nike);
        SupplierProduct nikeBag = new SupplierProduct("Sports Duffel Bag", 65, "Sports & Outdoors", 40, nike);
        nike.add_product(nikeShoes);
        nike.add_product(nikeTshirt);
        nike.add_product(nikeJacket);
        nike.add_product(nikeBag);

        Supplier adidas = new Supplier("Adidas", "adidas", "Adidas Sports");
        SupplierProduct adidasBoots = new SupplierProduct("Predator Soccer Boots", 180, "Sports & Outdoors", 35, adidas);
        SupplierProduct adidasTracksuit = new SupplierProduct("Training Tracksuit", 95, "Sports & Outdoors", 45, adidas);
        SupplierProduct adidasBall = new SupplierProduct("Champions League Ball", 140, "Sports & Outdoors", 50, adidas);
        adidas.add_product(adidasBoots);
        adidas.add_product(adidasTracksuit);
        adidas.add_product(adidasBall);

        
        Supplier freshmart = new Supplier("FreshMart", "freshmart", "FreshMart Groceries");
        SupplierProduct organicFruit = new SupplierProduct("Organic Fruit Basket", 49, "Grocceries", 25, freshmart);
        SupplierProduct freshMeat = new SupplierProduct("Premium Cut Meat", 79, "Grocceries", 15, freshmart);
        SupplierProduct dairyPack = new SupplierProduct("Dairy Selection Pack", 35, "Grocceries", 20, freshmart);
        freshmart.add_product(organicFruit);
        freshmart.add_product(freshMeat);
        freshmart.add_product(dairyPack);

        Supplier wholeFoods = new Supplier("WholeFoods", "wholefoods", "Whole Foods Market");
        SupplierProduct veggieBox = new SupplierProduct("Seasonal Veggie Box", 45, "Grocceries", 30, wholeFoods);
        SupplierProduct organicEggs = new SupplierProduct("Organic Free-Range Eggs", 8, "Grocceries", 100, wholeFoods);
        SupplierProduct healthySnacks = new SupplierProduct("Healthy Snacks Bundle", 25, "Grocceries", 50, wholeFoods);
        wholeFoods.add_product(veggieBox);
        wholeFoods.add_product(organicEggs);
        wholeFoods.add_product(healthySnacks);

        
        Supplier ikea = new Supplier("IKEA", "ikeaHome", "IKEA Furniture");
        SupplierProduct sofa = new SupplierProduct("KIVIK Sofa", 699, "Home & Kitchen", 10, ikea);
        SupplierProduct diningTable = new SupplierProduct("INGATORP Table", 299, "Home & Kitchen", 8, ikea);
        SupplierProduct kitchenware = new SupplierProduct("DINERA Dining Set", 89, "Home & Kitchen", 30, ikea);
        SupplierProduct bedFrame = new SupplierProduct("MALM Bed Frame", 249, "Home & Kitchen", 15, ikea);
        ikea.add_product(sofa);
        ikea.add_product(diningTable);
        ikea.add_product(kitchenware);
        ikea.add_product(bedFrame);

        Supplier homeDepot = new Supplier("HomeDepot", "homedepot", "The Home Depot");
        SupplierProduct toolSet = new SupplierProduct("Power Tool Set", 299, "Home & Kitchen", 20, homeDepot);
        SupplierProduct paintKit = new SupplierProduct("Interior Paint Kit", 89, "Home & Kitchen", 40, homeDepot);
        SupplierProduct garden = new SupplierProduct("Garden Tool Set", 149, "Home & Kitchen", 25, homeDepot);
        homeDepot.add_product(toolSet);
        homeDepot.add_product(paintKit);
        homeDepot.add_product(garden);

       
        Supplier hm = new Supplier("H&M", "handm", "H&M Fashion");
        SupplierProduct winterCoat = new SupplierProduct("Winter Puffer Coat", 89, "Clothing & Fashion", 25, hm);
        SupplierProduct casualShirt = new SupplierProduct("Cotton Basic Shirt", 29, "Clothing & Fashion", 50, hm);
        SupplierProduct denimJeans = new SupplierProduct("Slim Fit Denim", 59, "Clothing & Fashion", 35, hm);
        hm.add_product(winterCoat);
        hm.add_product(casualShirt);
        hm.add_product(denimJeans);

        Supplier uniqlo = new Supplier("Uniqlo", "uniqlo", "Uniqlo Co., Ltd.");
        SupplierProduct heattech = new SupplierProduct("HEATTECH Thermal", 29, "Clothing & Fashion", 60, uniqlo);
        SupplierProduct airism = new SupplierProduct("AIRism T-Shirt", 19, "Clothing & Fashion", 80, uniqlo);
        SupplierProduct downJacket = new SupplierProduct("Ultra Light Down Jacket", 79, "Clothing & Fashion", 40, uniqlo);
        uniqlo.add_product(heattech);
        uniqlo.add_product(airism);
        uniqlo.add_product(downJacket);

        // Adding some items to customer carts
        CustomerProduct c1Item1 = new CustomerProduct(samsungPhone);
        CustomerProduct c1Item2 = new CustomerProduct(nikeTshirt);
        c1.getOrder().getMyCart().cartItems.add(c1Item1);
        c1.getOrder().getMyCart().cartItems.add(c1Item2);

        CustomerProduct c2Item1 = new CustomerProduct(samsungTablet);
        CustomerProduct c2Item2 = new CustomerProduct(adidasBoots);
        c2.getOrder().getMyCart().cartItems.add(c2Item1);
        c2.getOrder().getMyCart().cartItems.add(c2Item2);

        CustomerProduct c3Item1 = new CustomerProduct(nikeShoes);
        CustomerProduct c3Item2 = new CustomerProduct(freshMeat);
        c3.getOrder().getMyCart().cartItems.add(c3Item1);
        c3.getOrder().getMyCart().cartItems.add(c3Item2);

        Database.users.add(c1);
        Database.users.add(c2);
        Database.users.add(c3);
        Database.users.add(c4);
        Database.users.add(c5);

        Database.suppliers.add(samsung);
        Database.suppliers.add(apple);
        Database.suppliers.add(nike);
        Database.suppliers.add(adidas);
        Database.suppliers.add(freshmart);
        Database.suppliers.add(wholeFoods);
        Database.suppliers.add(ikea);
        Database.suppliers.add(homeDepot);
        Database.suppliers.add(hm);
        Database.suppliers.add(uniqlo);
        c1.getOrder().getMyCart().cartItems.clear(); // Clear existing cart first
        CustomerProduct amirItem1 = new CustomerProduct(samsungPhone);
        CustomerProduct amirItem2 = new CustomerProduct(nikeTshirt);
        CustomerProduct amirItem3 = new CustomerProduct(heattech);
        c1.getOrder().getMyCart().cartItems.add(amirItem1);
        c1.getOrder().getMyCart().cartItems.add(amirItem2);
        c1.getOrder().getMyCart().cartItems.add(amirItem3);
        Database.orders.add(c1.getOrder());

        CustomerProduct sarahItem1 = new CustomerProduct(iPhone);
        CustomerProduct sarahItem2 = new CustomerProduct(nikeShoes);
        CustomerProduct sarahItem3 = new CustomerProduct(adidasTracksuit);
        c2.getOrder().getMyCart().cartItems.add(sarahItem1);
        c2.getOrder().getMyCart().cartItems.add(sarahItem2);
        c2.getOrder().getMyCart().cartItems.add(sarahItem3);
        Database.orders.add(c2.getOrder());

        CustomerProduct omarItem1 = new CustomerProduct(nikeJacket);
        CustomerProduct omarItem2 = new CustomerProduct(organicFruit);
        CustomerProduct omarItem3 = new CustomerProduct(adidasBall);
        c3.getOrder().getMyCart().cartItems.add(omarItem1);
        c3.getOrder().getMyCart().cartItems.add(omarItem2);
        c3.getOrder().getMyCart().cartItems.add(omarItem3);
        Database.orders.add(c3.getOrder());

        CustomerProduct laylaItem1 = new CustomerProduct(kitchenware);
        CustomerProduct laylaItem2 = new CustomerProduct(dairyPack);
        CustomerProduct laylaItem3 = new CustomerProduct(veggieBox);
        c4.getOrder().getMyCart().cartItems.add(laylaItem1);
        c4.getOrder().getMyCart().cartItems.add(laylaItem2);
        c4.getOrder().getMyCart().cartItems.add(laylaItem3);
        Database.orders.add(c4.getOrder());

        CustomerProduct yusufItem1 = new CustomerProduct(casualShirt);
        CustomerProduct yusufItem2 = new CustomerProduct(downJacket);
        CustomerProduct yusufItem3 = new CustomerProduct(samsungBuds);
        c5.getOrder().getMyCart().cartItems.add(yusufItem1);
        c5.getOrder().getMyCart().cartItems.add(yusufItem2);
        c5.getOrder().getMyCart().cartItems.add(yusufItem3);
        Database.orders.add(c5.getOrder());
        Admin Ceo = new Admin("beso","beso",10,10,2002,"Ceo","9-12");
        Database.admins.add(Ceo); 

        Welcome();

    }
    //Login... (Choice of admin or customer )
    //SignUp (Page either for supplier or customer)

    // private void showProfile() {
    //     try {
    //         FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/myProfile.fxml"));
    //         Pane root = loader.load();
    //         myProfile profileController = loader.getController();
    //         profileController.setUser(c1); 
    //         profileController.populateFields();
    //         Stage profileStage = new Stage();
    //         profileStage.setScene(new Scene(root));
    //         profileStage.setTitle("My Profile");
    //         profileStage.show();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    // private void CustomerDash(){
    //     try {
    //         FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/custfxml.fxml"));
    //         Pane root = loader.load();
    //         Stage profileStage = new Stage();
    //         profileStage.setScene(new Scene(root));
    //         profileStage.setTitle("Dashboard");
    //         profileStage.show();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }


    // }
    private void viewProducts() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MainScene.fxml"));
        Pane root = loader.load();
        Stage profileStage = new Stage();
        profileStage.setScene(new Scene(root));
        profileStage.setTitle("Products");
        profileStage.show();

    }
    private void Login() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
        AnchorPane root = loader.load();
        Stage profileStage = new Stage();
        profileStage.setScene(new Scene(root));
        profileStage.setTitle("Sign Up");
        profileStage.show();

    }
    private void Welcome() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/welcomePage.fxml"));
        AnchorPane root = loader.load();
        Stage profileStage = new Stage();
        profileStage.setScene(new Scene(root));
        profileStage.setTitle("Welcome");
        profileStage.show();

    }
    private void myCart() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/myCart.fxml"));
        Pane root = loader.load();
        Stage profileStage = new Stage();
        profileStage.setScene(new Scene(root));
        profileStage.setTitle("Sign Up");
        profileStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
