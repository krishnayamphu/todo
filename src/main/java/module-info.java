module com.ky.todo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ky.todo to javafx.fxml;
    exports com.ky.todo;
}