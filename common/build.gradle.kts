val mc_version: String by extra
val forge_config_port_version: String by extra
val neoforge_version: String by extra

plugins {
    id("com.possible-triangle.common")
}

dependencies {
    // NeoForge 26.2 is no longer pulled transitively by NeoForm/Registrate.
    // The common sources still use a small amount of NeoForge API (notably
    // Registrate's data providers and registry holders), so expose it only
    // at compile time. The Fabric jar does not package this dependency.
    compileOnly("net.neoforged:neoforge:$neoforge_version")

    modCompileOnly(libs.jei.common.api)
    modCompileOnly(libs.registrate)
}

sourceSets {
    named("main") {
        java {
            exclude("galena/nirvana/config/ForgeClientConfig.java")
            exclude("galena/nirvana/config/ForgeCommonConfig.java")
            exclude("galena/nirvana/world/item/ArmorLike.java")
        }
    }
}
