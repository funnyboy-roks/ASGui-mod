package com.funnyboyroks.as_gui;

import com.funnyboyroks.as_gui.gui.MainGui;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

import java.util.List;

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
            if (keyBinding.wasPressed()) {
//                System.out.println("mincraftClient class: " + minecraftClient.getClass());
                MinecraftClient.getInstance().openScreen(new AS_Screen(new MainGui(client)));
                client.player.sendMessage(new LiteralText("Opened GUI!"), false);

            }
        });

//        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
//            dispatcher.register(
//                    CommandManager.literal("asgui")
//                        .executes(context -> {
//                            ServerPlayerEntity player = context.getSource().getPlayer();
//                            System.out.println("Called foo with bar");
//                            System.out.println(context.getSource().getPlayer().getDisplayName().asString());
//                            player.teleport(player.getX() + 1, player.getY()+1, player.getZ()+1);
//                            context.getSource().getPlayer().sendMessage(new LiteralText("NoClip Toggled! Now: " + player.canFly()), false);
//                            return 1;
//
//                        })
//            );
//        });


    }

}

