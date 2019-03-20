class Bateria:
    def __init__(self):
        self.bateria = 0
        self.bat_maxima = 5
    
    def carregar(self, qtd):
        if self.bateria == 5:
            print "bateria carregada"

        if self.bateria < 5:
            soma = self.bateria + qtd
            if soma > 5:
                self.bateria = 5
            else:
                self.bateria = soma
            return "bateria com: ", self.bateria
            
    
    def descarregar_bat(self):
        if self.bateria == 0:
            return "bateria descarregada"
        
        if self.bateria > 0:
            self.bateria -= 1
    def carga(self):
        if self.bateria >0:
            return True
        
    def soma(self, a, b):
        if (self.carga() == True):
    
            soma = int(a) + int(b)
            self.descarregar_bat()
            return soma
        else:
            return "sem bateria"

            
    def divisao(self, a, b):
        if (self.carga() == True):
            self.descarregar_bat()
            if b == 0:
                print "invalido"
            else:
                div = (a) / (b)
                return div        
        else:
            return "sem bateria"

    def multiplicacao(self, a, b):
        if (self.carga() == True):
            multi = int(a) * int(b)
            self.descarregar_bat()
            return multi        
        else:
            return "sem bateria"

    def mostrar(self):
        return self.bateria

#main
bat =  Bateria()
status = True
while (status):
    print "digite / para divisao e + para soma, x para multiplicacao. carga - para carregar, status - para ver carga"
    op = raw_input("digite operacao: ")
    
    if op == "carga":
        print bat.carregar(int(raw_input("digite carga: ")))
        
    elif op == "status":
        print bat.mostrar()
        
    elif op == '/':
        x = float(raw_input("digite numero: "))
        z = float(raw_input("digite numero: "))
        print bat.divisao(x, z)
        
    elif op == '+':
        x = raw_input("digite numero: ")
        z = raw_input("digite numero: ")
        print bat.soma(x, z)
        
    elif op == 'x':
        x = raw_input("digite numero: ")
        z = raw_input("digite numero: ")
        print bat.multiplicacao(x, z)
        
    else:
        status = False





        
        
    

