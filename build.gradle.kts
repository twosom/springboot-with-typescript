import com.github.gradle.node.npm.task.NpmTask
import com.github.gradle.node.task.NodeTask

plugins {
    // SPRING
    id("org.springframework.boot") version ("2.7.4")
    id("io.spring.dependency-management") version ("1.0.14.RELEASE")

    // JAVA
    id("java")

    // NODE_JS
    id("com.github.node-gradle.node") version ("3.4.0")
}

node {
    download.set(true)
    nodeProjectDir.set(file("${project.projectDir}/src/main/resources/static"))
}

group = "com.icloud"
version = "0.0.1-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("npmSetScript", type = NodeTask::class) {
    dependsOn("npmInstall")
    println("#####NPM_BUILD#####")
    script.set(file("${project.projectDir}/src/main/resources/static/package.json"))
}


tasks.register("npmRunBuild", type = NpmTask::class) {
    dependsOn("npmSetScript")
    args.set(listOf("run", "build"))
}

tasks.first { it.name == "npmInstall" }.doFirst {
    println("#####NPM_INSTALL#####")
}

val buildScript: Task = tasks.first { it.name == "build" }
buildScript.doFirst {
    println("#####HELLO######")
}

buildScript.dependsOn("npmRunBuild")



