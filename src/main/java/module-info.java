module com.example.sortirovki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sortirovki to javafx.fxml;
    exports com.example.sortirovki;
}