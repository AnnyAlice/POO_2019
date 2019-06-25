import java.util.Scanner;

public class Calculadora {
    int a;
    int b;

    public Calculadora (int a, int b){
        this.a = a;
        this.b = b;
    }
    public String somar(int a, int b){
        int soma = a + b;
        return soma;
    }
    int subtrair(int a, int b){
        sub = a - b;
        return sub;
    }
    int multiplicar(int a, int b){
        multi = a * b;
        return multi;
    }
    float dividir(int a, int b){
        div = a / b;
        return div;
    }
    @Override
    public String toString(int a, int b) {
        return this.a + this.b;
    }





    public static void main (String[]args){
        Calculadora calc = new Calculadora(0, 0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("init")) {
                calc = new Calculadora;
            } else if (ui[0].equals("somar")) {
                System.out.println(calc.somar(Integer.parseInt(ui[1]), Integer.parseInt(ui[2])));
            } else if (ui[0].equals("subtrair")) {
                Calculadora.subtrair(ui[1], (ui[2]));
            } else if (ui[0].equals("dividir")) {
                Calculadora.dividir(ui[1], (ui[2]));
            } else if (ui[0].equals("multiplicar")) {
                Calculadora.multiplicar(ui[1], (ui[2]));
            }else{
                System.out.println("comando invalido");
            }
    }
}



