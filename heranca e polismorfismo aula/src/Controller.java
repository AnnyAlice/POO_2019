import java.util.ArrayList;

class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getBonificacao() {
        return this.salario * 0.10;
    }

    @Override
    public String toString() {
        return nome + ":" + salario;
    }
}
class Gerente extends Funcionario{
    public Gerente(String nome, double salario){
        super(nome, salario);

    }
    public double bonificacao(){
        return salario * 0.015;
    }
}

public class Controller {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Davi", 10000);
        System.out.println(gerente.nome);

        ArrayList<Funcionario> funcs = new ArrayList<Funcionario>();
        funcs.add(new Funcionario("Carlos", 1000));
        funcs.add(new Funcionario("Catia", 1080));
        funcs.add(new Gerente("juju", 3000));

        for (Funcionario f : funcs) {
            System.out.println(f);

        }
    }
}

