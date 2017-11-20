package com.katsok9.demo

class YallaRunner {

   static yalla(Object _pipe,Object projectDefs){
       _pipe.echo "${projectDefs}"
       _pipe.printColor("blue",_pipe.pwd())
   }
}
