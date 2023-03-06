package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.scene.input.MouseEvent;

public class RouletteInstructionsController {
    public void Play(MouseEvent event) {
        CasinoApplication.setRoot("RouletteGameScreen");
    }

    public void Back(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }
}
