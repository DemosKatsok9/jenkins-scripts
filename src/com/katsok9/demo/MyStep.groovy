package com.katsok9.demo

class MyStep implements JobStep{
    MyStep(){
        name = "MyStep"
    }


    @Override
    def doStep(Object _pipe, Object args) {
        _pipe.printColor("yellow", "my new step")
    }
}
