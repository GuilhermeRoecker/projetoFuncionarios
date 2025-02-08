package main;

import javax.swing.*;

import main.model.Funcionario;
import main.resources.Arquivo;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TelaPrincipal extends JFrame {

    public static void main(String[] args) {
        // Exibe a interface principal
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }

    Arquivo arquivo = new Arquivo();
    Map<String, ArrayList<Funcionario>> mapaFuncionarios;

    public TelaPrincipal() {

        setTitle("Inico");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new GridLayout(4, 3, 15, 15));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] textosBotoes = {
                "Inserir Funcionários",
                "Remover João",
                "Imprimir Funcionários",
                "Aplicar Aumento",
                "Agrupar por Função",
                "Imprimir por Função",
                "Aniversariantes (Out/Dez)",
                "Funcionário Mais Velho",
                "Ordenar por Nome",
                "Total de Salários",
                "Salários Mínimos por Funcionário",
                "Sair"
        };

        for (String texto : textosBotoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.PLAIN, 14));
            botao.setFocusPainted(false);
            botao.addActionListener(e -> botoes(texto));
            add(botao);
        }
    }

    private void botoes(String acao) {

        switch (acao) {
            case "Inserir Funcionários":
                arquivo.getFuncionarios().clear();
                arquivo.lerArquivo();
                JOptionPane.showMessageDialog(this, "Funcionarios inseridos");
                break;

            case "Remover João":
                boolean joaoExiste = arquivo.getFuncionarios().stream()
                        .anyMatch(f -> f.getNome().equals("João"));
                if (joaoExiste) {
                    arquivo.getFuncionarios().removeIf(f -> f.getNome().equals("João"));
                    JOptionPane.showMessageDialog(this, "Removido João da lista de funcionários.");
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum funcionário chamado João encontrado na lista.");
                }
                break;

            case "Imprimir Funcionários":
                StringBuilder sb = new StringBuilder();
                NumberFormat formatadorSalario = DecimalFormat.getInstance(new Locale("pt", "BR"));
                formatadorSalario.setMinimumFractionDigits(2);
                if (arquivo.getFuncionarios().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
                } else {
                for (Funcionario f : arquivo.getFuncionarios()) {
                    String salarioFormatado = formatadorSalario.format(f.getSalario());

                    sb.append(f.getNome())
                            .append(", ")
                            .append(f.getDataNasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                            .append(", ")
                            .append(salarioFormatado) // Adiciona o salário formatado
                            .append(", ")
                            .append(f.getFuncao())
                            .append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            }
                break;

            case "Aplicar Aumento":
            if (arquivo.getFuncionarios().isEmpty()) {
                JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
            } else {
                for (Funcionario f : arquivo.getFuncionarios()) {
                    BigDecimal aumento = f.getSalario().multiply(new BigDecimal("0.10"));
                    BigDecimal novoSalario = f.getSalario().add(aumento).setScale(2, RoundingMode.HALF_UP);
                    f.setSalario(novoSalario);
                }
                JOptionPane.showMessageDialog(this, "Aumento de 10% aplicado");
            }
                break;

            case "Agrupar por Função":
                mapaFuncionarios = new HashMap<>();
                if (arquivo.getFuncionarios().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
                } else {
                for (Funcionario f : arquivo.getFuncionarios()) {
                    mapaFuncionarios.computeIfAbsent(f.getFuncao(), k -> new ArrayList<>()).add(f);
                }
                JOptionPane.showMessageDialog(this, "Agrupado Funcionarios pela função");
            }
                break;

            case "Imprimir por Função":
                if (mapaFuncionarios != null && !mapaFuncionarios.isEmpty()) {
                    StringBuilder agrupados = new StringBuilder();
                    
                    for (Map.Entry<String, ArrayList<Funcionario>> entrada : mapaFuncionarios.entrySet()) {
                        agrupados.append("Função: ").append(entrada.getKey()).append("\n");
                        for (Funcionario fun : entrada.getValue()) {
                            agrupados.append("- ").append(fun.getNome()).append("\n");
                        }
                        agrupados.append("\n");
                    }
                    JOptionPane.showMessageDialog(this, agrupados.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum dado agrupado para imprimir.");
                }
                break;

            case "Aniversariantes (Out/Dez)":
                String funcionarios = "";
                if (arquivo.getFuncionarios().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
                } else {
                for (Funcionario f : arquivo.getFuncionarios()) {
                    Month mesNasc = f.getDataNasc().getMonth();
                    if (mesNasc == Month.OCTOBER || mesNasc == Month.DECEMBER) {
                        funcionarios += f.getNome() + "\n";
                    }
                }
                JOptionPane.showMessageDialog(this, funcionarios);
            }
                break;

            case "Funcionário Mais Velho":
                int esteAno = LocalDate.now().getYear();
                int maiorIdade = 0;
                String nome = "";

                if (arquivo.getFuncionarios().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
                } else {
                    for (Funcionario f : arquivo.getFuncionarios()) {
                        int anoNasc = f.getDataNasc().getYear();
                        int idadeFuncionario = esteAno - anoNasc;

                        if (idadeFuncionario >= maiorIdade) {
                            maiorIdade = idadeFuncionario;
                            nome = f.getNome();
                        }
                    }
                    JOptionPane.showMessageDialog(this, "O funcionario mais velho é " + nome + " com " + maiorIdade);
                }
                break;

            case "Ordenar por Nome":
                SortedSet<String> ss = new TreeSet<String>();
                if (arquivo.getFuncionarios().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
                } else {
                for (Funcionario f : arquivo.getFuncionarios()) {
                    ss.add(f.getNome() + "\n");
                }

                StringBuilder nomes = new StringBuilder();
                for (String nomeOrdenado : ss) {
                    nomes.append(nomeOrdenado);
                }

                JOptionPane.showMessageDialog(this, nomes.toString());
            }
                break;

            case "Total de Salários":
            if (arquivo.getFuncionarios().isEmpty()) {
                JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
            } else {
                BigDecimal totalSalarios = new BigDecimal("0");

                NumberFormat formatarSalario = DecimalFormat.getInstance(new Locale("pt", "BR"));
                formatarSalario.setMinimumFractionDigits(2);
                for(Funcionario f : arquivo.getFuncionarios()){
                    totalSalarios = totalSalarios.add(f.getSalario());
                }
                String totalSalarioFormatado = formatarSalario.format(totalSalarios);
                JOptionPane.showMessageDialog(this, "A soma total de salario é de " + totalSalarioFormatado);
            }

                break;

            case "Salários Mínimos por Funcionário":
            if (arquivo.getFuncionarios().isEmpty()) {
                JOptionPane.showMessageDialog(this, "A lista de funcionários está vazia.");
            } else {

                String nomeFunc ="";
                Double resultadoFinal=0.0;
                String listaFinal="";
                
                BigDecimal salarioMin = new BigDecimal("1212");
                for(Funcionario f : arquivo.getFuncionarios()){
                    nomeFunc = f.getNome();
                    BigDecimal salario = f.getSalario();
                    BigDecimal resultado = salario.divide(salarioMin, 1, BigDecimal.ROUND_HALF_UP);
                    resultadoFinal = resultado.doubleValue(); 
                    
                    listaFinal += nomeFunc + ", " + resultadoFinal + " salarios minimos\n";
                }
                JOptionPane.showMessageDialog(this, listaFinal);
            }
                break;

            case "Sair":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Ação não reconhecida");
        }

    }
}
