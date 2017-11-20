package com.katsok9.demo


static def yalla(Object projectDefs) {
    printColor("blue", "${projectDefs}")
    printColor("blue", "In runner")
//        JobStep steps = MapperUtil.mapdefs(_pipe, projectDefs)
//        steps.each { step ->
//            _pipe.stage("${step.name}") {
//                step.doStep(_pipe,projectDefs)
//            }
//        }

}

