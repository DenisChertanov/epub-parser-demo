plugins {
    kotlin("jvm") version "2.1.20"
    application
}

group = "ru.dchertanov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.positiondev.epublib:epublib-core:3.1")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("ru.dchertanov.MainKt")
}

kotlin {
    jvmToolchain(21)
}