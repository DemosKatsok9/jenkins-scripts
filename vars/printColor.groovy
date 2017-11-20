
def call(String color,String msg){
    ansiColor('xterm') {
        switch (color) {
            case "blue": echo("\u001B[1;38;5;21m${msg}\u001B[0m"); break
            case "yellow": echo("\u001B[1;38;5;184m${msg}\u001B[0m"); break
            case "red": echo("\u001B[1;38;5;124m${msg}\u001B[0m"); break
            case "green": echo("\u001B[1;38;5;34m${msg}\u001B[0m"); break
            case "orange": echo("\u001B[1;38;5;202m${msg}\u001B[0m"); break
            default: echo "${msg}"
        }
    }
}
return this