package com.katsok9.jenkinsscripts

trait Phase implements Serializable {
    Boolean phaseStatus
    String name = 'phase-default'

    def doit(__pipe__) {
        PipeGlobal.printColor(__pipe__, "I'm doing it", "orange")
        phaseStatus = true
    }

}
