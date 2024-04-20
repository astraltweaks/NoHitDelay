package me.tryfle.nohitdelay.mixin;

import me.tryfle.nohitdelay.event.ChatEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.weavemc.api.event.EventBus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class EntityPlayerSPMixin {

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    public void onChatMessage(String message, CallbackInfo ci) {
        ChatEvent chatEvent = new ChatEvent(message);
        EventBus.postEvent(chatEvent);
        if (chatEvent.isCancelled()) ci.cancel();
    }
}
