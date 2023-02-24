package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class WithdrawController implements Initializable {

    @FXML
    private Text QuoteText;
    public static Text static_QuoteText;

    private static String quote = "";
    public static final String[] QuoteList = new String[] {
            "",
            "",
            "",
            "",
            "",
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_QuoteText = QuoteText;
    }



    public static void SetQuote() {
        quote = QuoteList[CasinoApplication.rand.nextInt(QuoteList.length)];
        static_QuoteText.setText(quote);
    }
}
