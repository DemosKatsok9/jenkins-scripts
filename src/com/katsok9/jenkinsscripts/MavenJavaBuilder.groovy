package com.katsok9.jenkinsscripts


class MavenJavaBuilder implements Phase {
    def __pipe__
    def arty = [:]
    //defaults
    String mavenToolName
    String jdkVersion
    String pomPath
    String goals
    boolean deploy
    boolean failingStep = true

    MavenJavaBuilder(__pipe__, params) {
        PipeGlobal.printColor(__pipe__, "MavenJavaBuilder params: ${params} ", "blue")
        this.__pipe__ = __pipe__
        this.name = "MavenJavaBuilder"
        PipeGlobal.printColor(__pipe__, "MavenJavaBuilder inside", "blue")
        this.mavenToolName = params?.maven?.mavenToolName ?: "maven3.5.0"
        this.deploy = params?.maven?.deploy ?: true
        this.jdkVersion = params?.maven?.jdk ?: "java1.8.0"
        this.goals = params?.maven?.pomPath ?: "clean install"
        this.pomPath = params?.maven?.pomPath ?: "pom.xml"
        if (params?.maven?.fail)
            this.failingStep = params.maven.fail.failing

    }

    @Override
    def doit(__pipe__) {
        try {
            __pipe__.stage('config artifactory plugin - maven build') {
                PipeGlobal.printColor(__pipe__, "doit start", "blue")
                configArtifactory()
                PipeGlobal.printColor(__pipe__, "doit after config", "blue")
                PipeGlobal.printColor(__pipe__, "doit maven build", "blue")
                PipeGlobal.printColor(__pipe__, "${arty.rtMaven}", "blue")
                arty.rtMaven.run pom: pomPath, goals: goals, buildInfo: arty.buildInfo
                PipeGlobal.printColor(__pipe__, "doit after maven build", "blue")
                if (deploy) {
                    arty.rtMaven.deployer.deployArtifacts arty.buildInfo
                    arty.server.publishBuildInfo arty.buildInfo
                }
            }
            PipeGlobal.printColor(__pipe__, "doit - finish", "red")
            phaseStatus = true
        } catch (error) {
            PipeGlobal.printColor(__pipe__, "doit - catch", "red")
            PipeGlobal.printColor(__pipe__, "${error}", "red")
            phaseStatus = !failingStep
        } finally {
            PipeGlobal.printColor(__pipe__, "doit - finally", "orange")
        }
    }

    void configArtifactory() {
        PipeGlobal.printColor(__pipe__, "configArtifactory", "blue")
        def server = __pipe__.Artifactory.server('ArtifactoryLocal')
        def buildInfo = __pipe__.Artifactory.newBuildInfo()
        def rtMaven = __pipe__.Artifactory.newMavenBuild()
        rtMaven.tool = mavenToolName
        rtMaven.deployer server: arty.server, releaseRepo: 'maven-private', snapshotRepo: 'maven-private'
        rtMaven.resolver server: arty.server, releaseRepo: 'maven-virtual', snapshotRepo: 'maven-virtual'
        arty += server
        arty += buildInfo
        arty += rtMaven
        PipeGlobal.printColor(__pipe__, "sttings: ${arty}", "blue")
    }

    /**
     *  Guava API toString() method generator for a JavaBean / POJO.
     * @return String representation of all the attributes of the bean.
     */

    def incrementVersion(String type, boolean snapshot) {
        configArtifactory()
        String versionsCmd = new StringBuilder()
                .append("mvn build-helper:parse-version versions:set ")
                .append('-DnewVersion=${parsedVersion.majorVersion}.')
                .append('${parsedVersion.minorVersion}.')
                .append('${parsedVersion.nextIncrementalVersion}')
                .append("${snapshot ? '-SNAPSHOT' : ''}")
                .append("versions:commit")
        arty.rtMaven.run pom: pomPath, goals: versionsCmd
    }

    /**
     *   Guava API toString() method generator for a JavaBean / POJO.
     * @return String representation of all the attributes of the bean.
     */
    @Override
    String toString() {
        return """\
MavenJavaBuilder{
    __pipe__=$__pipe__, 
    arty=$arty, 
    mavenToolName='$mavenToolName', 
    jdkVersion='$jdkVersion', 
    pomPath='$pomPath', 
    goals='$goals', 
    deploy=$deploy, 
    failingStep=$failingStep, 
    com_katsok9_jenkinsscripts_Phase__phaseStatus=$com_katsok9_jenkinsscripts_Phase__phaseStatus, 
    com_katsok9_jenkinsscripts_Phase__name='$com_katsok9_jenkinsscripts_Phase__name'
}"""
    }
}
