package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.scene.input.MouseEvent;

public class CrapsInstructionsController {
    public void Play(MouseEvent event) {
        CasinoApplication.setRoot("CrapsGameScreen");
    }

    public void Back(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }
}
