//  buildSrc/src/main/kotlin/kotlin-convention.gradle.kts
plugins {
    kotlin("jvm")
}

group = "com.g2s"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}