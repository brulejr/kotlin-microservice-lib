plugins {
    kotlin("jvm") version "1.3.72"
}

group = "io.jrb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.0")
    implementation("com.github.java-json-tools:json-patch:1.12")
    implementation("io.github.microutils:kotlin-logging:1.7.9")
    implementation("io.projectreactor:reactor-core:3.3.6.RELEASE")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.0.2.RELEASE")
    implementation("org.springframework.data:spring-data-commons:2.3.1.RELEASE")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
