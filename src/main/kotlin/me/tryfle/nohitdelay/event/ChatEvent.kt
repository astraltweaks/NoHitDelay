package me.tryfle.nohitdelay.event

import net.weavemc.api.event.CancellableEvent

class ChatEvent(val message: String) : CancellableEvent()