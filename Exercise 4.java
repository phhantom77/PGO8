@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}

class LibraryAccount {
    private String readerName;
    private int borrowedBooks;
    private int lateDays;

    public LibraryAccount(String readerName, int borrowedBooks, int lateDays) {
        this.readerName = readerName;
        this.borrowedBooks = borrowedBooks;
        this.lateDays = lateDays;
    }

    public String getReaderName() {
        return readerName;
    }

    public class FineCalculator {
        public double calculate() {
            return borrowedBooks * lateDays * 1.50;
        }
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        LibraryAccount account = new LibraryAccount("John Smith", 3, 5);
        LibraryAccount.FineCalculator calculator = account.new FineCalculator();

        double fine = calculator.calculate();

        MessagePrinter printer = message -> System.out.println("[LIBRARY] " + message);
        printer.print("Reader: " + account.getReaderName() + ", fine: " + fine + " PLN");
    }
}
