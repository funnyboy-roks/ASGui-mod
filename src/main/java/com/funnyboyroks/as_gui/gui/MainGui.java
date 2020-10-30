package com.funnyboyroks.as_gui.gui;


import com.funnyboyroks.as_gui.AS_Screen;
import com.funnyboyroks.as_gui.Functions;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import javax.swing.*;

public class MainGui extends LightweightGuiDescription {
    public MainGui(net.minecraft.client.MinecraftClient MinecraftClient) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);

//        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/redstone.png"));
//        root.add(icon, 0, 2, 1, 1);
        WLabel title = new WLabel(new LiteralText("Armour Stand GUI"), 0x333333);
        title.setHorizontalAlignment(HorizontalAlignment.CENTER);
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title, 0, 0, 21, 1);

        WButton[] mainButtons = new WButton[6];

        mainButtons[0] = new WButton(new TranslatableText("gui.as_gui.styles"));
        mainButtons[0].setOnClick(() -> {
            // TODO: Switch to styles GUI
//            MinecraftClient.player.sendChatMessage("/say styles");
//            Functions.trigger(10, MinecraftClient);
            net.minecraft.client.MinecraftClient.getInstance().openScreen(new AS_Screen(new StyleGui(MinecraftClient)));
        });

        mainButtons[1] = new WButton(new TranslatableText("gui.as_gui.nudge"));
        mainButtons[1].setOnClick(() -> {
            // TODO: Switch to new Nudge GUI
            MinecraftClient.player.sendChatMessage("/say nudge");
        });

        mainButtons[2] = new WButton(new TranslatableText("gui.as_gui.rotation"));
        mainButtons[2].setOnClick(() -> {
            // TODO: Switch to new Rotation GUI
            MinecraftClient.player.sendChatMessage("/say rotation");
        });

        mainButtons[3] = new WButton(new TranslatableText("gui.as_gui.pointing"));
        mainButtons[3].setOnClick(() -> {
            // TODO: Switch to Pointing GUI
            MinecraftClient.player.sendChatMessage("/say Pointing");
        });

        mainButtons[4] = new WButton(new TranslatableText("gui.as_gui.presets"));
        mainButtons[4].setOnClick(() -> {
            // TODO: Switch to Presets GUI
            MinecraftClient.player.sendChatMessage("/say Presets");
        });

        mainButtons[5] = new WButton(new TranslatableText("gui.as_gui.poseAdjust"));
        mainButtons[5].setOnClick(() -> {
            // TODO: Switch to Pose Adjust GUI
            MinecraftClient.player.sendChatMessage("/say Pose Adjust");
        });


//        root.add(mainButtons[1], )
//        root.add(mainButtons[0], 0, 3, 4, 1);
        for(int i = 0; i < mainButtons.length; ++i){
            int x = i % 4;
            int y = i / 4;
            root.add(mainButtons[i], 5*x + 1, 3 + y*3, 4, 1);
        }

        root.validate(this);
    }
}
