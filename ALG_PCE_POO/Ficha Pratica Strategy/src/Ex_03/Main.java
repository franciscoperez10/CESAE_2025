package Ex_03;

public class Main {
    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator(new StandardShippingStrategy());
        double custo = calculator.calculateShippingCost(10.0);
        System.out.println("Custo de portes padrão: €" + custo);

        calculator = new ShippingCalculator(new ExpressShippingStrategy());
        custo = calculator.calculateShippingCost(10.0);
        System.out.println("Custo de portes expresso: €" + custo);

        calculator = new ShippingCalculator(new OvernightShippingStrategy());
        custo = calculator.calculateShippingCost(10.0);
        System.out.println("Custo de portes noturno: €" + custo);
    }
}
