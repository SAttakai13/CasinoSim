package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class WithdrawController implements Initializable {

    @FXML
    private Text QuoteText;
    public static Text static_QuoteText;

    private static String quote = "";
    public static final String[] QuoteList = new String[] {
            "\"You gotta know when to hold 'em...and know when to fold 'em.\"\n - Kenny Rogers",
            "\"Sometimes you eat the bear, and sometimes the bear…well, he eats you.\"\n - The Stranger",
            "\"Never tell me the odds.\"\n - Han Solo",
            "\"You’ve got to ask yourself one question. ‘Do I feel lucky?’ Well, do ya, punk?\"\n - Dirty Harry",
            "\"Even if the wheel is straight…and it ain’t…the house got 8% the best of it.\"\n - Latigo Smith",
            "\"Truth is, the game was rigged from the start.\"\n - Benny",
            "\"It feels like...like our luck has turned...you know...and it ain't turning back.\"\n - Arthur Morgan",
            "\"It's wanting that gets so many folk in trouble...\"\n - John Marston",
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_QuoteText = QuoteText;
    }



    public static void SetQuote() {
        quote = QuoteList[CasinoApplication.rand.nextInt(QuoteList.length)];
        static_QuoteText.setText(quote);
    }

    public void WithdrawClicked(MouseEvent event) {
        CasinoApplication.player.GetBalance().SetBalance(1000.0);
        CasinoApplication.setRoot("TitleScreen");
    }
}
