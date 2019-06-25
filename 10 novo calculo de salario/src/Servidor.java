class Servidor extends Funcionario {
    private int nivel;

    public Servidor(String nome, int nivel){
        super(nome);
        this.nivel = nivel;
        setMax_Diarias(1);
    }

    @Override
    public void addDiaria(){ //metodo sobrecrito de funcionario
        if(getQtd_Diarias() < getMax_Diarias()){
            setSalario(getSalario() + 100);
            setQtd_Diarias(getQtd_Diarias() + 1);
        }
        else {
            System.out.println("Maximo de diarias atingido");
        }
    }

    @Override
    public void calculoSalario(){ //metodo sobrecrito de funcionario
        setSalario(3000 + 300 * this.nivel);
    }

    public String toString(){
        return "Servidor " + getNome() + " Nivel " + this.nivel + "\nSalario " + getSalario();
    }
}