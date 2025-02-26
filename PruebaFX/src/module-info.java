/**
 * 
 */
/**
 * 
 */
module PruebaFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens p1 to javafx.fxml;
    exports p1;
}

