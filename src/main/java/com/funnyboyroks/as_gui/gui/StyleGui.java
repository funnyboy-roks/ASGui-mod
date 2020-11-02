package com.funnyboyroks.as_gui.gui;

import com.funnyboyroks.as_gui.*;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.*;
import net.minecraft.text.TranslatableText;

public class StyleGui extends LightweightGuiDescription{
    public StyleGui(net.minecraft.client.MinecraftClient MinecraftClient) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);

        WLabel title = new WLabel(new TranslatableText("gui.as_gui.styles"), 0x333333);
        title.setHorizontalAlignment(HorizontalAlignment.CENTER);
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title, 0, 0, 20, 1);



        /* X = 6i +1 */
        ASFunctions.addYesNoToggle("gui.as_gui.styles.basePlate"   , root, MinecraftClient, 1 , 2 , 1 , 3);  // Base Plate
        ASFunctions.addYesNoToggle("gui.as_gui.styles.showArms"    , root, MinecraftClient, 3 , 4 , 7 , 3); // Show Arms
        ASFunctions.addYesNoToggle("gui.as_gui.styles.smallStand"  , root, MinecraftClient, 5 , 6 , 13, 3); // Small Stand
        ASFunctions.addYesNoToggle("gui.as_gui.styles.applyGravity", root, MinecraftClient, 7 , 8 , 1 , 7); // Apply Gravity
        ASFunctions.addYesNoToggle("gui.as_gui.styles.visible"     , root, MinecraftClient, 9 , 10, 7 , 7); // Visible
        ASFunctions.addYesNoToggle("gui.as_gui.styles.displayName" , root, MinecraftClient, 11, 12, 13, 7); // Display Name



//        for(int i = 0; i < mainButtons.length; ++i){
//            int x = i % 4;
//            int y = i / 4;
//            root.add(mainButtons[i], 5*x + 1, 3 + y*3, 4, 1);
//        }

//        for(int x = 0; x < 21; ++x){
//            for(int y = 0; y < 13; ++y){
//                WLabel p = new WLabel(new LiteralText("."), 0);
//                root.add(p, x, y);
//            }
//        }
        WButton homeButton = new WButton(new TranslatableText("gui.as_gui.home"));
        homeButton.setOnClick(() -> {
            net.minecraft.client.MinecraftClient.getInstance().openScreen(new AS_Screen(new MainGui(MinecraftClient)));
        });
        root.add(homeButton, 0, 0, 2, 1);

        root.validate(this);
    }

}
