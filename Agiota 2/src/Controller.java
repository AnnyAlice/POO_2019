import java.util.ArrayList;
import java.util.Scanner;

class Cliente{
    String id;
    String fullname;
    float saldo;

    public Cliente (String id, String fullname){
        this.id = id;
        this.fullname = fullname;
        this.saldo = 0;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.fullname + ":" + this.saldo;
    }
}
class Sistema{
    float saldo;
    ArrayList<Cliente> clientes;

    public Sistema(float saldo){
        this.saldo = saldo;
        this.clientes = new ArrayList<Cliente>();
    }

    @Override
    public String toString() {
        String saida = "";
        for(Cliente cliente : clientes){
            saida += cliente + "\n";
        saida += "saldo: " + this.saldo;
        }return saida;
    }
}


public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        while (true){
            String line =  scanner.nextLine();
            String[] ui = line.split(" ");

            if (ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                sistema =  new Sistema(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("show")){
                System.out.println(sistema);
            }
        }
    }
}
