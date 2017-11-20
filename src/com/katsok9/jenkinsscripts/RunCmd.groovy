package com.katsok9.jenkinsscripts

class RunCmd implements Serializable, Phase{
    @Override
    def doit(__pipe__) {
        try {
            String cmd = __pipe__.projectDefs?.script?.cmd
            if (isUnix()) {
                PipeGlobal.printColor(__pipe__, "Running sh cmd: ${cmd}", "blue")
                __pipe__.sh cmd
            } else {
                PipeGlobal.printColor(__pipe__, "Running bat cmd: ${cmd}", "blue")
                __pipe__.bat cmd
            }
            phaseStatus = true
        } catch (error) {
            PipeGlobal.printColor(__pipe__, "doit - catch", "red")
            PipeGlobal.printColor(__pipe__, "${error}", "red")
            phaseStatus = !failingStep
        } finally {
            PipeGlobal.printColor(__pipe__, "doit - finally", "orange")
        }
    }
}
