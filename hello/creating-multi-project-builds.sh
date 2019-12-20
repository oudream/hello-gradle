#!/usr/bin/env bash

# https://guides.gradle.org/creating-multi-project-builds/

mkdir creating-multi-project-builds
cd creating-multi-project-builds
gradle init

cat>>build.gradle<<EOF
allprojects {
    repositories {
        jcenter()
    }
}

subprojects {
    version = '1.0'
}
EOF

cat>>settings.gradle<<EOF
//rootProject.name = 'creating-multi-project-builds'

include 'greeting-library'
EOF

mkdir greeting-library

cat>>"greeting-library/build.gradle"<<EOF
plugins {
    id 'groovy'
}

dependencies {
    compile 'org.codehaus.groovy:groovy:2.4.10'

    testCompile 'org.spockframework:spock-core:1.0-groovy-2.4', {
        exclude module: 'groovy-all'
    }
}
EOF

cd greeting-library
mkdir -p "src/main/groovy/greeter"
mkdir -p "src/test/groovy/greeter"

cat>">src/main/groovy/greeter/GreetingFormatter.groovy"<<EOF
package greeter

import groovy.transform.CompileStatic

@CompileStatic
class GreetingFormatter {
    static String greeting(final String name) {
        "Hello, ${name.capitalize()}"
    }
}
EOF

cat>>"src/test/groovy/greeter/GreetingFormatterSpec.groovy"<<EOF
package greeter

import spock.lang.Specification

class GreetingFormatterSpec extends Specification {

    def 'Creating a greeting'() {

        expect: 'The greeting to be correctly capitalized'
        GreetingFormatter.greeting('gradlephant') == 'Hello, Gradlephant'

    }
}
EOF

cd ..
./gradlew build