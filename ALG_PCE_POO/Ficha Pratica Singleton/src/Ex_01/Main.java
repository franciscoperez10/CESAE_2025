//package Ex_01;
//
//public class Main {
//    public static void main(String[] args) {
//
//        DatabaseConnection db1 = new DatabaseConnection.getInstance ("localhost: 8000", "USER1", "PASS");
//        DatabaseConnection db2 = new DatabaseConnection.getInstance ("localhost: 7000", "USER2", "PASS");
//
//        System.out.println("___________________________________________________________");
//        System.out.println(db1.getPassword());
//        System.out.println(db2.getPassword());
//        System.out.println("___________________________________________________________");
//
//        db2.setPassword("999");
//
//        System.out.println("___________________________________________________________");
//        System.out.println(db1.getPassword());
//        System.out.println(db2.getPassword());
//        System.out.println("___________________________________________________________");
//    }
//}