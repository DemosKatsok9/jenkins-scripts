import com.katsok9.demo.YallaRunner

def call(projectDefs) {
    timestamps {
        node {
            checkout scm
//            YallaRunner.yalla(this, projectDefs)
            printColor("green","I'm the 0.2.1-SNAPSHOT")
        }
    }
}
return this