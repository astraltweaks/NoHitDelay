plugins {
    kotlin("jvm") version "1.9.23"
    id("net.weavemc.gradle") version "1.0.0-PRE2"
}

group = "me.tryfle"
version = "1.0"

weave {
    configure {
        name = "NoHitDelay"
        modId = "nohitdelay"
        entryPoints = listOf("me.tryfle.nohitdelay.Main")
        mixinConfigs = listOf("nhd.mixins.json")
        mcpMappings()
    }
    version("1.8.9")
}

repositories {
    mavenCentral()
    maven("https://repo.weavemc.dev/releases")
    maven("https://repo.spongepowered.org/maven")
}

dependencies {
    implementation("net.weavemc.api:common:1.0.0-PRE2")
    implementation("net.weavemc:internals:1.0.0-PRE2")
    compileOnly("org.spongepowered:mixin:0.8.5")

}

kotlin {
    jvmToolchain(8)
}