package bean.vanilla.casinosim.Model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SlotsWheels {
    public List<Image> slotImages = new ArrayList<>();
    private final String imageDirectoryPath = "src/main/resources/CasinoAssets/Slots/";

    public List<Image> fillWheel() throws FileNotFoundException {
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Banana.png")));
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Bell.png")));
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Cherry.png")));
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Lemon.png")));
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Melon.png")));
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Orange.png")));
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Plum.png")));
        slotImages.add(new Image(new FileInputStream(imageDirectoryPath + "Wheel - Seven.png")));
        return slotImages;
    }


}
