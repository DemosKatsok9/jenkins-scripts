package com.katsok9.jenkinsscripts

class YallaRunner implements Serializable {
   static def yallaRun(_pipe) {
        _pipe.ansiColor('xterm') {
            _pipe.timestamps {
                _pipe.node("${_pipe.projectDefs.language}_build") {
                    _pipe.env.JAVA_HOME = "${_pipe.tool 'java1.8.0'}"
                    _pipe.env.PATH = "${_pipe.env.JAVA_HOME}/bin:${_pipe.env.PATH}"

                    try {
                        _pipe.echo "in try"

                        PipeGlobal.printColor(this, "Yaalla shcha", "blue")
                        _pipe.echo "afterpipe"

                        Mapper mapper = new Mapper(this, _pipe.projectDefs)
                        PipeGlobal.printColor(this, "Mapping", "blue")
                        Phase[] phases = mapper.mapDefs()
                        if (phases) {
                            _pipe.stage("checkout") {
                                _pipe.checkout scm
                            }
                        }
                        PipeGlobal.printColor(this, "phasing", "blue")
                        phases.each { phase ->
                            PipeGlobal.printColor(this, "phase: ${phase.name}", "blue")
                            phase.doit(this)
                        }
                    } catch (error) {
                        _pipe.echo "${error}"
                    } finally {
                        _pipe.echo "finally"
                    }
                }
            }
        }
    }
}