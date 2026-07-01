import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> rates = new HashMap<>();

        // Base Currency = INR
        rates.put("INR", 1.0);
        rates.put("USD", 0.012);
        rates.put("EUR", 0.011);
        rates.put("GBP", 0.009);
        rates.put("JPY", 1.73);

        System.out.println("========== Currency Converter ==========");

        System.out.println("Available Currencies");
        System.out.println("INR");
        System.out.println("USD");
        System.out.println("EUR");
        System.out.println("GBP");
        System.out.println("JPY");

        System.out.print("\nEnter Base Currency: ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency: ");
        String target = sc.next().toUpperCase();

        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println("Invalid Currency!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        // Convert to INR then target currency
        double amountInINR = amount / rates.get(base);
        double converted = amountInINR * rates.get(target);

        System.out.printf("\n%.2f %s = %.2f %s\n",
                amount, base, converted, target);

        sc.close();
    }
}