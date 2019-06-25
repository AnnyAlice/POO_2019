import java.util.Scanner;

class Pet {
    String nome;
    private boolean isAlive;
    private int energia;
    private int saciedade;
    private int limpeza;
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int idade;
    private int diamante;

    public int getEnergia() { return this.energia;}

    public void setEnergia(int energia) {
        if (energia < this.energiaMax) {
            this.energia = this.energiaMax;
        } else if (energia <= 0) {
            this.energia = 0;
            this.isAlive = false;
        } else {
            this.energia = energia;
        }
    }


    public int getSaciedade() { return this.saciedade;}


    public void setSaciedade(int saciedade) {
        if (saciedade < this.saciedadeMax) {
            this.saciedade= this.saciedadeMax;
        } else if (saciedade <= 0) {
            this.saciedade = 0;
            this.isAlive = false;
        } else {
            this.limpeza = limpeza;
        }
    }


    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza) {
        if (limpeza < this.limpezaMax) {
            this.limpeza = this.limpezaMax;
        } else if (limpeza < 0) {
            this.limpeza = 0;
            this.isAlive = false;
        } else {
            this.limpeza = limpeza;
        }
    }
    public boolean testAlive(){
        if(this.isAlive) {
            return true;
        } else {
            System.out.println("fail: pet morto");
            return false;
        }
    }
    public void play() {
        if(this.testAlive())
        this.setEnergia(this.getEnergia() - 2);
        this.setSaciedade(this.getSaciedade() - 1);
        this.setLimpeza(this.getLimpeza() - 3);
        this.diamante += 1;
        this.idade += 1;
    }

    public void comer() {
        if(this.testAlive())
        this.setEnergia(this.getEnergia() - 1);
        this.setSaciedade(this.getSaciedade() + 4);
        this.setLimpeza(this.getLimpeza() - 2);
        this.idade = idade + 1;
    }

    public void dormir(){
        if(this.testAlive())
        if(this.energiaMax - this.energia < 5){
            System.out.println("fail: n esta com sono");
            return;
        }
        this.idade += this.energiaMax - this.energia;
        this.setEnergia(this.getEnergiaMax());
    }


    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getSaciedadeMax() {
        return saciedadeMax;
    }

    public int getLimpezaMax() {
        return limpezaMax;
    }

    public int getIdade() {
        return idade;
    }

    public int getDiamante() {
        return diamante;
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
        return "[ " + this.nome + "]" +
                " Energia: " + this.energia + "/" + this.energiaMax + " " +
                " Saciedade: " + this.saciedade + "/" + this.saciedadeMax + " " +
                " Limpeza: " + this.limpeza + "/" + this.limpezaMax + " " +
                " Idade: " + this.idade + " Diamantes: " + this.diamante;


    }

}
public class Controller {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(" ", 0, 0, 0);
        System.out.println("end, init _nome _E _S _L, show");


        while(true){
            String line =  scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("end")) {
                break;
            }else if(ui[0].equals("init")){
                pet = new Pet(ui[1], Integer.parseInt(ui[2]), Integer.parseInt(ui[3]), Integer.parseInt(ui[4]));

            }else if(ui[0].equals("show")){
                System.out.println(pet);

            }else if(ui[0].equals(("brincar"))) {
                pet.play();

            }else if(ui[0].equals("comer")){
                pet.comer();
            }else if(ui[0].equals("dormir")){
                pet.dormir();

            }else{
                System.out.println("comando invalido");


            }
        }
    }




}
