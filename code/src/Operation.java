
public class Operation{
    private double operand1;
    private double operand2;
    private String operator;
    private int numTokens;
    public Operation(){
        this.operand1 = 0.0;
        this.operand2 = 0.0;
        this.operator = "";
        this.numTokens = 0;
    }
    public Operation(double operand1, double operand2, String operator, int numTokens){
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.numTokens = numTokens;
    }
    // getters and setters
    public double getOperand1() {
        return operand1;
    }
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }
    public double getOperand2() {
        return operand2;
    }
    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public int getNumTokens() {
        return numTokens;
    }
    public void setNumTokens(int numTokens) {
        this.numTokens = numTokens;
    }
}