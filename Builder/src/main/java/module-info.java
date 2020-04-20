module Builder {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
      requires itextpdf;

    opens com.seemantshekhar to javafx.fxml;
            exports com.seemantshekhar;
}