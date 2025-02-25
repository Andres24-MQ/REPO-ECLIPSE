/**
 * 
 */
/**
 * 
 */
module PruebaFX {
    requires javafx.controls;
    requires javafx.fxml;

    opens p1 to javafx.fxml;
    exports p1;
}
