//package Ex_01;
//
//import javax.xml.crypto.Data;
//
//public class DatabaseConnection {
//    private static DatabaseConnection instance;
//
//    private String connectionString;
//    private String username;
//    private String password;
//
//    private DatabaseConnection (String connectionString, String username, String password) {
//        this.connectionString = connectionString;
//        this.username = username;
//        this.password = password;
//    }
//
//    public static DatabaseConnection getInstance(String connectionString) {
//        if (instance == null) {
//            instance = new DatabaseConnection(connectionString);
//        }
//        return instance;
//        }
//    }
//
//    public void connect () {
//        System.out.println("Conectado à base de dados" + connectionString);
//    }
//
//    public void disconnect () {
//        System.out.println("Desconectado à base de dados" + connectionString);
//
//}
