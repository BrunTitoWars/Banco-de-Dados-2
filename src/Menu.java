import java.sql.*;
import java.util.Scanner;

public class Menu {
    
    private DatabaseFunctions dbFunctions;
    private String role;

    public Menu(DatabaseFunctions dbFunctions, String role) {
        this.dbFunctions = dbFunctions;
        this.role = role;
    }

    public void mostrarMenu() throws SQLException {
 
        Scanner s = new Scanner(System.in);

        if ("administrador".equals(role)) {
            mostrarMenuAdministrador(s);
        } else if ("gerente".equals(role)) {
            mostrarMenuGerente(s);
        } else if ("funcionario".equals(role)) {
            mostrarMenuFuncionario(s);
        } else {
            System.out.println("Usuário desconhecido!");
        }

    }

    private void mostrarMenuAdministrador(Scanner s) throws SQLException {

        int op = -1;
        do {
            System.out.println("Menu do Administrador");
            System.out.println("1. Criar Banco de Dados");
            System.out.println("2. Destruir Banco de Dados");
            System.out.println("3. Cadastrar Produto");
            System.out.println("4. Cadastrar Cliente");
            System.out.println("5. Realizar Venda");
            System.out.println("6. Reajustar Salário");
            System.out.println("7. Sorteio Cliente");
            System.out.println("8. Ver Estatísticas");
            System.out.println("0. Sair");
            op = s.nextInt();
    
            try {
                switch (op) {
                    case 1:
                        dbFunctions.createDatabase();
                        break;
                    case 2:
                        dbFunctions.destroyDatabase();
                        break;
                    case 3:
                        cadastrarProduto(s);
                        break;
                    case 4:
                        cadastrarCliente(s);
                        break;
                    case 5:
                        realizarVenda(s);
                        break;
                    case 6:
                        reajusteSalario(s);
                        break;
                    case 7:
                        dbFunctions.sorteioCliente();
                        break;
                    case 8:
                        dbFunctions.verEstatisticas();
                        break;
                    case 0:
                        System.out.println("Volte Sempre!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (op != 0);
    }

    private void mostrarMenuGerente(Scanner s) {

        int op = -1;
        do {
            System.out.println("Menu Gerente:");
            System.out.println("1. Visualizar Registros");
            System.out.println("2. Atualizar Registro");
            System.out.println("3. Deletar Registro");
            System.out.println("0. Sair");
            op = s.nextInt();

            try {
                switch (op) {
                    case 1:
                        visualizarRegistros(s);
                        break;
                    case 2:
                        atualizarRegistro(s);
                        break;
                    case 3:
                        deletarRegistro(s);
                        break;
                    case 0:
                        System.out.println("Volte Sempre!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (op != 0);
    }

    private void mostrarMenuFuncionario(Scanner s) {

        int op = -1;
        do {
            System.out.println("Menu do Funcionário");
            System.out.println("1. Visualizar Registros");
            System.out.println("2. Inserir Registro");
            System.out.println("0. Sair");
            op = s.nextInt();

            try {
                switch (op) {
                    case 1:
                        visualizarRegistros(s);
                        break;
                    case 2:
                        inserirRegistro(s);
                        break;
                    case 0:
                        System.out.println("Volte Sempre!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (op != 0);
    }

    private void cadastrarProduto(Scanner s) throws SQLException {
        System.out.print("Nome do Produto: ");
        String nome = s.next();
        System.out.print("Quantidade: ");
        int quantidade = s.nextInt();
        System.out.print("Descrição: ");
        String descricao = s.next();
        System.out.print("Valor: ");
        double valor = s.nextDouble();

        dbFunctions.cadastrarProduto(nome, quantidade, descricao, valor);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void cadastrarCliente(Scanner s) throws SQLException {
        System.out.print("Nome do Cliente: ");
        String nome = s.next();
        System.out.print("Sexo (m/f/o): ");
        String sexo = s.next();
        System.out.print("Idade: ");
        int idade = s.nextInt();
        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        String nascimento = s.next();

        dbFunctions.cadastrarCliente(nome, sexo, idade, Date.valueOf(nascimento));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void realizarVenda(Scanner s) throws SQLException {
        System.out.print("ID do Vendedor: ");
        int idVendedor = s.nextInt();
        System.out.print("ID do Cliente: ");
        int idCliente = s.nextInt();
        System.out.print("ID do Produto: ");
        int idProduto = s.nextInt();

        dbFunctions.realizarVenda(idVendedor, idCliente, idProduto);
        System.out.println("Venda realizada com sucesso!");
    }

    private void reajusteSalario(Scanner s) throws SQLException {
        System.out.print("Digite o percentual de reajuste: ");
        double percentual = s.nextDouble();
        System.out.print("Digite a categoria (vendedor, gerente, CEO): ");
        String categoria = s.nextLine();

        dbFunctions.reajusteSalario(percentual, categoria);
        System.out.println("Reajuste aplicado com sucesso!");
    }

    public void visualizarRegistros(Scanner s) throws SQLException {
        System.out.print("Digite o nome da tabela: ");
        String tabela = s.nextLine();
        
        dbFunctions.visualizarRegistros(tabela);
    }

    public void atualizarRegistro(Scanner s) throws SQLException {
        System.out.print("Digite o nome da tabela: ");
        String tabela = s.nextLine();
        System.out.print("Digite o nome da coluna a ser atualizada: ");
        String coluna = s.nextLine();
        System.out.print("Digite o novo valor: ");
        String valor = s.nextLine();
        System.out.print("Digite a condição (ex: id=1): ");
        String condicao = s.nextLine();
        
        dbFunctions.atualizarRegistro(tabela, coluna, valor, condicao);
        System.out.println("Registro atualizado com sucesso!");
    }

    public void deletarRegistro(Scanner s) throws SQLException {
        System.out.print("Digite o nome da tabela: ");
        String tabela = s.nextLine();
        System.out.print("Digite a condição (ex: id=1): ");
        String condicao = s.nextLine();
        
        dbFunctions.deletarRegistro(tabela, condicao);
        System.out.println("Registro deletado com sucesso!");
    }

    public void inserirRegistro(Scanner s) throws SQLException {
        System.out.print("Digite o nome da tabela: ");
        String tabela = s.nextLine();
        System.out.print("Digite os valores separados por vírgula (ex: 'valor1', 'valor2', ...): ");
        String valores = s.nextLine();

        dbFunctions.inserirRegistro(tabela, valores);
        System.out.println("Registro inserido com sucesso!");
    }
}