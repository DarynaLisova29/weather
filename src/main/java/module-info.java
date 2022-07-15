module com.example.weather {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.jsoup;

    opens com.example.weather to javafx.fxml;
    exports com.example.weather;
}