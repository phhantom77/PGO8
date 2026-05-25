public class Exercise2Main {
    public static void main(String[] args) {
        ServiceOrder order = new ServiceOrder("Alpha Company", 10, 120.0);
        PriceCalculator calculator = new PriceCalculator();

        PriceStrategy standard = o -> o.hours() * o.hourRate();
        PriceStrategy discount = o -> o.hours() * o.hourRate() * 0.90;
        PriceStrategy weekend = o -> o.hours() * o.hourRate() * 1.25;

        System.out.println("Standard price: " + calculator.calculate(order, standard));
        System.out.println("Discount price: " + calculator.calculate(order, discount));
        System.out.println("Weekend price: " + calculator.calculate(order, weekend));
    }
}

