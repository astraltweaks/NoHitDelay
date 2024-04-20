package me.tryfle.nohitdelay.mixin;

import me.tryfle.nohitdelay.Main;
import me.tryfle.nohitdelay.event.InitEvent;
import net.minecraft.client.Minecraft;
import net.weavemc.api.event.EventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Shadow
    private int leftClickCounter;

    @Inject(method = "clickMouse", at = @At("HEAD"))
    public void onClickMouse(CallbackInfo ci) {
        if (Main.Companion.getToggled()) {
            leftClickCounter = 0;
        }
    }

    @Inject(method = "startGame", at = @At("TAIL"))
    public void onStartGame(CallbackInfo ci) {
        EventBus.postEvent(new InitEvent());
    }
}