package Ex_03;

public class ExpressShippingStrategy implements ShippingStrategy {

    public double calculateCost (double peso) {
        return peso * 10.0;
    }
}
