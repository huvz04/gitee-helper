plugins {
    val kotlinVersion = "1.8.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.16.0"

}

group = rootProject.name
version = "0.3.0"

repositories {
    mavenCentral()
    if (System.getenv("CI")?.toBoolean() != true) {
        maven("https://maven.aliyun.com/repository/public") // 阿里云国内代理仓库
    }
}
mirai {
    jvmTarget = JavaVersion.VERSION_17
}
dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}