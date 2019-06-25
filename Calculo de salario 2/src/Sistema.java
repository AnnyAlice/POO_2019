import java.util.*;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;

public class Sistema {
    //Funcionario funcionario = new Funcionario();
    HashMap<String, String> funcionarios = new HashMap<>();
    int func = 0;

    //Set set = funcionarios.entrySet();
    //Iterator iterator = set.iterator();

    public Sistema() {
    }

    public void contarFunc(){
        func += 1;
    }
    //void setSalario(String classe){


    public void addProf(String nome, String classe) {
        //String salario;
        funcionarios.put (nome, classe);
        contarFunc();
        System.out.println("Funcionário added");

        //salario = funcionario.setSalario(classe.toString());
    }

    public void addTercerizado(String nome, Integer horas) {
        funcionarios.put(nome, String.valueOf(horas));
        contarFunc();
        System.out.println("Funcionário added");
    }

    public void addServidor(String nome, Integer nivel) {
        funcionarios.put(nome, String.valueOf(nivel));
        contarFunc();
        System.out.println("Funcionário added");
    }
    public void showFunc(){
        for (String key : funcionarios.keySet()){
            String nome = key.toString();
            String classe = funcionarios.get(nome).toString();
            System.out.println("Prof " + nome + " Classe " + classe);
        }
    }

    public void remover(String nome) {
        funcionarios.remove(nome);
    }

    public String toString(String nome) {
        return funcionarios.get(nome);

    }


    public static class Controller {
        public static void main(String[] args) {
            Sistema sistema = new Sistema();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                String line = scanner.nextLine();
                String[] ui = line.split(" ");

                if (ui[0].equals("end")) {
                    break;
                } else if (ui[0].equals("init")) {
                    sistema = new Sistema();
                } else if (ui[0].equals("show")) {
                    sistema.toString(ui[1]);
                } else if (ui[0].equals("addProf")) {
                    sistema.addProf(ui[1], (ui[2]));
                } else if (ui[0].equals("addTercerizado")) {
                    sistema.addTercerizado(ui[1], Integer.valueOf((ui[2])));
                } else if (ui[0].equals("addServidor")) {
                    sistema.addServidor(ui[1], Integer.valueOf((ui[2])));
                }else if (ui[0].equals("showFunc")) {
                    sistema.showFunc();
            }

        }
    }
}