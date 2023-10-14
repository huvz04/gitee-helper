plugins {
    val kotlinVersion = "1.8.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.15.0"

}

group = "io.huvz.gitee"
version = "0.1.1"

repositories {
    if (System.getenv("CI")?.toBoolean() != true) {
        maven("https://maven.aliyun.com/repository/public") // 阿里云国内代理仓库
    }
    mavenCentral()
}
mirai {
    jvmTarget = JavaVersion.VERSION_17
}
dependencies {
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.14.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.14.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}