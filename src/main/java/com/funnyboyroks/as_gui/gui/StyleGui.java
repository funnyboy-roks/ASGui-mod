package com.funnyboyroks.as_gui.gui;

import com.funnyboyroks.as_gui.Functions;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.minecraft.text.TranslatableText;

import static com.funnyboyroks.as_gui.Functions.addYesNoToggle;

public class StyleGui extends LightweightGuiDescription{
    public StyleGui(net.minecraft.client.MinecraftClient MinecraftClient) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        System.out.println("`root` class: " + root.getClass());

        WLabel title = new WLabel(new TranslatableText("gui.as_gui.styles"), 0x333333);
        title.setHorizontalAlignment(HorizontalAlignment.CENTER);
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title, 0, 0, 21, 1);


        /* X = 6i +1 */
        addYesNoToggle("gui.as_gui.styles.basePlate", root, MinecraftClient, 1, 2, 1, 3);  // Base Plate
        addYesNoToggle("gui.as_gui.styles.showArms", root, MinecraftClient, 1, 2, 7, 3); // Show Arms
        addYesNoToggle("gui.as_gui.styles.smallStand", root, MinecraftClient, 1, 2, 13, 3); // Small Stand
        addYesNoToggle("gui.as_gui.styles.applyGravity", root, MinecraftClient, 1, 2, 1, 7); // Apply Gravity
        addYesNoToggle("gui.as_gui.styles.visible", root, MinecraftClient, 1, 2, 7, 7); // Visible
        addYesNoToggle("gui.as_gui.styles.displayName", root, MinecraftClient, 1, 2, 13, 7); // Display Name

//        for(int i = 0; i < mainButtons.length; ++i){
//            int x = i % 4;
//            int y = i / 4;
//            root.add(mainButtons[i], 5*x + 1, 3 + y*3, 4, 1);
//        }

        root.validate(this);
    }

}
