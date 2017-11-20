package com.katsok9.demo

class YallaRunner {

   static yalla(Object _pipe,Object projectDefs){
       _pipe.printColor("blue","${projectDefs}")
       MavenArtifactoryUtil.buildArtifactory(_pipe,true)
   }
}
