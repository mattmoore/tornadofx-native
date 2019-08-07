plugins {
    kotlin("multiplatform") version "1.3.21"
}

repositories {
    mavenCentral()
}

kotlin {
    macosX64("native") {
        val main by compilations.getting
        val interop by main.cinterops.creating {
            defFile(project.file("src/nativeInterop/cinterop/libui.def"))
        }

        binaries {
            executable()
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "5.4.1"
    distributionType = Wrapper.DistributionType.ALL
}
