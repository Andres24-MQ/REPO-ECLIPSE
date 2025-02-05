package FirstProyect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

 @Override
    public void start(Stage primaryStage) {
        // Crear controles
        Label welcomeLabel = new Label("¡Bienvenido a la Aplicación JavaFX!");
        Label nameLabel = new Label("Ingresa tu nombre:");
        TextField nameField = new TextField();
        nameField.maxWidth(250);
        
        
        Button greetButton = new Button("Saludar");
        greetButton.setPrefSize(250, 30);
        Label greetingMessage = new Label();

        // Manejar el evento del botón
        greetButton.setOnAction(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                greetingMessage.setText("Hola, " + name + "!");
            } else {
                greetingMessage.setText("Por favor, ingresa tu nombre.");
            }
        });

               // Usar un HBox para el nombre y la etiqueta para asegurarse de que el TextField no se expanda
        HBox nameBox = new HBox(10, nameLabel, nameField);
        nameBox.setAlignment(Pos.CENTER);
        // Crear el layout
        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(welcomeLabel, nameLabel, nameField, greetButton, greetingMessage);

        // Crear la escena
        Scene scene = new Scene(mainLayout, 600, 300);
        primaryStage.setTitle("Aplicación JavaFX Avanzada");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}