plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

group = "com.tungnk123"
version = "0.0.1"

repositories {
    mavenCentral()
}

application {
    mainClass = "com.tungnk123.ApplicationKt"
}

ktor {
    development = true
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.default.headers)
    implementation(libs.ktor.server.compression)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.call.logging)

    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.partial.content)
    implementation(libs.ktor.server.forwarded.header)
//    implementation(libs.ktor.server.x.forwarded.header)
    implementation(libs.ktor.server.conditional.headers)
    implementation(libs.ktor.server.auto.head.response)
    implementation(libs.ktor.server.rate.limit)
    implementation(libs.ktor.server.resources)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.encoding)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.logback.classic)

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.ktor.client.mock)
    testImplementation(libs.kotlin.test.junit)
}