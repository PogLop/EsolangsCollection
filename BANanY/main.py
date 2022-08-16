mem = [0,0]
num = 0

def interpret(code):
    pos = 0
    while pos < len(code):
        if code[pos] == "B":
            mem[0] = num
        elif code[pos] == "A":
            inp = input(".")
            num = ord(str(inp))
        elif code[pos] == "N":
            num += 1
        elif code[pos] == "a":
            print(chr(num))
        elif code[pos] == "n":
            num -= 1
        elif code[pos] == "Y":
            num = mem[0]

        pos += 1