import com.katsok9.demo.MavenArtifactoryUtil

def call(projectDefs) {
    timestamps {
        node {
            stage('checkout') {
                checkout scm

            }
            stage('who am I') { printColor("blue", "I'm the ${BRANCH_NAME}") }
            StepsRunner.yalla(this, projectDefs)

        }
    }
}

return this