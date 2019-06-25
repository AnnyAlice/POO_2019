public abstract class Funcionario {
    private String nome;
    private double salario;
    private int max_Diarias;
    private int qtd_Diarias;
    private double bonus;

    public Funcionario(String nome){
        this.nome = nome;
        this.qtd_Diarias = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getMax_Diarias() {
        return max_Diarias;
    }

    public void setMax_Diarias(int maxDiarias) {
        this.max_Diarias = maxDiarias;
    }

    public int getQtd_Diarias() {
        return qtd_Diarias;
    }

    public void setQtd_Diarias(int qtdDiarias) {
        this.qtd_Diarias = qtdDiarias;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public abstract void addDiaria();

    public abstract void calculoSalario();
}