
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Pessoa{
    String id;
    int idade;

    public Pessoa(String id, int idade){
        this.id = id;
        this.idade = idade;

    }

    @Override
    public String toString() {
        return id + ":" + idade;
    }
}

class Banco {
    HashMap <String, Pessoa> pessoas;

    public Banco() {
        pessoas = new HashMap<String, Pessoa>();
    }

    @Override
    public String toString() {
        String saida = "";
        for(String key : pessoas.keySet())
            saida += pessoas.get(key);
        return saida;
    }

    void inserir(String id, int idade) {
        Pessoa pessoa = pessoas.get(id);
        if (pessoa == null) {
            pessoas.put(id, new Pessoa(id, idade));
        }
    }

}


public class Mapas {
    public static void main(String[] args) {
        ArrayList<Integer> lista;
        Banco banco = new Banco();
        banco.inserir(" davi", 18);
        banco.inserir(" Ju", 20);
        banco.inserir("Paolaa", 17);
        System.out.println(banco);

        HashMap<String, Integer> mapa = new HashMap<String, Integer>();



        //ArrayList<Integer> lista;


        //HashMap<String, Integer> mapa = new HashMap<String, Integer>();

        mapa.put("david", 18);
        mapa.put("vanessa", 40);
        mapa.put("tailandia", 17);
        mapa.put("romenia", 15);

        mapa.remove("tailandia");
        Integer in = mapa.get("vassoura");
        if(in == null)
            System.out.println("nao tenho vassoura");

        for(String key : mapa.keySet())
            System.out.println(mapa.get(key));
    }


}

