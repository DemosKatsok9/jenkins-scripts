package com.katsok9.demo

trait JobStep implements Serializable{
    Boolean success
    String name
    def doStep(_pipe,args){
        _pipe.printColor('blue',"This step is default - Override me: ${this.class.name}")
    }
}