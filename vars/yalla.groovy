import com.katsok9.demo.MavenArtifactoryUtil

def call(projectDefs) {
    timestamps {
        node {
            stage('checkout') {
                checkout scm

            }
            stage('who am I') { printColor("green", "I'm 0.2.0-SNAPSHOT branch") }
//            YallaRunner.yalla(this, projectDefs)
            stage('build') {
                MavenArtifactoryUtil.buildArtifactory(this, true)
            }
        }
    }
}

return this