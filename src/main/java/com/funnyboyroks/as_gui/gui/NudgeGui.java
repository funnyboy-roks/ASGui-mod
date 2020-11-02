package com.funnyboyroks.as_gui.gui;

import com.funnyboyroks.as_gui.ASFunctions;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class NudgeGui extends LightweightGuiDescription {
    private String facing = "";

    public NudgeGui(MinecraftClient MinecraftClient) {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);

        WLabel title = new WLabel(new TranslatableText("gui.as_gui.nudge"), 0x333333);
        title.setHorizontalAlignment(HorizontalAlignment.CENTER);
        title.setVerticalAlignment(VerticalAlignment.TOP);
        root.add(title, 0, 0, 20, 1);

        this.facing = MinecraftClient.player.getHorizontalFacing().asString();
        nudgeElement(root, MinecraftClient, "X:", 2, 3, new int[]{40, 101, 102, 103, 104, 43}, false);
        nudgeElement(root, MinecraftClient, "Y:", 2, 4, new int[]{44, 105, 106, 107, 108, 47}, false);
        nudgeElement(root, MinecraftClient, "Z:", 2, 5, new int[]{48, 109, 110, 111, 112, 51}, false);

        int[] facingVals = new int[6];
        switch (this.facing) {
            case "north":
                facingVals = new int[]{51, 112, 111, 110, 109, 48};
                break;
            case "south":
                facingVals = new int[]{48, 109, 110, 111, 112, 51};
                break;
            case "east":
                facingVals = new int[]{40, 101, 102, 103, 104, 43};
                break;
            case "west":
                facingVals = new int[]{43, 104, 103, 102, 101, 40};
                break;
        }
        nudgeElement(root, MinecraftClient, "gui.as_gui.nudge.facing", 2, 8, facingVals, true);


//        nudgeAmounts(root, MinecraftClient, 0, 10, new int[]{40, 101, 102, 103, 104, 43});
    }

    private void nudgeAmounts(WGridPanel root, MinecraftClient MinecraftClient, int x, int y, int[] values, boolean wide) {
        String[] strs = {"-8", "-3", "-1", "+1", "+3", "+8"};
        for (int i = 0; i < strs.length; ++i) {
            int finalI = i;
            WButton button = new WButton(new LiteralText(strs[i]));
            button.setOnClick(() -> {
                ASFunctions.as_trigger(values[finalI], MinecraftClient);
            });
            root.add(button, x + i, y, 1, 1);
        }
    }

    private void nudgeElement(WGridPanel root, MinecraftClient MinecraftClient, String labelKey, int x, int y, int[] values, boolean wide) {
        WLabel label = new WLabel(new TranslatableText(labelKey), 0x333333);
        nudgeAmounts(root, MinecraftClient, x + (wide ? 2 : 1), y, values, wide);
        root.add(label, x, y, 1, 1);
    }
}
