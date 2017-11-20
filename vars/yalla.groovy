

def call(projectDefs) {
    timestamps {
        node {
            stage('checkout') {
                checkout scm
            }

            stage('Who Am I') {
                printColor("orange", "this is ${BRANCH_NAME}")
            }
        }
    }
}
return this