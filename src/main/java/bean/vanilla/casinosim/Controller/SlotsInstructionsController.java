package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.scene.input.MouseEvent;

public class SlotsInstructionsController {
    public void Play(MouseEvent event) {
        CasinoApplication.setRoot("SlotsGameScreen");
    }

    public void Back(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }
}
