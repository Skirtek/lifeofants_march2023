module com.codecool.lifeofants {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
            
                            
    opens com.codecool.lifeofants to javafx.fxml;
    exports com.codecool.lifeofants;
}