plugins {
    kotlin("jvm") version "1.5.10"
    java
}

sourceSets {
    main {
        java {
            srcDir("src")
        }
    }
}

dependencies {
//    implementation(kotlin("stdlib-jdk11"))
}
repositories {
    mavenCentral()
}
