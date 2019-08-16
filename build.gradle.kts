import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetPreset

plugins {
    kotlin("multiplatform") version "1.3.21"
}

repositories {
    mavenCentral()
}

kotlin {
    presets.withType<KotlinNativeTargetPreset>().filter { it.name == "macosX64" || it.name == "linuxX64" }.forEach {
        targetFromPreset(it) {
            compilations.getByName("main") {
                val interop by cinterops.creating {
                    defFile(project.file("src/nativeInterop/cinterop/libui.def"))
                }

                binaries {
                    executable()
                }
            }
        }
    }

    sourceSets {
        val macosX64Main by getting {
            kotlin.srcDir("src/nativeMain/kotlin")
        }
        val linuxX64Main by getting {
            kotlin.srcDir("src/nativeMain/kotlin")
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "5.4.1"
    distributionType = Wrapper.DistributionType.ALL
}
