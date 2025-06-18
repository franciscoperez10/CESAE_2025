package Ex_02;

public class FabricaTacos {

    public static Taco criarTaco(String tipo) {
        switch (tipo) {
            case "frango":
                return new CarneFrango("Taco de Carne de Frango");
            case "vaca":
                return new CarneVaca("Taco de Carne de Vaca");
            case "vegetariano":
                return new Vegetariano("Taco Vegetariano");
            default:
                throw new IllegalArgumentException("Tipo de Taco não existente");
        }
    }
}
