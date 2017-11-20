import com.katsok9.demo.YallaRunner

def call(projectDefs) {
    timestamps {
        node {
            checkout scm
           // YallaRunner.yalla(this, projectDefs)
            printColor("yellow", "this is the dev")
        }
    }
}
return this