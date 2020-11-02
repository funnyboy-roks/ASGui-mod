package com.funnyboyroks.as_gui;

import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class ASFunctions {
    public static void as_trigger(int num, net.minecraft.client.MinecraftClient client) {
        client.player.sendChatMessage("/trigger as_trigger set " + num);

    }
    public static void addYesNoToggle(String translateKey, WGridPanel root, net.minecraft.client.MinecraftClient MinecraftClient, int yes, int no, int x, int y){
        WLabel label = new WLabel(new TranslatableText(translateKey));
        label.setHorizontalAlignment(HorizontalAlignment.CENTER);

        WButton buttonYes = new WButton(new TranslatableText("gui.as_gui.setting.yes"));
        buttonYes.setOnClick(() -> {
            ASFunctions.as_trigger(yes, MinecraftClient);
        });

        WButton buttonNo = new WButton(new TranslatableText("gui.as_gui.setting.no"));
        buttonNo.setOnClick(() -> {
            ASFunctions.as_trigger(no, MinecraftClient);
        });

        root.add(label, x, y, 6, 1);
        root.add(buttonYes, x+1, y+1, 2, 1);
        root.add(buttonNo , x+3, y+1, 2, 1);
    }
    public static void addYesNoToggle(String translateKey, WGridPanel root, net.minecraft.client.MinecraftClient MinecraftClient, String commandYes, String commandNo, int x, int y){
        WLabel label = new WLabel(new TranslatableText(translateKey));
        label.setHorizontalAlignment(HorizontalAlignment.CENTER);

        WButton buttonYes = new WButton(new TranslatableText("gui.as_gui.setting.yes"));
        buttonYes.setOnClick(() -> {
            MinecraftClient.player.sendChatMessage(commandYes);
        });

        WButton buttonNo = new WButton(new TranslatableText("gui.as_gui.setting.no"));
        buttonNo.setOnClick(() -> {
            MinecraftClient.player.sendChatMessage(commandNo);
        });

        root.add(label, x, y, 6, 1);
        root.add(buttonYes, x+1, y+1, 2, 1);
        root.add(buttonNo , x+3, y+1, 2, 1);
    }
    public static void rotationButtons(WGridPanel root, net.minecraft.client.MinecraftClient MinecraftClient, int x, int y){
        String[] degs = {"45", "15", "5", "1"};
        int[] vals    = {120 , 121 , 122, 123};
        for(int i = 0; i < degs.length; i++){
            WButton b = new WButton(new LiteralText(degs[i] + "°"));
            int finalI = i;
            b.setOnClick(() -> {
                ASFunctions.as_trigger(vals[finalI], MinecraftClient);
            });
            root.add(b, x + 2*i, y, 2, 1);
        }
    }
}
