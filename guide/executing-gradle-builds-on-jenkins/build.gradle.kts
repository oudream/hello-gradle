plugins {
    id("com.gradle.build-scan") version "2.3"
    id("org.gradle.guides.getting-started") version "0.15.13"
}

guide {
    repositoryPath.set("gradle-guides/executing-gradle-builds-on-jenkins")
    minimumGradleVersion.set("4.10.3")
    title.set("Executing Gradle builds on Jenkins")
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
    if (!System.getenv("CI").isNullOrEmpty()) {
        publishAlways()
        tag("CI")
    }
}
