import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Transacao{
    int id;
    float value;
    String clienteId;

    public Transacao(int id, float value, String clienteId) {
        this.id = id;
        this.value = value;
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "" + id + ":" + value + ":" + clienteId;
    }
}


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
        return this.id + ":" + this.fullname + ": " + this.saldo;
    }
}
class Sistema{
    float saldo;
    ArrayList<Cliente> clientes;
    ArrayList<Transacao> transacoes;
    int nextTrId;

    public Sistema(float saldo){
        this.saldo = saldo;
        this.clientes = new ArrayList<Cliente>();
        this.transacoes = new ArrayList<Transacao>();
        this.nextTrId = 0;
    }

    void cadastrar(Cliente cliente){
        try {
            this.findCliente(cliente.id);
            throw new RuntimeException("Cliente ja existe");
        }catch (RuntimeException re){
            clientes.add(cliente);
        }
    }

    Cliente findCliente(String id){
        for(Cliente cli : clientes) {
            if (cli.id.equals(id))
                return cli;
        }
        throw new RuntimeException("cliente n existe");
    }

    void addTransacao(float value, String clienteId){
        this.transacoes.add(new Transacao(nextTrId, value, clienteId));
        nextTrId += 1;

    }
    void emprestar(String id, float saldo){
        Cliente cli = findCliente(id);
        if(cli == null){
            System.out.println("cliente n existe");
            return;
        }else if(this.saldo > this.saldo){
            System.out.println("saldo maior que saldo atual");
            return;
        }
        addTransacao(-saldo, id);
        this.saldo -= saldo;
        cli.saldo += saldo;
    }
    void receber(String id, float saldo) {
        Cliente cli = findCliente(id);
        if(cli.saldo < saldo){
            System.out.println("fail: pagamente maior q divida");
            return;
        }

        addTransacao(saldo, id);
        cli.saldo -= saldo;
        this.saldo += saldo;
    }


    ArrayList<Transacao> getHistorico(){
        return transacoes;
    }

    @Override
    public String toString() {
        String saida = "";
        for(Cliente cliente : clientes)
            saida += cliente + "\n";
        saida += "saldo: " + this.saldo;
        return saida;
    }
}

public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        while (true){
            String line =  scanner.nextLine();
            String[] ui = line.split(" ");
            try {
                if (ui[0].equals("end")) {
                    break;
                } else if (ui[0].equals("init")) {
                    sistema = new Sistema(Float.parseFloat(ui[1]));
                } else if (ui[0].equals("show")) {
                    System.out.println(sistema);
                } else if (ui[0].equals("emprestar")) {
                    sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
                } else if (ui[0].equals("cadastrar")) {
                    String id = ui[1];
                    String fullname = " ";
                    for (int i = 2; i < ui.length; i++) {
                        fullname += ui[i] + " ";
                    }
                    fullname.substring(0, fullname.length() - 1);
                    sistema.cadastrar(new Cliente(id, fullname));
                } else if (ui[0].equals("historico")) {
                    ArrayList<Transacao> hist = sistema.getHistorico();
                    for (Transacao tr : sistema.getHistorico())
                        System.out.println(tr);
                } else {
                    System.out.println("comando invalido");
                }
            }catch (RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
    }
}
