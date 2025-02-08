package main.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Funcionario extends Pessoa {
    
    private BigDecimal salario;
    private String funcao;
    


    public Funcionario(String nome, LocalDate dataNasc, BigDecimal salario, String funcao) {
        super(nome, dataNasc);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Funcionario salario(BigDecimal salario) {
        setSalario(salario);
        return this;
    }

    public Funcionario funcao(String funcao) {
        setFuncao(funcao);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Funcionario)) {
            return false;
        }
        Funcionario funcionario = (Funcionario) o;
        return Objects.equals(salario, funcionario.salario) && Objects.equals(funcao, funcionario.funcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salario, funcao);
    }

    @Override
    public String toString() {
         DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return getNome() +
               ", " + getDataNasc().format(formatar) +
               ", " + getSalario() + 
               ", " + getFuncao() + "\n";
    }
    
}
