import java.util.ArrayList;
import java.util.Scanner;

class Passageiro {
    String nome;
    int idade;

    public Passageiro(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return this.nome + this.idade;
    }
    public boolean preferencia(){
        if(idade >= 60){
            return true;
        }
        return false;
    }
class Top{
    ArrayList <Passageiro> cadeira;
    int qtdPreferenciais;

    public Top(int capacidade, int qtdPreferenciais){
        cadeira = new ArrayList<Passageiro>();
        for(int i = 0; i < capacidade; i++){
            cadeira.add(null);
        }
        this.qtdPreferenciais = qtdPreferenciais;
    }
    public String toString() {
        String saida = "[ ";
        for (int i = 0; i < cadeira.size(); i++) {
            if (i < qtdPreferenciais) {
                saida = "@ ";
            } else {
                saida = "= ";
            }
            if (cadeira.get(i) != null) {
                saida += cadeira.get(i);
            }
        }return saida = " ]";

    }
    private boolean inserir(int inicio, int fim, Passageiro pass){
        for(int i = inicio; i < fim; i++){
            if(cadeira.get(i) == null){
                cadeira.set(i ,pass);
                return true;
            }
        }
        return false;
    }
    public void inserir(Passageiro pass) {
        if (pass.preferencia()) {
            inserir(0, this.cadeira.size(), pass);
            }else{
                if (!inserir(this.qtdPreferenciais, this.cadeira.size(), pass))
                    inserir(0, qtdPreferenciais, pass);
            }
        }
    public boolean remover(int id){
        for(int i = 0; i < cadeira.size(); i++){
            if(cadeira.get(i) != null){
                if(cadeira.get(i).idade == (idade)){
                    cadeira.set(i, null);
                    return true;
                }
            }
        }
        return false;
    }
}

public class Controller {
    public void main(String[] args) {
        Top top = new Top(0, 0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("init")) {
                top = new Top(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("show")) {
                System.out.println(top);
            } else if (ui[0].equals("inserir")) {
                top.inserir(new Passageiro(ui[1], Integer.parseInt(ui[2])));
            } else if (ui[0].equals("remover")) {
                top.remover(Integer.parseInt(ui[1]));
            } else {
                System.out.println("fail: comando invalido");

            }
        }

    }
}
}