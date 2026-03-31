import java.util.Locale;
import java.util.Scanner;



public class Main{
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        CalculatorEngine calculatorEngine = new CalculatorEngine();
        CalculatorParser calculatorParser = new CalculatorParser();

        calculatorEngine.setAns(0.0);
        calculatorEngine.setMemory(0.0);
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
                double ans;
                Operation operation = calculatorParser.parse(
                    line,
                    calculatorEngine.getAns(),
                    calculatorEngine.getMemory()
                );

                if(operation.getNumTokens() == 3){
                    switch (operation.getOperator()) {
                        case "+":
                            ans = calculatorEngine.add(operation.getOperand1(), operation.getOperand2());
                            System.out.println("= " + ans);
                            break;
                        case "-":
                            ans = calculatorEngine.sub(operation.getOperand1(), operation.getOperand2());
                            System.out.println("= " + ans);
                            break;
                        case "*":
                            ans = calculatorEngine.mul(operation.getOperand1(), operation.getOperand2());
                            System.out.println("= " + ans);
                            break;
                        case "/":
                            ans = calculatorEngine.div(operation.getOperand1(), operation.getOperand2());
                            System.out.println("= " + ans);
                            break;
                        default:
                            System.err.println("Invalid operation.");
                            break;
                    }
                }else if(operation.getNumTokens() == 2){
                    switch (operation.getOperator()) {
                        case "cos":
                            ans = calculatorEngine.cos(operation.getOperand1());
                            System.out.println("= " + ans);
                            break;
                        case "sin":
                            ans = calculatorEngine.sin(operation.getOperand1());
                            System.out.println("= " + ans);
                            break;
                        case "mem+":
                            calculatorEngine.setMemory(
                                calculatorEngine.getMemory() + operation.getOperand1()
                            );
                            System.out.println("= " + calculatorEngine.getMemory());
                            break;
                        case "mem-":
                            calculatorEngine.setMemory(
                                calculatorEngine.getMemory() - operation.getOperand1()
                            );
                            System.out.println("= " + calculatorEngine.getMemory());
                            break;
                        case "setmem":
                            calculatorEngine.setMemory(operation.getOperand1());
                            System.out.println("= " + calculatorEngine.getMemory());
                            break;
                        default:
                            System.err.println("Invalid operation.");
                            break;
                    }
                }else if(operation.getNumTokens() == 1){
                    if("0".equals(operation.getFlag())) {
                        ans = calculatorEngine.setAns(operation.getOperand1());
                        System.out.println("= " + ans);
                    }else if("ans".equalsIgnoreCase(operation.getFlag())) {
                        ans = calculatorEngine.getAns();
                        System.out.println("= " + ans);
                    }else if("mem".equalsIgnoreCase(operation.getFlag())) {
                        ans = calculatorEngine.getMemory();
                        System.out.println("= " + ans);
                    }else if("memclear".equalsIgnoreCase(operation.getFlag())) {
                        calculatorEngine.clearMemory();
                        System.out.println("= " + calculatorEngine.getMemory());
                    }else if("ansclear".equalsIgnoreCase(operation.getFlag())) {
                        calculatorEngine.clearAns();
                        System.out.println("= " + calculatorEngine.getAns());
                    }else {
                        System.err.println("Invalid flag.");
                        continue;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Formato numero non valido.");
                continue;
            } catch (IllegalArgumentException e) {
                System.err.println("Errore: " + e.getMessage());
                continue;
            } catch (Exception e) {
                System.err.println("Errore: " + e.getMessage());
            }
        }

        scanner.close();
    }


    private static void printHelp() {
        System.out.println("1. add: write a + b");
        System.out.println("2. sub: write a - b");
        System.out.println("3. mul: write a * b");
        System.out.println("4. div: write a / b");
        System.out.println("5. cos: write cos a");
        System.out.println("6. sin: write sin a");
        System.out.println("7. ans: write ans to read last result");
        System.out.println("8. set ans: write a (single number)");
        System.out.println("9. mem: write mem to read memory");
        System.out.println("10. mem add: write mem+ a");
        System.out.println("11. mem sub: write mem- a");
        System.out.println("12. set mem: write setmem a");
        System.out.println("13. clear ans: write ansclear");
        System.out.println("14. clear mem: write memclear");
        System.out.println("15. exit: write exit to quit");
        
    }
    private static void printWelcome() {
        System.out.println("Calcolatrice Java (CLI)");
        System.out.println("Scrivi 'help' per vedere i comandi, 'exit' per uscire.");
    }
}