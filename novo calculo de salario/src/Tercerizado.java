class Terceirizado extends Funcionario {
    private int horasTrabalhadas;
    private boolean insalubre;

    public Terceirizado(String nome, int horas, String insalubre){
        super(nome);
        this.horasTrabalhadas = horas;
        if(insalubre == "sim"){
            this.insalubre = true;
        }
        else {
            this.insalubre = false;
        }
    }

    @Override
    public void addDiaria(){ //metodo sobrecrito de -  metodos abstratos teem q ser instanciados? acho q n
        System.out.println("Terceirizados nao possuem diaria");
    }

    @Override
    public void calculoSalario(){ //metodo sobrecrito de funcionario
        if(this.insalubre == true){
            setSalario((4 * this.horasTrabalhadas) + 500);
        }
        else{
            setSalario(4 * this.horasTrabalhadas);
        }
    }

    public String toString(){
        if(this.insalubre == true){
            return "Tercerizado: " + getNome() +  " - horas trabalhadas: " + this.horasTrabalhadas + "h -" + " insalubre" + "\nsalario " + getSalario();
        }
        else{
            return "Tercerizado: " + getNome() +  " - horas trabalhadas: " + this.horasTrabalhadas + "h -" + "\nsalario " + getSalario();
        }

    }
}
