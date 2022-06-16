module nexus.task_mng {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.se;
    requires org.postgresql.jdbc;
    requires java.sql;
    opens nexus.task_mng to javafx.fxml;
    exports nexus.task_mng;
}
