package com.funnyboyroks.as_gui;

import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.minecraft.text.TranslatableText;

public class Functions {
    public static void as_trigger(int num, net.minecraft.client.MinecraftClient client) {
        client.player.sendChatMessage("/trigger as_trigger set " + num);

    }
    public static void addYesNoToggle(String translateKey, WGridPanel root, net.minecraft.client.MinecraftClient MinecraftClient, int yes, int no, int x, int y){
        WLabel label = new WLabel(new TranslatableText(translateKey));
        label.setHorizontalAlignment(HorizontalAlignment.CENTER);

        WButton buttonYes = new WButton(new TranslatableText("gui.as_gui.setting.yes"));
        buttonYes.setOnClick(() -> {
            Functions.as_trigger(yes, MinecraftClient);
        });

        WButton buttonNo = new WButton(new TranslatableText("gui.as_gui.setting.no"));
        buttonNo.setOnClick(() -> {
            Functions.as_trigger(no, MinecraftClient);
        });

        root.add(label, x, y, 6, 1);
        root.add(buttonYes, x+1, y+1, 2, 1);
        root.add(buttonNo , x+3, y+1, 2, 1);
    }
}
