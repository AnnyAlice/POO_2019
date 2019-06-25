public class Professor extends Funcionario{
    char classe;
    float salario;


    public Professor(String nome, int max_diaria) {
        super(nome, max_diaria);
    }

    @Override
    public void addDiaria() {
        if(this.qtd_diaria < this.max_diaria){
            this.salario += 100;
            this.qtd_diaria++;
            }else{
                System.out.println("numero maximo de diarias atingido");
            }
    }

    void setSalario(String classe) {
        switch (classe) {
            case "A":
                salario = 3000;
                break;
            case "B":
                salario = 5000;
                break;
            case "C":
                salario = 7000;
                break;
            case "D":
                salario = 9000;
                break;
            case "E":
                salario = 11000;
                break;
            default:
                System.out.println("Classe invalida");
        }
    }
    float getSalario(){
        return salario;
    }

    @Override
    public String toString() {
        return "Salario: " + getSalario();
    }
}
