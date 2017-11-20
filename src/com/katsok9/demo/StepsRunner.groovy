package com.katsok9.demo

import com.katsok9.jenkinsscripts.Mapper

class StepsRunner {

   static yalla(Object _pipe,Object projectDefs){
       _pipe.printColor("blue","${projectDefs}")
       _pipe.printColor("blue","In runner")
       def steps = MapperUtil.mapdefs(_pipe,projectDefs)
       _pipe.stage("${steps.name}")

   }
}
