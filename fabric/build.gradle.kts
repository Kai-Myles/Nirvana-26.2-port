plugins {
    id("com.possible-triangle.fabric")
}

fabric {
    dependOn(project(":common"))

    accessWidener()
}

dependencies {
    modInclude(libs.registrate)
    modInclude(libs.config.api.port.fabric)

    modCompileOnly(libs.jei.common.api)
    modCompileOnly(libs.jei.fabric.api)
    modCompileOnly(libs.jei.lib)

    if (!env.isCI) {
        modRuntimeOnly(libs.jei.fabric)
        modRuntimeOnly(pack.fabric.modrinth.moonlight)
        modRuntimeOnly(pack.fabric.modrinth.supplementaries)
        modRuntimeOnly(pack.fabric.modrinth.just.enough.effect.descriptions.jeed)
    }
}