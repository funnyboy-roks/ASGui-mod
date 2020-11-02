package com.funnyboyroks.as_gui.gui;


import com.funnyboyroks.as_gui.ASFunctions;
import com.funnyboyroks.as_gui.AS_Screen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

import java.util.ArrayList;

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

        ASFunctions.addYesNoToggle("gui.as_gui.utilities.lock", root, MinecraftClient, 1000, 1001, 0, 11);
        ASFunctions.addYesNoToggle("gui.as_gui.utilities.marker",
                root,
                MinecraftClient,
                "/editarmourstand marker on",
                "/editarmourstand marker off",
                15,
                11);

        ArrayList<WButton> mainButtons = new ArrayList<WButton>();

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.styles")));
        mainButtons.get(0).setOnClick(() -> {
//            MinecraftClient.player.sendMessage(new TranslatableText("gui.as_gui.styles"), true);
            net.minecraft.client.MinecraftClient.getInstance().openScreen(new AS_Screen(new StyleGui(MinecraftClient)));
        });

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.nudge")));
        mainButtons.get(1).setOnClick(() -> {
            // TODO: Switch to new Nudge GUI
//            MinecraftClient.player.sendMessage(new TranslatableText("gui.as_gui.nudge"), true);
            net.minecraft.client.MinecraftClient.getInstance().openScreen(new AS_Screen(new NudgeGui(MinecraftClient)));

        });

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.rotation")));
        mainButtons.get(2).setOnClick(() -> {
            // TODO: Switch to new Rotation GUI
            MinecraftClient.player.sendChatMessage("/say rotation");
        });

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.pointing")));
        mainButtons.get(3).setOnClick(() -> {
            // TODO: Switch to Pointing GUI
            MinecraftClient.player.sendChatMessage("/say Pointing");
        });

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.presets")));
        mainButtons.get(4).setOnClick(() -> {
            // TODO: Switch to Presets GUI
            MinecraftClient.player.sendChatMessage("/say Presets");
        });

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.poseAdjust")));
        mainButtons.get(5).setOnClick(() -> {
            // TODO: Switch to Pose Adjust GUI
            MinecraftClient.player.sendChatMessage("/say Pose Adjust");
        });

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.autoAlign")));

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.swapSlots")));

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.mirrorFlip")));

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.utilities")));

        mainButtons.add(new WButton(new TranslatableText("gui.as_gui.itemFrames")));

        WButton credits = new WButton(new TranslatableText("gui.as_gui.credits"));
        credits.setOnClick(() -> {
            // TODO: Open Credits page in AS Book
        });

        root.add(credits, 18, 0, 3, 1);

        WButton openBook = new WButton(new TranslatableText("gui.as_gui.openBook"));
        openBook.setOnClick(() -> {
            MinecraftClient.player.sendChatMessage("/editarmourstand");
        });
        root.add(openBook, 0, 0, 4, 1);

        ASFunctions.rotationButtons(root, MinecraftClient, 8, 12, 1);
//        root.add(mainButtons[1], )
//        root.add(mainButtons[0], 0, 3, 4, 1);
        System.out.println("[][][][][] Size: " + mainButtons.size());
        for (int i = 0; i < mainButtons.size(); i++) {
            int x = i % 4;
            int y = i / 4;
            root.add(mainButtons.get(i), 5 * x + 1, 3 + y * 3, 4, 1);
        }


//        for(int x = 0; x < 21; ++x){
//            for(int y = 0; y < 13; ++y){
//                WLabel p = new WLabel(new LiteralText(x + "," + y), 0);
//                root.add(p, x, y, 1, 1);
//            }
//        }

        root.validate(this);
    }
}
