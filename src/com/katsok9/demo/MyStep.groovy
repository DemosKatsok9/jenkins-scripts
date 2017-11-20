package com.katsok9.demo

class MyStep implements Serializable{
    static def myNewFunc(_pipe, projectDefs){
        _pipe.printColor("yellow", "my new func @ my step ")
    }
}
