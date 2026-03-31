
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
        String[] tokens = input.split(" ");
        if(tokens.length == 3){
            Double operand1 = tokens[0].equalsIgnoreCase("ans" ) ? ans :
                              tokens[0].equalsIgnoreCase("mem") ?  mem :
                              Double.parseDouble(tokens[0]);
            Double operand2 = tokens[2].equalsIgnoreCase("ans" ) ? ans :
                              tokens[2].equalsIgnoreCase("mem") ?  mem :
                              Double.parseDouble(tokens[2]);
            String operator = tokens[1];
            operation.setOperand1(operand1);
            operation.setOperand2(operand2);
            operation.setOperator(operator);
            return operation;
        }
        if (tokens.length == 1){
            // salvataggio numero in ans dopo invio.
            if(tokens[0].equalsIgnoreCase("ans")){
                operation.setOperand1(ans);
                operation.setNumTokens(1);
                return operation;
            }
            if(tokens[0].equalsIgnoreCase("mem")){
                operation.setOperand1(mem);
                operation.setNumTokens(1);
                return operation;
            }
            //boilerplate
            return new Operation();

            
            // operazioni di memoria: mem (richiama ), memc (clear),
            // operazioni di ans: ans(richiama), ansc (clear) 

        }
        //boilerplate 
        return new Operation();
        // da completare per le operazioni di: 1. memoria e trigonometriche


    }
}