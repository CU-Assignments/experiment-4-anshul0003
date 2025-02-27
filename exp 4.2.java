import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

// Card class to represent each playing card
class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

// Main class to manage the card collection
public class CardCollection {
    private static Collection<Card> cardCollection = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Display All Cards");
            System.out.println("3. Find Cards by Symbol");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    displayCards();
                    break;
                case 3:
                    findCardsBySymbol();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to add a new card
    private static void addCard() {
        System.out.print("Enter Card Symbol (Hearts, Diamonds, Clubs, Spades): ");
        String symbol = scanner.nextLine();

        System.out.print("Enter Card Value (e.g., Ace, 2, King): ");
        String value = scanner.nextLine();

        cardCollection.add(new Card(symbol, value));
        System.out.println("Card added successfully!");
    }

    // Method to display all cards
    private static void displayCards() {
        if (cardCollection.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            System.out.println("\nAll Cards:");
            for (Card card : cardCollection) {
                System.out.println(card);
            }
        }
    }

    // Method to find cards by symbol
    private static void findCardsBySymbol() {
        System.out.print("Enter Symbol to search (Hearts, Diamonds, Clubs, Spades): ");
        String symbol = scanner.nextLine();

        boolean found = false;
        System.out.println("\nCards in " + symbol + ":");
        for (Card card : cardCollection) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }
}
