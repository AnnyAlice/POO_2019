class Calc:
    def __init__(self, batMax):
        self.bateria = 0
        self.bateriaMax = batMax

    def carga(self, valor):
        self.bateria += valor
        if (self.bateria > self.bateriaMax):
            self.bateria = self.bateriaMax

    def gastar_bateria(self):
        if (self.bateria ==0):
            print "bateria insuficiente"
            return False
        self.bateria -= 1
        return True

        
    def soma (self, a, b):
        if (self.gastar_bateria()):
            return (a + b)
            
    def divisao(self, a, b):
        if (self.gastar_bateria()):
            if b == 0:
                print "invalido"
            else:
                div = (a / b)
                return div        
    def subtracao(self, a, b):
        if (self.gastar_bateria()):
            return  (a - b)
    def multiplicacao(self, a, b):
        if (self.gastar_bateria()):
            return (a * b)        

    def __str__(self):
        return "bateria =  " + str(self.bateria) + "/" + str(self.bateriaMax)

calc = Calc(0)
print "show, init _maxCarga, charge _value, soma _a _b, div _a _b, sub _a _b, multi _a _b"
while True:
    ui = raw_input().split(" ")
    if ui[0] == "end":
        break
    elif ui[0] == "init":
        calc = Calc(int(ui[1]))
    elif ui[0] == "show":
        print (calc)
    elif ui[0] == "charge":
        calc.carga(int(ui[1]))
    elif ui [0] == "soma":
        print(calc.soma(int(ui[1]), int(ui[2])))
    elif ui [0] == "div":
        print calc.divisao (float(ui[1])), (float(ui[2]))
    elif ui [0] == "sub":
        print (calc.subtracao (int(ui[1])), (int(ui[2])))
    elif ui [0] == "multi":
        print (calc.multiplicacao (int(ui[1])), (int(ui[2])))
    else:
        print "invalido"
    
