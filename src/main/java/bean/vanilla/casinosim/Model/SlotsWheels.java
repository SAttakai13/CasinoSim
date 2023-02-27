package bean.vanilla.casinosim.Model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class SlotsWheels {

    public List<Image> slotImages = new ArrayList<>();

    public List<Image> fillWheel(){
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Banana.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Bars.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Bell.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Cherry.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Lemon.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Melon.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Orange.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Plum.png"));
        slotImages.add(new Image("src/main/resources/CasinoAssets/Slots/Wheel - Seven.png"));

        return slotImages;
    }

    public List<Image> RandomImages(){
        for (int i = 0; i < slotImages.size(); i++){
            slotImages.get(i);
        }
        return null;
    }




}
