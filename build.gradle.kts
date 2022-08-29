import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21" // no-arg constructor 생성자를 자동 생성 해줌
    // kotlin("kapt") version "1.6.21" // kapt annotation processing for kotlin
    kotlin("plugin.allopen") version  "1.6.21" // kotlin 의 경우 기본이 final 이라 jpa lazy 로딩이 불가능(프록시 객체 생성 불가능)
    // 하여 allopen 플러그인 사용시 모든 엔딭티 객체에 open 을 붙여줌
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.7")
    runtimeOnly("com.h2database:h2")

//    implementation("com.querydsl:querydsl-jpa:5.0.0")
//    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
//    kapt("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

//
//    sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class){
//        kotlin.srcDir("$buildDir/generated/source/kapt/main")
//    }

    // socket io libarary
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // serialize lib
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")

    // rabbitMq lib
//    implementation("org.springframwork.boot:spring-boot-starter-amqp")
//    implementation("org.springframwork.boot:spring-boot-starter-reactor-netty")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

