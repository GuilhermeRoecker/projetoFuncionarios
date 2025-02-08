package main.resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import main.model.Funcionario;

public class Arquivo {

    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void lerArquivo() {
        try {
            FileInputStream fis = new FileInputStream("Lista_Funcionarios.txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados.length != 4) {
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }
                try {
                    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String nome = dados[0].replaceAll("[^\\p{L}\\p{M} ]", "").trim();;

                    LocalDate dataNasc = LocalDate.parse(dados[1], formatar);
                    
                    BigDecimal salario = new BigDecimal(dados[2]);
                    
                    String funcao = dados[3];
                    funcionarios.add(new Funcionario(nome, dataNasc, salario, funcao));
                } catch (DateTimeParseException | NumberFormatException e) {
                    System.out.println("Erro ao processar linha: " + linha + " - " + e.getMessage());
                }
            }
            br.close();
            isr.close();
            fis.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    


    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void imprimirFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

}
