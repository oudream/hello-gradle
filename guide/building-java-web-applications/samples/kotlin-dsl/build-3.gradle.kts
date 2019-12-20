plugins {
    war
    id("org.akhikhl.gretty") version "1.4.2" // <1>
}

repositories {
    jcenter()
}

// tag::configure-gretty[]
gretty {
    integrationTestTask = "test"  // <1>
}
// end::configure-gretty[]

// tag::add-selenium[]
dependencies {
    providedCompile("javax.servlet:javax.servlet-api:3.1.0")
    testCompile("junit:junit:4.12")
    testCompile("org.mockito:mockito-core:2.7.19")
    testCompile("io.github.bonigarcia:webdrivermanager:1.6.1") // <2>
    testCompile("org.seleniumhq.selenium:selenium-java:3.3.1") // <3>
}
// end::add-selenium[]
