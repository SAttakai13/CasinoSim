package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.scene.input.MouseEvent;

public class BlackJackInstructionsController {
    public void Play(MouseEvent event) {
        CasinoApplication.setRoot("BlackJackGameScreen");
    }

    public void Back(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }
}
