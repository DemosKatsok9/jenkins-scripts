package com.katsok9.demo

class MapperUtil implements Serializable {

    static def mapdefs(_pipe, projectDefs) {
        def steps = [:]
//        switch (projectDefs.language) {
//            case "java": steps.java = new MavenArtifactoryUtil(_pipe, projectDefs); break
//            case "node_js": steps.node_js = new NpmNodeJSUtil(_pipe, projectDefs); break
//            case "my_step": steps.my_stem = new MyStep(_pipe, projectDefs); break
//            default: _pipe.printColor("orange", "Not yet implemented")
//        }
        _pipe.printColor("blue", "each: ${projectDefs}")
        projectDefs.each{pdef ->
            _pipe.printColor("blue","${pdef.name}")
        }
        return steps
    }


}
