import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while(true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("addProf")){
                sistema.addProf(ui[1], ui[2].charAt(0));
            }
            else if(ui[0].equals("addSta")){
                sistema.addSta(ui[1], Integer.parseInt(ui[2]));
            }
            else if(ui[0].equals("addTer")){
                sistema.addTer(ui[1], Integer.parseInt(ui[2]), ui[3]);
            }
            else if(ui[0].equals("addDiaria")){
                sistema.diaria(ui[1]);
            }
            else if(ui[0].equals("show")){
                sistema.mostraFunc(ui[1]);
            }
            else if(ui[0].equals("setBonus")){
                sistema.bonus(Double.parseDouble(ui[1]));
            }
            else if(ui[0].equals("rm")) {
                sistema.remove((ui[1]));
            }
            else{
                System.out.println("Comando invalido");
            }
        }
    }
}

