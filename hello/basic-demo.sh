#!/usr/bin/env bash


# https://guides.gradle.org/creating-new-gradle-builds/

mkdir basic-demo && cd basic-demo
gradle init
#├── build.gradle
#├── gradle
#│   └── wrapper
#│       ├── gradle-wrapper.jar
#│       └── gradle-wrapper.properties
#├── gradlew
#├── gradlew.bat
#└── settings.gradle

find .
#    ./gradle
#    ./gradle/wrapper
#    ./gradle/wrapper/gradle-wrapper.jar
#    ./gradle/wrapper/gradle-wrapper.properties
#    ./gradlew
#    ./.gitignore
#    ./build.gradle
#    ./.gitattributes
#    ./.gradle
#    ./.gradle/6.0.1
#    ./.gradle/6.0.1/executionHistory
#    ./.gradle/6.0.1/executionHistory/executionHistory.lock
#    ./.gradle/6.0.1/executionHistory/executionHistory.bin
#    ./.gradle/6.0.1/gc.properties
#    ./.gradle/6.0.1/fileChanges
#    ./.gradle/6.0.1/fileChanges/last-build.bin
#    ./.gradle/6.0.1/fileHashes
#    ./.gradle/6.0.1/fileHashes/fileHashes.lock
#    ./.gradle/6.0.1/fileHashes/fileHashes.bin
#    ./.gradle/buildOutputCleanup
#    ./.gradle/buildOutputCleanup/cache.properties
#    ./.gradle/buildOutputCleanup/outputFiles.bin
#    ./.gradle/buildOutputCleanup/buildOutputCleanup.lock
#    ./gradlew.bat
#    ./settings.gradle
#    ./src
#    ./src/test
#    ./src/test/resources
#    ./src/test/java
#    ./src/test/java/application1
#    ./src/test/java/application1/AppTest.java
#    ./src/main
#    ./src/main/resources
#    ./src/main/java
#    ./src/main/java/application1
#    ./src/main/java/application1/App.java

# task copy
cat >> build.gradle <<EOF
task copy(type: Copy, group: "Custom", description: "Copies sources to the dest directory") {
    from "src"
    into "dest"
}
EOF

./gradlew copy


# task zip
cat >> build.gradle <<EOF
plugins {
    id "base"
}
task zip(type: Zip, group: "Archive", description: "Archives sources in a zip file") {
    from "src"
    setArchiveName "basic-demo-1.0.zip"
}
EOF

./gradlew zip

./gradlew tasks

# The properties command tells you about a project’s attributes.
./gradlew properties

### hello world --- end.
