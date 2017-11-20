import com.katsok9.demo.YallaRunner

def call(projectDefs) {
    timestamps {
        node {
            checkout scm
            YallaRunner.yalla(this, projectDefs)
        }
    }
}
return this