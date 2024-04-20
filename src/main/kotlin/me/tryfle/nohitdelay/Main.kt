package me.tryfle.nohitdelay

import me.tryfle.nohitdelay.event.InitEvent
import me.tryfle.nohitdelay.listener.ChatListener
import net.weavemc.api.ModInitializer
import net.weavemc.api.event.EventBus
import java.lang.instrument.Instrumentation

class Main : ModInitializer {

    override fun preInit(inst: Instrumentation) {
        EventBus.subscribe(InitEvent::class.java) {
            init()
        }
    }

    private fun init() {
        EventBus.subscribe(ChatListener())
    }

    companion object {
        var toggled = true
    }
}