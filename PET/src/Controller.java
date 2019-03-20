import java.util.Scanner;

class Pet{
    String nome;
    private int energia;
    private int saciedade;
    private int limpeza;
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int idade;
    private int diamante;

    public int getEnergia() {s
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getSaciedade() {
        return saciedade;
    }

    public void setSaciedade(int saciedade) {
        this.saciedade = saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza) {
        this.limpeza = limpeza;
    }

    public Pet(String nome, int energia, int saciedade, int limpeza){
        this.nome = nome;
        this.energia = energia;
        this.energiaMax = energiaMax;
        this.saciedade = saciedade;
        this.saciedadeMax = saciedadeMax;
        this.limpeza = limpeza;
        this.limpezaMax = limpezaMax;
        this.idade = 0;
        this.diamante =  0;

    }

    public String toString(){
        return "[" + this.nome + "]" +
                "Energia: " + this.energia + "/" + this.energiaMax + " " +
                "Saciedade: " + this.saciedade + "/" + this.saciedadeMax + " " +
                "Limpeza: " + this.limpeza + "/" + this.limpezaMax + " " +
                "Idade: " + this.idade + " Diamantes: " + this.diamante;


    }

}
public class Controller {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(" ", 0, 0, 0);


        while(true){
            String line =  scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            }else if(ui[0].equals("init")){
                pet = new Pet(ui[1], Integer.parseInt(ui[2]),
                        Integer.parseInt(ui[3]),
                        Integer.parseInt(ui[4]));
            }else if(ui[0].equals("show")){
                System.out.println(pet);

            }else{
                System.out.println("comando invalido");

            }
        }
    }




}