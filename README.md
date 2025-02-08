# Sistema de Gestão de Funcionários

Este é um sistema de gestão de funcionários desenvolvido em Java. Ele permite inserir, remover, atualizar, agrupar e imprimir informações de funcionários, além de realizar cálculos financeiros como o total de salários e salários mínimos por funcionário.

## Funcionalidades

O sistema possui as seguintes funcionalidades:

1. **Inserir Funcionários**: Carrega a lista de funcionários a partir de um arquivo e insere-os no sistema.
2. **Remover João**: Remove o funcionário chamado "João" da lista de funcionários.
3. **Imprimir Funcionários**: Exibe os dados de todos os funcionários com as informações de data de nascimento e salário formatadas.
4. **Aplicar Aumento**: Aplica um aumento de 10% no salário de todos os funcionários.
5. **Agrupar por Função**: Agrupa os funcionários por função e exibe esse agrupamento.
6. **Imprimir por Função**: Exibe os funcionários agrupados por suas respectivas funções.
7. **Aniversariantes (Out/Dez)**: Imprime os funcionários que fazem aniversário nos meses de outubro e dezembro.
8. **Funcionário Mais Velho**: Exibe o nome e a idade do funcionário mais velho.
9. **Ordenar por Nome**: Ordena e exibe os funcionários por ordem alfabética.
10. **Total de Salários**: Exibe o total dos salários dos funcionários.
11. **Salários Mínimos por Funcionário**: Exibe o número de salários mínimos que cada funcionário ganha, considerando o salário mínimo de R$1212.

## Estrutura do Projeto

O projeto possui as seguintes classes:

### 1. **Classe `Pessoa`**
- Atributos:
  - `nome`: Nome da pessoa (String).
  - `dataNasc`: Data de nascimento da pessoa (LocalDate).
  
### 2. **Classe `Funcionario`**
- Atributos:
  - Herda os atributos da classe `Pessoa`.
  - `salario`: Salário do funcionário (BigDecimal).
  - `funcao`: Função do funcionário (String).

### 3. **Classe `TelaPrincipal`**
- Contém a interface gráfica para o usuário interagir com o sistema.
- Inclui botões para cada uma das funcionalidades descritas acima.

### 4. **Classe `Arquivo`**
- Responsável por ler os dados dos funcionários de um arquivo (não fornecido no código, mas esperado).

## Como Usar

### Passo 1: Inicializar o Sistema
- Ao rodar o programa, uma interface gráfica será exibida.
- O usuário pode interagir com os botões para realizar as ações desejadas.

### Passo 2: Funcionalidades Disponíveis
- **Inserir Funcionários**: Carrega os dados de funcionários de um arquivo e os insere na lista.
- **Remover João**: Se existir um funcionário chamado "João", ele será removido da lista.
- **Imprimir Funcionários**: Exibe uma lista formatada de todos os funcionários, com informações de nome, data de nascimento e salário.
- **Aplicar Aumento**: Aplica um aumento de 10% no salário de todos os funcionários.
- **Agrupar por Função**: Agrupa os funcionários por função e exibe.
- **Imprimir por Função**: Exibe os funcionários agrupados por função.
- **Aniversariantes (Out/Dez)**: Exibe os funcionários que fazem aniversário nos meses de outubro e dezembro.
- **Funcionário Mais Velho**: Exibe o nome e a idade do funcionário mais velho.
- **Ordenar por Nome**: Exibe os funcionários ordenados por nome.
- **Total de Salários**: Exibe o total de salários dos funcionários.
- **Salários Mínimos por Funcionário**: Exibe o número de salários mínimos que cada funcionário ganha, considerando o salário mínimo de R$1212.

### Passo 3: Sair
- O sistema pode ser fechado clicando no botão "Sair".

## Exemplo de Execução

Após inicializar o sistema, você verá uma tela com os seguintes botões:

- Inserir Funcionários
- Remover João
- Imprimir Funcionários
- Aplicar Aumento
- Agrupar por Função
- Imprimir por Função
- Aniversariantes (Out/Dez)
- Funcionário Mais Velho
- Ordenar por Nome
- Total de Salários
- Salários Mínimos por Funcionário
- Sair

Quando você clica em um dos botões, o sistema executa a ação correspondente e exibe uma mensagem ou uma lista de resultados.

## Dependências

- **Java 8 ou superior**: O sistema foi desenvolvido utilizando as bibliotecas do Java 8, como `LocalDate`, `BigDecimal`, e `Stream`.
- **Bibliotecas Externas**: Nenhuma biblioteca externa foi utilizada além das fornecidas pelo próprio Java.

## Como Compilar e Executar

1. **Compilação**:
   - Abra o terminal e navegue até o diretório do projeto.
   - Compile o projeto utilizando o comando `javac`.

   ```bash
   javac -d bin src/main/*.java
