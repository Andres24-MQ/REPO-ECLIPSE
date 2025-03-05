package p1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    private List<String> productos = new ArrayList<>();
    private double total = 0.0;
    private Label totalLabel = new Label("Total: $0.00");
    private ListView<String> productosListView = new ListView<>();
    private TextField productoTextField = new TextField();
    private TextField cantidadTextField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Punto de Venta");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label productoLabel = new Label("Producto:");
        GridPane.setConstraints(productoLabel, 0, 0);
        GridPane.setConstraints(productoTextField, 1, 0);

        Label cantidadLabel = new Label("Cantidad:");
        GridPane.setConstraints(cantidadLabel, 0, 1);
        GridPane.setConstraints(cantidadTextField, 1, 1);

        Button agregarButton = new Button("Agregar");
        GridPane.setConstraints(agregarButton, 0, 2);
        agregarButton.setOnAction(e -> agregarProducto());

        Button restarButton = new Button("Restar");
        GridPane.setConstraints(restarButton, 1, 2);
        restarButton.setOnAction(e -> restarProducto());

        GridPane.setConstraints(totalLabel, 0, 3, 2, 1);
        GridPane.setConstraints(productosListView, 0, 4, 2, 1);

        grid.getChildren().addAll(productoLabel, productoTextField, cantidadLabel, cantidadTextField,
                agregarButton, restarButton, totalLabel, productosListView);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarProducto() {
        String producto = productoTextField.getText();
        try {
            int cantidad = Integer.parseInt(cantidadTextField.getText());
            double precio = 10.0; // Precio fijo por ahora
            double subtotal = precio * cantidad;
            total += subtotal;
            productos.add(producto + " x" + cantidad + " = $" + subtotal);
            productosListView.getItems().add(producto + " x" + cantidad + " = $" + subtotal);
            totalLabel.setText("Total: $" + total);
            productoTextField.clear();
            cantidadTextField.clear();
        } catch (NumberFormatException e) {
            totalLabel.setText("Ingrese una cantidad válida.");
        }
    }

    private void restarProducto() {
        String producto = productoTextField.getText();
        try {
            int cantidad = Integer.parseInt(cantidadTextField.getText());
            double precio = 10.0; // Precio fijo por ahora
            double subtotal = precio * cantidad;
            total -= subtotal;
            productos.add("(-) " + producto + " x" + cantidad + " = $" + subtotal);
            productosListView.getItems().add("(-) " + producto + " x" + cantidad + " = $" + subtotal);
            totalLabel.setText("Total: $" + total);
            productoTextField.clear();
            cantidadTextField.clear();
        } catch (NumberFormatException e) {
            totalLabel.setText("Ingrese una cantidad válida.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}