plugins {
    id("com.possible-triangle.neoforge")
}

neoforge {
    dependOn(project(":common"))
}

dependencies {
    modCompileOnly(libs.jei.common.api)
}
