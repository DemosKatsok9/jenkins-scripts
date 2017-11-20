import com.katsok9.demo.MavenArtifactoryUtil

def call(projectDefs) {
    timestamps {
        node {
            stage('checkout') {
                checkout scm
                printColor("blue", "I'm the 0.2.1-SNAPSHOT")
            }
//            YallaRunner.yalla(this, projectDefs)
            stage('build') {
                MavenArtifactoryUtil.buildArtifactory(this, false)
            }
        }
    }
}

return this