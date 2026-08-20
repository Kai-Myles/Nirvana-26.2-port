val mc_version: String by extra
val forge_config_port_version: String by extra
val neoforge_version: String by extra

plugins {
    id("com.possible-triangle.common")
}

dependencies {
    // NeoForge 26.2 is needed only for the NeoForge-specific/common bridge APIs.
    compileOnly("net.neoforged:neoforge:$neoforge_version")

    modCompileOnly(libs.jei.common.api)
    modCompileOnly(libs.registrate)
}

sourceSets {
    named("main") {
        java {
            exclude("galena/nirvana/config/ForgeClientConfig.java")
            exclude("galena/nirvana/config/ForgeCommonConfig.java")
        }
    }
}
