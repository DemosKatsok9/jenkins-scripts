package com.katsok9.jenkinsscripts

class Mapper implements Serializable {
    def __pipe__
    def params
    def phases = []


    Mapper(__pipe__, params) {
        this.__pipe__ = __pipe__
        this.params = params
    }

    def mapDefs() {
        PipeGlobal.printColor(__pipe__, "in:mapDefs", "red")
        checkDefaults()
        PipeGlobal.printColor(__pipe__, "after:checkDefaults", "green")
        return phases
    }

    void checkDefaults() {
        PipeGlobal.printColor(__pipe__, "checkDefaults", "green")
        PipeGlobal.printColor(__pipe__, "${params.language}", "green")

        switch (params.language) {
            case "java": phases += new MavenJavaBuilder(__pipe__, params); break
            case "node_js": phases += new NpmNodeJSBuilder(__pipe__, params); break
            default: PipeGlobal.printColor(__pipe__, "Not yet implemented", "orange")
        }
        PipeGlobal.printColor(__pipe__, "${phases}", "green")
    }
}