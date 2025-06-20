package Ex_03;

public class StandardShippingStrategy implements ShippingStrategy {

    public double calculateCost(double peso) {
        return peso * 5.0;
    }
}
