import com.katsok9.demo.MavenArtifactoryUtil

def call(projectDefs) {
    timestamps {
        node {
            checkout scm
            //YallaRunner.yalla(this, projectDefs)
            printColor("green", "I'm 0.2.0-SNAPSHOT")
            MavenArtifactoryUtil.buildArtifactory()
        }
    }
}

return this