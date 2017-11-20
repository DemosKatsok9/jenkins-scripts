package com.katsok9.jenkinsscripts

class MavenBuilder implements Phase{
    @Override
    def doit(__pipe__) {
        __pipe__.stage('default maven clean install'){
            def mvn = __pipe__.tool 'maven3.5.0'
            mvn "clean install"
        }
    }
}
