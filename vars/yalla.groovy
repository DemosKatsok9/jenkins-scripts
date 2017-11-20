import com.katsok9.demo.MavenArtifactoryUtil
import com.katsok9.demo.YallaRunner

def call(projectDefs) {
    timestamps {
        node {
            checkout scm
//            YallaRunner.yalla(this, projectDefs)
            printColor("blue","I'm the 0.2.1-SNAPSHOT")
            MavenArtifactoryUtil.buildArtifactory(this,false)
        }
    }
}
return this