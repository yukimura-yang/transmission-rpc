import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    kotlin("jvm") version "1.5.21"
    `maven-publish`
}

group = "moe.gkd"
version = "0.0.2"

java.sourceCompatibility = JavaVersion.VERSION_14

repositories {
    maven(url = "https://maven.aliyun.com/repository/central")
    google()
}

val retrofit_version = "2.9.0"
val okhttp_version = "4.9.1"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    api("com.squareup.retrofit2:retrofit:${retrofit_version}")
    api("com.squareup.retrofit2:converter-gson:${retrofit_version}")
    api("com.squareup.okhttp3:okhttp:${okhttp_version}")
    api("com.squareup.okhttp3:logging-interceptor:${okhttp_version}")
    api("com.google.code.gson:gson:2.8.7")
    api("com.google.guava:guava:30.1.1-jre")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

publishing {
    val properties = Properties().apply {
        load(File("sign.properties").reader())
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/yukimura-yang/transmission-rpc")
            credentials {
                username = properties.getProperty("username")
                password = properties.getProperty("token")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
