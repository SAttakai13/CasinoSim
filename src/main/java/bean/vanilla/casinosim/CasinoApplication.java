package bean.vanilla.casinosim;

import bean.vanilla.casinosim.Controller.WithdrawController;
import bean.vanilla.casinosim.Model.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Random;

public class CasinoApplication extends Application {

    public static Random rand = new Random();

    public static Player player = new Player("Player 1", 1000.0);

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("TitleScreen"), 1200, 900);
        stage.setResizable(false);
        stage.setTitle("Casino Sim");
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CasinoApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }



    public static void CheckForWithdraw() {
        if (player.GetBalance().GetBalance() > 0)
            return;

        setRoot("WithdrawScreen");
        WithdrawController.SetQuote();
    }
}