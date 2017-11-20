import com.katsok9.demo.MavenArtifactoryUtil

def call(projectDefs) {
    timestamps {
        node {
            stage('checkout') {
                checkout scm

            }
            stage('who am I') { printColor("green", "I'm ${BRANCH_NAME} branch") }

            stage('build') {
                MavenArtifactoryUtil.buildArtifactory(this, true)
            }
        }
    }
}

return this