import java.util.Map;
import java.util.TreeMap;

public abstract class Funcionario {
    String nome;
    int max_diaria;
    int qtd_diaria;
    double bonus;
    double salario;


    public Funcionario(String nome, int max_diaria) {
        this.nome = nome;
        this.max_diaria = max_diaria;
        this.qtd_diaria = 0;
    }
    public abstract void  addDiaria();
}
    //public Map<String, Funcionario> getFuncionarios() {
    //    return funcionarios;
    //}

    //public void setFuncionarios(Map<String, Funcionario> funcionarios) {
    //    this.funcionarios = funcionarios;
    //}
//}

//public void setSalario(String variavel){


//Switch case

//return salario