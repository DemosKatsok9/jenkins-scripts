import com.katsok9.demo.YallaRunner

def call(projectDefs) {
    timestamps {
        node {
            stage('checkout') {
                checkout scm
            }
           // YallaRunner.yalla(this, projectDefs)
            stage('Who Am I') {
                printColor("yellow", "I am dev")
            }
        }
    }
}
return this