// instructions
/*
    * = input
    *** = console output
    ** = shift mem location by one to the left
    *** * = shift mem location by one to the right
    * * *** = repeats action on next line as many times as big is number in current mem location
    ** *** * = mem clr
    * * = ++ mem[pointer]
    * ** = -- mem[pointer]
*/

class Vanice {
    static def Interpret(def code = []) {
        def mem = [0,0,0,0,0,0,0,0];
        int memPointer = 0;

        for (int i = 0; i < code.size(); i++) {
            if (code[i] == "*") {
                int inp = System.in.newReader().readLine();
                println(inp);
                mem[memPointer] = inp;
            } else if (code[i] == "***") {
                println((char)mem[memPointer]);
            } else if (code[i] == "**") {
                if (memPointer > -1) {
                    memPointer--
                }
            } else if (code[i] == "*** *") {
                if (memPointer < 8) {
                    memPointer++
                }
            } else if (code[i] == "* * ***") {
                for (int k = 0; k < mem[memPointer]; k++) {
                    code.add(i + k + 1, code[i + 1]);
                }
                println(code);
            } else if (code[i] == "** *** *") {
                for (int k = 0; k < mem.size(); k++) {
                    mem[k] = 0
                }
            } else if (code[i] == "* *") {
                memPointer++
            } else if (code[i] == "* **") {
                memPointer--
            }
        }
    }

    static def Read(String filéPath) {
        String filé = new File(filéPath).text;
        String[] strip;
        
        strip = filé.split("\n");

        return strip;
    }

    static void main(String[] args) {
        def kod = Read(args[0]);
        println(kod);
        Interpret(kod);
    }
}