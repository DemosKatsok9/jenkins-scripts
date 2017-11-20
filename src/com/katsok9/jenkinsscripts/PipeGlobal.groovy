package com.katsok9.jenkinsscripts


class PipeGlobal implements Serializable {
    def status

    static def printColor(__pipe__, msg, color) {
        switch (color) {
            case "blue": __pipe__.echo("\u001B[1;38;5;21m${msg}\u001B[0m"); break
            case "yellow": __pipe__.echo("\u001B[1;38;5;184m${msg}\u001B[0m"); break
            case "red": __pipe__.echo("\u001B[1;38;5;124m${msg}\u001B[0m"); break
            case "green": __pipe__.echo("\u001B[1;38;5;34m${msg}\u001B[0m"); break
            case "orange": __pipe__.echo("\u001B[1;38;5;202m${msg}\u001B[0m"); break
            default: __pipe__.echo "${msg}"
        }
    }


}