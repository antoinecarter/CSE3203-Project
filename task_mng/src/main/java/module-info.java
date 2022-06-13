module nexus.task_mng {
    requires javafx.controls;
    requires javafx.fxml;

    opens nexus.task_mng to javafx.fxml;
    exports nexus.task_mng;
}
