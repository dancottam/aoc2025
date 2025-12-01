plugins {
    kotlin("jvm") version "2.2.21"
}

dependencies {
    val junitVersion = "6.0.1"
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks {
    wrapper {
        gradleVersion = "9.2.1"
    }
    test {
        useJUnitPlatform()
    }
}
