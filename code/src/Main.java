import java.util.Locale;
import java.util.Scanner;



public class Main{
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        CalculatorEngine calculatorEngine = new CalculatorEngine();
        CalculatorParser calculatorParser = new CalculatorParser();

        calculatorEngine.setAns(0.0);

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
                double Ans;
                Operation operation = calculatorParser.parse(line, calculatorEngine.getAns(), 0);
                
                CalculatorEngine calculator = new CalculatorEngine();
        
                if(operation.getNumTokens() == 3){
                    switch (operation.getOperator()) {
                        case "+":
                            Ans = calculator.add(operation.getOperand1(), operation.getOperand2());
                            break;
                        case "-":
                            Ans = calculator.sub(operation.getOperand1(), operation.getOperand2());
                            break;
                        case "*":

                            break;
                        case "/":
                            break;
                        default:
                            System.err.println("Operazione non valida");
                            break;
                    }
                }

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