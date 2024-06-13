import java.sql.*;

public class DatabaseFunctions {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/empresa";
    private Connection conn = null;

    public DatabaseFunctions(String user, String pass) throws SQLException {
        conn = DriverManager.getConnection(DB_URL, user, pass);
    }

    public void cadastrarProduto(String nome, int quantidade, String descricao, double valor) throws SQLException {
        String comandoSQL = "INSERT INTO produto (nome, quantidade, descricao, valor) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(comandoSQL);
            ps.setString(1, nome);
            ps.setInt(2, quantidade);
            ps.setString(3, descricao);
            ps.setDouble(4, valor);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarCliente(String nome, String sexo, int idade, Date nascimento) throws SQLException {
        String comandoSQL = "INSERT INTO cliente (nome, sexo, idade, nascimento) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(comandoSQL);
            ps.setString(1, nome);
            ps.setString(2, sexo);
            ps.setInt(3, idade);
            ps.setDate(4, nascimento);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void realizarVenda(int idVendedor, int idCliente, int idProduto) throws SQLException {
        String comandoSQL = "{CALL realizar_venda(?, ?, ?)}";
        try {
            CallableStatement cs = conn.prepareCall(comandoSQL);
            cs.setInt(1, idVendedor);
            cs.setInt(2, idCliente);
            cs.setInt(3, idProduto);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void verEstatisticas() throws SQLException {
        String comandoSQL = "{CALL estatisticas_vendas()}";
        try {
            CallableStatement cs = conn.prepareCall(comandoSQL);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println("Resultado: " + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDatabase() throws SQLException {
        String comandoSQL = "CREATE DATABASE empresa";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(comandoSQL);
            System.out.println("Banco de dados criado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroyDatabase() throws SQLException {
        String comandoSQL = "DROP DATABASE empresa";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(comandoSQL);
            System.out.println("Banco de dados destruído com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reajusteSalario(double percentual, String categoria) throws SQLException {
        String comandoSQL = "{CALL reajuste_salarial(?, ?)}";
        try {
            CallableStatement cs = conn.prepareCall(comandoSQL);
            cs.setDouble(1, percentual);
            cs.setString(2, categoria);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sorteioCliente() throws SQLException {
        String comandoSQL = "{CALL sorteio_cliente()}";
        try {
            CallableStatement cs = conn.prepareCall(comandoSQL);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visualizarRegistros(String tabela) throws SQLException {
        String comandoSQL = "SELECT * FROM ";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(comandoSQL + tabela);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colunas = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= colunas; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarRegistro(String tabela, String coluna, String valor, String condicao) throws SQLException {
        String comandoSQL = "UPDATE " + tabela + " SET " + coluna + " = '" + valor + "' WHERE " + condicao;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(comandoSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarRegistro(String tabela, String condicao) throws SQLException {
        String comandoSQL = "DELETE FROM " + tabela + " WHERE " + condicao;
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(comandoSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirRegistro(String tabela, String valores) throws SQLException {
        String comandoSQL = "INSERT INTO " + tabela + " VALUES (" + valores + ")";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(comandoSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}