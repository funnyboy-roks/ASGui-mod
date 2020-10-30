package com.funnyboyroks.as_gui;

import com.funnyboyroks.as_gui.gui.MainGui;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class ASGuiMod implements ModInitializer {
    private static KeyBinding keyBinding;
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
//        System.out.println("Hello Fabric world!");
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.as_gui.opengui", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSsp#E for mouse.
                GLFW.GLFW_KEY_B, // The keycode of the key
                "category.as_gui.keyBindings" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(keyBinding.wasPressed()){
//                System.out.println("mincraftClient class: " + minecraftClient.getClass());
                MinecraftClient.getInstance().openScreen(new AS_Screen(new MainGui(client)));
                client.player.sendMessage(new LiteralText("Opened GUI!"), false);

            }
        });

//        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
//            dispatcher.register(CommandManager.literal("asgui")
//                    .executes(context -> {
//                        System.out.println("Called foo with bar");
//                        MinecraftClient.getInstance().openScreen(new ExampleScreen(new ExampleGui(minecraftClient)));
//
//                        return 1;
//                    })
//            );
//        });



    }

}

