import com.katsok9.demo.MavenArtifactoryUtil
import com.katsok9.demo.StepsRunner

def call(projectDefs) {
    timestamps {
        node('master'){
            stage('checkout') {
                checkout scm

            }
            stage('who am I') { printColor("blue", "I'm the ${BRANCH_NAME}") }
        //    StepsRunner.yalla(this, projectDefs)

        }
    }
}

return this