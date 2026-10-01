plugins {
    java
    id("io.qameta.allure") version "2.12.0"
}

group = "com.smartshop.finalproject"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // JUnit
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Selenide (UI)
    testImplementation("com.codeborne:selenide:7.5.0")

    // Rest Assured (API)
    testImplementation("io.rest-assured:rest-assured:5.5.6")

    // AssertJ
    testImplementation("org.assertj:assertj-core:3.27.7")

    // Allure
    testImplementation("io.qameta.allure:allure-junit5:2.27.0")
    testImplementation("io.qameta.allure:allure-selenide:2.27.0")
    testImplementation("io.qameta.allure:allure-rest-assured:2.27.0")
}

tasks.test {
    useJUnitPlatform()
}

// Smoke API
tasks.register<Test>("smokeApi") {
    useJUnitPlatform {
        includeTags("smokeApi")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
}

// Smoke UI
tasks.register<Test>("smokeUi") {
    useJUnitPlatform {
        includeTags("smokeUi")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
}

// Общая smoke-задача
tasks.register("smokeAll") {
    group = "verification"
    description = "Run all smoke tests (API + UI)"
    dependsOn("smokeApi", "smokeUi")
}