module com.xforce {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires com.calendarfx.view;

    opens com.xforce.view.fxml to javafx.fxml;
    opens com.xforce.controller to javafx.fxml;
    exports com.xforce;
}
