package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.scene.input.MouseEvent;

public class PokerInstructionsController {
    public void Back(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }

    public void Play(MouseEvent event) {
        CasinoApplication.setRoot("PokerGameScreen");
    }
}
