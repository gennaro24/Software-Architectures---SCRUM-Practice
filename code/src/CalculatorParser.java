
public class CalculatorParser{
    private Operation operation;
    /** il parser prende in input la stringa dell'utente, che può essere
        nei seguenti formati:
     1. a operando b
     2. a
     3. cos a
     4. sen a
     5. ans può essere usato come operando
     6. mem può essere usato come operando
     A)Il parser principale discrimina il numero di token della stringa,
       e in base al numero decide che sotto-parser usare. ES: 3 TOKEN, 
       deve discriminare solo tra qual'è l'operando utilizzato.
     **/
    public Operation parse(String input, double ans, double mem){
        operation = new Operation();
        String[] tokens = input.trim().split("\\s+");

        if(tokens.length == 3){
            Double operand1 = parseValue(tokens[0], ans, mem);
            Double operand2 = parseValue(tokens[2], ans, mem);
            String operator = tokens[1];
            operation.setOperand1(operand1);
            operation.setOperand2(operand2);
            operation.setOperator(operator);
            operation.setNumTokens(3);
            return operation;
        }

        if (tokens.length == 1){
            String token = tokens[0];
            if (token.equalsIgnoreCase("ans")) {
                operation.setOperand1(ans);
                operation.setFlag("ans");
            } else if (token.equalsIgnoreCase("mem")) {
                operation.setOperand1(mem);
                operation.setFlag("mem");
            } else if (token.equalsIgnoreCase("memclear")) {
                operation.setFlag("memclear");
            } else if (token.equalsIgnoreCase("ansclear")) {
                operation.setFlag("ansclear");
            } else {
                operation.setOperand1(Double.parseDouble(token));
                operation.setFlag("0");
            }
            operation.setNumTokens(1);
            return operation;
        }

        if (tokens.length == 2) {
            String op = tokens[0].toLowerCase();
            double val = parseValue(tokens[1], ans, mem);

            operation.setOperator(op);
            operation.setNumTokens(2);

            if (op.equals("cos") || op.equals("sin")) {
                operation.setOperand1(val);
                return operation;
            }
            if (op.equals("mem+") || op.equals("mem-") || op.equals("setmem")) {
                operation.setOperand1(val);
                operation.setFlag(op);
                return operation;
            }
        }

        return new Operation();
    }

    private double parseValue(String token, double ans, double mem) {
        if (token.equalsIgnoreCase("ans")) {
            return ans;
        }
        if (token.equalsIgnoreCase("mem")) {
            return mem;
        }
        return Double.parseDouble(token);
    }
}