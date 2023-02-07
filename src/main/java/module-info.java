module bean.vanilla.casinosim {
    requires javafx.controls;
    requires javafx.fxml;


    opens bean.vanilla.casinosim to javafx.fxml;
    exports bean.vanilla.casinosim;
    exports bean.vanilla.casinosim.Controller;
    opens bean.vanilla.casinosim.Controller to javafx.fxml;
}