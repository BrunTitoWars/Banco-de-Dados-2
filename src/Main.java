import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("--Login--");
        System.out.print("Usuário: ");
        String USER = s.nextLine();
        System.out.print("Senha: ");
        String PASSWORD = s.nextLine();

        try {
            DatabaseFunctions dbFunctions = new DatabaseFunctions(USER, PASSWORD);
            String role = getRoleFromUsername(USER);

            if (role == null) {
                System.out.println("Usuário ou senha incorretos!");
                return;
            }

            Menu menu = new Menu(dbFunctions, role);
            menu.mostrarMenu();
            dbFunctions.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getRoleFromUsername(String username) {

        if ("administrador".equals(username)) {
            return "administrador";
        } else if ("gerente".equals(username)) {
            return "gerente";
        } else if ("funcionario".equals(username)) {
            return "funcionario";
        } else {
            return null;
        }
    }
}