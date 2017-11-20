import com.katsok9.demo.StepsRunner

def call(projectDefs) {
    try {
        timestamps {
            node {
                stage('checkout') {
                    checkout scm
                }
                stage('who am I') {
                    printColor("blue", "I'm the ${BRANCH_NAME}")
                }
              //  StepsRunner.yalla(this, projectDefs)

            }
        }
    }catch (error){
        printColor("red","error: ${error}")
    }finally{
        printColor("orange","finally")
    }
}

return this