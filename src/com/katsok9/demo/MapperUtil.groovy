package com.katsok9.demo

class MapperUtil implements Serializable {

    static def mapdefs(_pipe, projectDefs) {
        def steps = [:]
//        switch (projectDefs.language) {
//            case "java": steps.java = new MavenArtifactoryUtil(_pipe, projectDefs); break
//            case "node_js": steps.node_js = new NpmNodeJSUtil(_pipe, projectDefs); break
//            default: _pipe.printColor("orange", "Not yet implemented")
//        }
        projectDefs.keySet() { key ->
            _pipe.printColor("blue", "key: ${key}, val: ${projectDefs.get(key)}")
            switch (key) {
                case "version": _pipe.printColor("orange","warn: will support @grab here"); break
                case "my_step": steps.put('my_step', new MyStep()); break
                default: _pipe.printColor("orange", "Not yet implemented")
            }

        }
        return steps
    }


}
