plugins {
    java
    id(Plugins.springBoot) version Versions.springBoot
}

group = "com.inventale.project"

tasks.getByName<Jar>("bootJar") {
    archiveFileName.set("backend-blocking-app.jar")
}.finalizedBy("copyConfigsNearJar") //copy /config near build jars to be used in docker

dependencies {
    annotationProcessor(Libs.lombok)
    compileOnly(Libs.lombok)

    implementation(project(":common"))

    implementation(Libs.springBootStarterActuator)
    implementation(Libs.springBootStarterWeb)
    implementation(Libs.springBootStarterWebflux)
    implementation(Libs.springBootStarterAop)
    implementation(Libs.gson)

    testAnnotationProcessor(Libs.lombok)
    testImplementation(Libs.lombok)
    testImplementation(Libs.junit)
    testImplementation(Libs.junitEngine)
    testImplementation(Libs.junitParams)
    testImplementation(Libs.mockito)
    testImplementation(Libs.springBootStarterTest)
}

tasks.test {
    useJUnitPlatform()
    // to use properties from /config in tests
    workingDir = rootDir
}