
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Funcionario {
    private String nome;
    private double salario;
    private int maxDiarias;
    private int qtdDiarias;
    private double bonus;

    public Funcionario(String nome){
        this.nome = nome;
        this.qtdDiarias = 0;
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

    public int getMaxDiarias() {
        return maxDiarias;
    }

    public void setMaxDiarias(int maxDiarias) {
        this.maxDiarias = maxDiarias;
    }

    public int getQtdDiarias() {
        return qtdDiarias;
    }

    public void setQtdDiarias(int qtdDiarias) {
        this.qtdDiarias = qtdDiarias;
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

class Professor extends Funcionario {
    private char classe;

    public Professor(String nome, char classe){
        super(nome);
        this.classe = classe;
        setMaxDiarias(2);
    }

    @Override
    public void addDiaria(){
        if(getQtdDiarias() < getMaxDiarias()){
            setSalario(getSalario() + 100);
            setQtdDiarias(getQtdDiarias() + 1);
        }
        else {
            System.out.println("Maximo de diarias atingido");
        }
    }

    @Override
    public void calculoSalario(){
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
class Servidor extends Funcionario {
    private int nivel;

    public Servidor(String nome, int nivel){
        super(nome);
        this.nivel = nivel;
        setMaxDiarias(1);
    }

    @Override
    public void addDiaria(){
        if(getQtdDiarias() < getMaxDiarias()){
            setSalario(getSalario() + 100);
            setQtdDiarias(getQtdDiarias() + 1);
        }
        else {
            System.out.println("Maximo de diarias atingido");
        }
    }

    @Override
    public void calculoSalario(){
        setSalario(3000 + 300 * this.nivel);
    }

    public String toString(){
        return "Sta " + getNome() + " Nivel " + this.nivel + "\nSalario " + getSalario();
    }
}
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
    public void addDiaria(){
        System.out.println("Terceirizados nao possuem diaria");
    }

    @Override
    public void calculoSalario(){
        if(this.insalubre == true){
            setSalario((4 * this.horasTrabalhadas) + 500);
        }
        else{
            setSalario(4 * this.horasTrabalhadas);
        }
    }

    public String toString(){
        if(this.insalubre == true){
            return "Tercerizado: " + getNome() +  "- horas trabalhadas: " + this.horasTrabalhadas + " h -" + " insalubre" + "\nsalario " + getSalario();
        }
        else{
            return "Tercerizado: " + getNome() +  "- horas trabalhadas" + this.horasTrabalhadas + "h -" + "\nsalario " + getSalario();
        }

    }
}




class Sistema {
    ArrayList <Funcionario> funcionarios = new ArrayList<>();

    public void addProf(String nome, char classe){
        Professor p = new Professor(nome, classe);
        p.calculoSalario();
        funcionarios.add(p);
    }

    public void addSta(String nome, int nivel){
        Servidor s = new Servidor(nome, nivel);
        s.calculoSalario();
        funcionarios.add(s);
    }

    public void addTer(String nome, int horas, String insalubre){
        Terceirizado t = new Terceirizado(nome, horas, insalubre);
        t.calculoSalario();
        funcionarios.add(t);
    }

    public void mostraFunc(String nome){
        for(Funcionario func : funcionarios){
            if(func.getNome().equals(nome)){
                System.out.println(func);
            }
        }
    }

    public void diaria(String nome){
        for(Funcionario func : funcionarios){
            if(func.getNome().equals(nome)){
                func.addDiaria();
            }
        }
    }

    public void bonus(double bonus){
        double bonusFunc = bonus / funcionarios.size();
        for(Funcionario func : funcionarios){
            func.setSalario(func.getSalario() + bonusFunc);
        }
    }
    void remove(String nome){
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNome().equals(nome)){
                funcionarios.remove(funcionario);
                break;
            }
        }
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while(true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("addProf")){
                sistema.addProf(ui[1], ui[2].charAt(0));
            }
            else if(ui[0].equals("addSta")){
                sistema.addSta(ui[1], Integer.parseInt(ui[2]));
            }
            else if(ui[0].equals("addTer")){
                sistema.addTer(ui[1], Integer.parseInt(ui[2]), ui[3]);
            }
            else if(ui[0].equals("addDiaria")){
                sistema.diaria(ui[1]);
            }
            else if(ui[0].equals("show")){
                sistema.mostraFunc(ui[1]);
            }
            else if(ui[0].equals("setBonus")){
                sistema.bonus(Double.parseDouble(ui[1]));
            }
            else if(ui[0].equals("rm")) {
                sistema.remove((ui[1]));
            }
            else{
                System.out.println("Comando invalido");
            }
        }
    }
}