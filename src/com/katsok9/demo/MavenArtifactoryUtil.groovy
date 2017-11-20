package com.katsok9.demo

class MavenArtifactoryUtil implements Serializable {

    static def buildArtifactory(_pipe, boolean deploy) {
        def server = _pipe.Artifactory.server('ArtifactoryLocal')
        def buildInfo = _pipe.Artifactory.newBuildInfo()
        def rtMaven = _pipe.Artifactory.newMavenBuild()
        rtMaven.tool = 'maven3.5.0'
        rtMaven.deployer server: server, releaseRepo: 'maven-private', snapshotRepo: 'maven-private'
        rtMaven.resolver server: server, releaseRepo: 'maven-virtual', snapshotRepo: 'maven-virtual'
        rtMaven.deployer.deployArtifacts = false
        rtMaven.run pom: 'pom.xml', goals: 'clean install', buildInfo: buildInfo
        if (deploy) {
            rtMaven.deployer.deployArtifacts buildInfo
            server.publishBuildInfo buildInfo
        }
    }

    static def incrementSnapshot(_pipe) {
        def server = _pipe.Artifactory.server('ArtifactoryLocal')
        def buildInfo = _pipe.Artifactory.newBuildInfo()
        def rtMaven = _pipe.Artifactory.newMavenBuild()
        rtMaven.tool = 'maven3.5.0'
        rtMaven.deployer server: server, releaseRepo: 'maven-private', snapshotRepo: 'maven-private'
        rtMaven.resolver server: server, releaseRepo: 'maven-virtual', snapshotRepo: 'maven-virtual'
        rtMaven.deployer.deployArtifacts = false
        String versionsCmd = new StringBuilder()
                .append("mvn build-helper:parse-version versions:set ")
                .append('-DnewVersion=${parsedVersion.majorVersion}.${parsedVersion.minorVersion}.')
                .append('${parsedVersion.nextIncrementalVersion}-SNAPSHOT versions:commit').toString()
        rtMaven.run pom: 'pom.xml', goals: versionsCmd, buildInfo: buildInfo
    }
}
