package main.model;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private LocalDate dataNasc;

    public Pessoa(String nome, LocalDate dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    

    public Pessoa() {
    }

    public Pessoa nome(String nome) {
        setNome(nome);
        return this;
    }

    public Pessoa dataNasc(LocalDate dataNasc) {
        setDataNasc(dataNasc);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(dataNasc, pessoa.dataNasc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNasc);
    }

    @Override
    public String toString() {
        return 
            "nome: " + getNome() + "\n" +
            "Data de Nasciemnto: " + getDataNasc();
    }
}


