package Controllers;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Customer;
import models.CustomerProduct;
import models.Database;
import models.Supplier;
import models.SupplierProduct;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class ECommerceController {
    private  Customer c1;
    // FXML injected elements
    @FXML private FlowPane productGrid;
    @FXML private TextField searchField;
    @FXML private Button buttcart;
    @FXML private Button butt1; // Electronics
    @FXML private Button butt3; // Men's Fashion
    @FXML private Button butt5; // Beauty & Fragrance
    @FXML private Button butt6; // Home & Appliances
    @FXML private Button butt7; // Baby
    @FXML private Button butt8; // Toys & Games
    @FXML private Button butt9; // Sports & Outdoors
    @FXML private Button backBtn; 


    @FXML
    public void initialize() {
        c1 = (Customer)UserSession.getUser();
        searchField.setOnKeyReleased(event -> handleSearch());
        setupCategoryButtons();
        loadProducts("all");
    }

    private void setupCategoryButtons() {
        butt1.setOnAction(e -> loadProducts( "Electronics & Devices"));
        butt3.setOnAction(e -> loadProducts("Clothing & Fashion"));
        butt5.setOnAction(e -> loadProducts(    "Grocceries"));
        butt6.setOnAction(e -> loadProducts(  "Sports & Outdoors"));
        butt7.setOnAction(e -> loadProducts("Home & Kitchen"));
    }

    private void handleSearch() {
        String searchTerm = searchField.getText().toLowerCase();
        productGrid.getChildren().clear();
        for(Supplier supp : Database.suppliers){
            for(SupplierProduct prod : supp.getProducts()){
                if(prod.getName().toLowerCase().contains(searchTerm)){
                    addProductToGrid(prod);
                }
            }
        }
    }
    public void backAction(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/custfxml.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    private void loadProducts(String category) {
        productGrid.getChildren().clear();
        for(Supplier supp : Database.suppliers){
            for(SupplierProduct prod : supp.getProducts()){
                if(category.equals("all")){
                    if(prod.getStock() != 0){
                        addProductToGrid(prod);
                    }

                }
                else{
                    if(category.equals(prod.getMycat())){
                        System.out.println(prod.getMycat());
                        if(prod.getStock() != 0){
                            addProductToGrid(prod);
                        }
                    }
                }
                }
            }
        }
    

    private void addProductToGrid(SupplierProduct product) {
        VBox productCard = new VBox(5);
        productCard.getStyleClass().add("product-card");
        productCard.setMaxWidth(250);
        
        Label titleLabel = new Label(product.getName());
        titleLabel.getStyleClass().add("product-title");
        titleLabel.setWrapText(true);

        Label priceLabel = new Label(String.format("EGP %.2f", product.getPrice()));
        priceLabel.getStyleClass().add("price");

        Button addToCartBtn = new Button("Add to Cart");
        addToCartBtn.getStyleClass().add("add-to-cart-button");
        Label AddedText = new Label("");
        addToCartBtn.setOnAction(e -> {
            c1.getOrder().getMyCart().AddToCart(new CustomerProduct(product));
            AddedText.setText("Added to cart");
        }
        );
        productCard.getChildren().addAll(titleLabel, priceLabel, addToCartBtn,AddedText);
        productGrid.getChildren().add(productCard);
    }

    @FXML
    private void handleCartButton(ActionEvent event) {
        try {
            // CartController.setUser(c1);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/myCart.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
        }
    }
}