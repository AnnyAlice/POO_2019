import java.util.ArrayList;

class Sistema {
    ArrayList<Funcionario> funcionarios = new ArrayList<>();


    public void addProf(String nome, char classe){
            Professor prof = new Professor(nome, classe);
            prof.calculoSalario();
            funcionarios.add(prof); //array de funcionarios
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
                //System.out.println("diaria adicionada");
            }
        }
    }

    public void bonus(double bonus){ // divide pratodo mundo
        double bonusFunc = bonus / funcionarios.size();
        for(Funcionario func : funcionarios){
            func.setSalario(func.getSalario() + bonusFunc);
        }
    }
    void remove(String nome){ //n esta funcionando :(
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNome().equals(nome)){
                funcionarios.remove(funcionario);
                System.out.println("funcionario removido");
                break;
            }
        }
    }
}
