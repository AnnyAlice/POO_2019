class Car:
    def __init__(self):
        self.pas = 0
        self.km = 0
        self.fuel = 0
        self.lim_gasolina = 10
        self.lim_passageiro = 2


        
    def entrar(self):
        if self.pas < self.lim_passageiro:
            self.pas   +=1
        else:
            print ("limite atingido")

    def tirar(self):
        if self.passageiro > 0:
            self.passageiro -= 1
        else:
            print ("nao ha ninguem")

    def abastecer(self, qtd):
        self.fuel += qtd
        if self.fuel > self.lim_gasolina:
            self.fuel = self.lim_gasolina
            
    def dirigir(self, distancia):
        if self.pas == 0:
            print "n ha ninguem no carro"
            return            
        gas_necessaria = distancia/10
        if self.fuel >= distancia/10:
            self.km += distacia
            self.fuel -= gas_necessaria
        else:
            print "gasolina insuficiente"
        

    def __str__(self):
        return ("pass: " + str(self.pas) + ",gasolina: " + str(self.fuel) + "e km: " + str(self.km)
            
carro = Car()
line = ""
print ("show, in, out, fuel _qtd, drive _dist, end")
                
while (ui != "end"):
    line = raw_input()
    ui = line.split(" ")
                
                
    if ui[0] == "end":
        break    
    elif ui[0] == "show"
        print(carro)
    elif ui[0] == "in"
        carro.entrar()
    elif ui[0]== "out"
        carro.tirar()
    elif ui[0] == "fuel"
        carro.abastecer(int(ui[1]))
        
    elif ui[0] == "drive"
        carro.dirigir(int(ui[1]))
        
    else:
        print "comando invalido"



