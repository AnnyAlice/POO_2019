import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Transacao{
    int id;
    float value;
    String clientId;

    public Transacao(int id, float value, String clientId) {
        this.id = id;
        this.value = value;
        this.clientId = clientId;
    }

    public String toString(){
        return "" + id + ":" + value + ":" + clientId;
    }
}

class Cliente{
    String id;
    String fullname;
    float  saldo;
    public Cliente(String id, String fullname){
        this.id = id;
        this.fullname = fullname;
        this.saldo = 0;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.fullname + ":" + this.saldo;
    }
}

class Sistema {
    float saldo;
    ArrayList<Cliente> clientes;
    ArrayList<Transacao> transacoes;
    int nextTrId;

    public Sistema(float saldo) {
        this.saldo = saldo;
        this.clientes = new ArrayList<Cliente>();
        this.transacoes = new ArrayList<Transacao>();
        this.nextTrId = 0;
    }

    void cadastrar(Cliente cliente) {
        if (this.findCliente(cliente.id) != null) {
            System.out.println("fail: id ja existe");
            return;
        }
        clientes.add(cliente);
    }

    Cliente findCliente(String id) {
        for (Cliente cli : clientes) {
            if (cli.id.equals(id))
                return cli;
        }
        return null;
    }

    void emprestar(String id, float saldo) {
        Cliente cli = findCliente(id);
        if (cli == null) {
            System.out.println("fail: cliente nao existe");
            return;
        }
        this.transacoes.add(new Transacao(nextTrId, -saldo, id));
        nextTrId += 1;
        this.saldo -= saldo;
        cli.saldo += saldo;
    }
    public void receber(String id, float saldo){
        Cliente cli = findCliente(id);
        if (cli == null){
            System.out.println("fail: cliente nao existe");
            return;
        }
        if(cli.saldo < saldo ){
            System.out.println("fail.pagamento maior q a divida");
            return;
        }
        this.transacoes.add(new Transacao(nextTrId, saldo, id));
        nextTrId += 1;
        cli.saldo -= saldo;
        cli.saldo += saldo;
    }

    ArrayList<Transacao> getHistorico() {
        return transacoes;
    }


    @Override
    public String toString() {
        String saida = "";
        for(Cliente cliente : clientes)
            saida += cliente + "\n";
        saida += "saldo:" + this.saldo;
        return saida;
    }
}

public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                sistema = new Sistema(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("show")){
                System.out.println(sistema);
            }else if(ui[0].equals("emprestar")){
                sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
            }else if(ui[0].equals("historico")){
                for(Transacao tr : sistema.getHistorico())
                    System.out.println(tr);
            }else if(ui[0].equals("cadastrar")){
                String id = ui[1];
                /*
                String fullname = "";

                for(int i = 2; i < ui.length; i++){
                    fullname += ui[i] + " ";
                }
                fullname = fullname.substring(0, fullname.length() - 1);
                */
                String[] subarray =  Arrays.copyOfRange(ui, 2, ui.length);
                String fullname = String.join(" ", subarray);
                sistema.cadastrar(new Cliente(id, fullname));

            }else{
                System.out.println("fail: comando invalido");
            }
        }
    }

}

/*
init 500
cadastrar ana ana banana
cadastrar julia julia agulha
emprestar ana 200
emprestar julia 100
emprestar ana 50
show


 */






