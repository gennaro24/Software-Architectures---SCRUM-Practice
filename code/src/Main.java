import CalculatorEngine;

public class Main{
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        CalculatorEngine calculatorEngine = new CalculatorEngine();
        CalculatorEngine.setAns(0.0);
        CalculatorEngine.setMemory(0.0);

        printWelcome();


        while (true) {
            System.out.print("\ncalc> ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }
            
            String lower = line.toLowerCase(Locale.ROOT);
            if (lower.equals("exit") || lower.equals("quit")) {
                System.out.println("Chiusura calcolatrice.");
                break;
            }
            if (lower.equals("help")) {
                printHelp();
                continue;
            }

            try {
                Operation operation = calculatorEngine.parse(line, calculatorEngine.getAns(), calculatorEngine.getMemory());
                
            } catch (Exception e) {
            }
        }

        scanner.close();
    }


    private static void printHelp() {
        System.out.println("1. sum: write a + b ");
        System.out.println("2. sub: write a - b ");
        System.out.println("3. mul: write a * b ");
        System.out.println("4. div: write a / b ");
        System.out.println("5. cos: write cosA ");
        System.out.println("6. sin: write sinA ");
        System.out.println("7. ans: write ans to get the result of the last operation ");
        System.out.println("8. clear: write clear to reset the ans variable ");
        System.out.println("9. exit: write exit to quit the program ");
        
    }
    private static void printWelcome() {
        System.out.println("Calcolatrice Java (CLI)");
        System.out.println("Scrivi 'help' per vedere i comandi, 'exit' per uscire.");
    }
}