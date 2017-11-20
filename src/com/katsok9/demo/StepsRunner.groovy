package com.katsok9.demo

class StepsRunner {

    static yalla(Object _pipe, Object projectDefs) {
        _pipe.printColor("blue", "${projectDefs}")
        _pipe.printColor("blue", "In runner")
        JobStep steps = MapperUtil.mapdefs(_pipe, projectDefs)
        steps.each { step ->
            _pipe.stage("${step.name}") {
                step.doStep(_pipe,projectDefs)
            }
        }

    }
}
