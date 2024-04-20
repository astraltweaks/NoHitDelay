package me.tryfle.nohitdelay.listener

import me.tryfle.nohitdelay.Main
import me.tryfle.nohitdelay.event.ChatEvent
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import net.weavemc.api.event.SubscribeEvent

class ChatListener {

    @SubscribeEvent
    fun onChat(e: ChatEvent) {
        if (e.message == "/nohitdelay") {
            e.cancelled = true
            Main.toggled = !Main.toggled
            Minecraft.getMinecraft()?.thePlayer?.addChatMessage(ChatComponentText("${EnumChatFormatting.LIGHT_PURPLE} Toggled NoHitDelay " + if (Main.toggled) "on." else "off."))
        }
    }
}