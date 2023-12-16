plugins {
    val kotlinVersion = "1.8.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.16.0"

}

group = "io.huvz.gitee"
version = "0.1.1"

repositories {
    mavenCentral()
    if (System.getenv("CI")?.toBoolean() != true) {
        maven("https://maven.aliyun.com/repository/public") // 阿里云国内代理仓库
    }
}
mirai {
    jvmTarget = JavaVersion.VERSION_17
}
val cssversion = "2.5.1"
dependencies {

    implementation("xyz.cssxsh.mirai:mirai-selenium-plugin:${cssversion}")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
//    implementation("org.seleniumhq.selenium:selenium-java:4.14.0")
//    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver
//    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.14.0")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}