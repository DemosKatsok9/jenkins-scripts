package com.katsok9.jenkinsscripts

class Mailer implements Phase{


    def heron(){
        println("lala")
    }
    @Override
    doit(__pipe__){
        __pipe__.step('mailing') {
            PipeGlobal.printColor(__pipe__,"sendingMail2U", "blue")
        }
    }
}
