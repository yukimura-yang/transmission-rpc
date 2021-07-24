import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
}

group = "moe.gkd"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_14

repositories {
    maven(url = "https://maven.aliyun.com/repository/central")
}

val retrofit_version = "2.9.0"
val okhttp_version = "4.9.1"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    implementation("com.squareup.retrofit2:retrofit:${retrofit_version}")
    implementation("com.squareup.retrofit2:converter-gson:${retrofit_version}")
    implementation("com.squareup.okhttp3:okhttp:${okhttp_version}")
    implementation("com.squareup.okhttp3:logging-interceptor:${okhttp_version}")
    implementation("com.google.code.gson:gson:2.8.7")
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
