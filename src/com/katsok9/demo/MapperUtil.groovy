package com.katsok9.demo

class MapperUtil implements Serializable {

    static def mapdefs(_pipe, projectDefs) {
        List<JobStep> steps = Collections.emptyList()
//        switch (projectDefs.language) {
//            case "java": steps.add(new MavenArtifactoryUtil(_pipe, projectDefs)); break
//            case "node_js": steps.add(new NpmNodeJSUtil(_pipe, projectDefs)); break
//            default: _pipe.printColor("orange", "Not yet implemented")
//        }
        projectDefs.keySet().each { key ->
            _pipe.printColor("blue", "key: ${key}, val: ${projectDefs.get(key)}")
//            switch (key) {
//                case "version": _pipe.printColor("orange","warn: will support @grab here"); break
//                case "my_step": steps.add( new MyStep()); break
//                default: _pipe.printColor("orange", "Not yet implemented")
//            }

        }
        return steps
    }


}
