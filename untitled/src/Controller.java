import java.util.ArrayList;
import java.util.Scanner;

class Passageiro{
    String id;
    int idade;

    public Passageiro(String id, int idade){
        this.id = id;
        this.idade = idade;
    }


    @Override
    public String toString() {
        return this.id + ": " + this.idade + " anos";
    }

    public boolean preferencial(){
       return (idade >= 60);

    }

}
class Topic {
    ArrayList <Passageiro> cadeiras;
    int qtdPreferenciais;
    String id;

    public Topic(int capacidade, int qtdPreferenciais){
        cadeiras = new ArrayList<Passageiro>();
        for(int i = 0; i < capacidade; i++){
            cadeiras.add(null);
        }
        this.qtdPreferenciais = qtdPreferenciais;
    }

    @Override
    public String toString() {
        String saida = "[";
        for(int i = 0; i < cadeiras.size(); i++){
            if(i < qtdPreferenciais){
                saida += " @ ";
            else
                saida += " = ";
            if(cadeiras.get(i) != null)
                saida += cadeiras.get(i);
        }
        return saida + " ]";
    }
    private boolean inserir(int inicio, int fim, Passageiro pass){
            for(int i = inicio; i < fim; i++){
                if(cadeiras.get(i) == null){
                    cadeiras.set(i, pass);
                    return true;
                }
            }
            return false;
    }
    public void inserir(Passageiro pass){
            if (pass.preferencial()) {
                inserir(0, this.cadeiras.size(), pass);
            }else{
                if (!inserir(this.qtdPreferenciais, this.cadeiras.size(), pass))
                    inserir(inicio = 0, this.qtdPreferenciais, pass);
            }
    }

    public boolean remover(String id){
         for(int i = 0; i < cadeiras.size(); i++){
             if(cadeiras.get(i) != null){
                 if(cadeiras.get(i).id.equals(id)){
                     cadeiras.set(i, null);
                     return true;
                 }
             }
         }
         return false;
    }
}

public class Controller {
    public static void main(String[] args) {
        Topic topic = new Topic(0, 0);
        Scanner scanner = new Scanner(System.in);


        while (true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else if(ui[0].equals("show")){
                System.out.println(topic);
            }else if(ui[0].equals("inserir")){
                topic.inserir(new Passageiro(ui[1], Integer.parseInt(ui[2])));
            else if(ui[0].equals("remover")){
                topic.remover(ui[1]);
            }else {
                System.out.println("comando invalido");
        }
    }
}
