class Professor extends Funcionario {
    private char classe;

    public Professor(String nome, char classe){
        super(nome);
        this.classe = classe;
        setMax_Diarias(2);
    }

    @Override
    public void addDiaria(){ //metodo sobrecrito de funcionario
        if(getQtd_Diarias() < getMax_Diarias()){
            setSalario(getSalario() + 100);
            setQtd_Diarias(getQtd_Diarias() + 1);
            System.out.println("diaria adicionada");
        }
        else {
            System.out.println("Maximo de diarias atingido");
        }
    }

    @Override
    public void calculoSalario(){ //metodo sobrecrito de funcionario
        if(this.classe == 'A'){
            setSalario(3000);
        }
        else if(this.classe == 'B'){
            setSalario(5000);
        }
        else if(this.classe == 'C'){
            setSalario(7000);
        }
        else if(this.classe == 'D'){
            setSalario(9000);
        }
        else if(this.classe == 'E'){
            setSalario(11000);
        }
    }

    public String toString(){
        return "Prof " + getNome() + " Classe " + this.classe + "\nSalario " + getSalario();
    }
}