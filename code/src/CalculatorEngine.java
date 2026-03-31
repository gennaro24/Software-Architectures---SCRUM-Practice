
// This class is created to abstract the main operation of a calculator. It provides basic arithmetic operation.
public class CalculatorEngine{
    // this variable is used to store the result of the last operation, accessed by getAns() method
    private double ans = 0.0;
    // this variable is used to perform memory operations.
    private double memory = 0.0;
    public double add(double a, double b){
        ans = a + b;
        return ans;
    }
    public double sub(double a, double b){
        ans = a - b;
        return ans;
    }
    public double mul(double a, double b){
        ans = a * b;
        return ans;
    }
    public double div(double a, double b){
        if(b == 0){
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        ans = a / b;
        return ans;
    }
    public double pow(double a, double exp){
        ans = Math.pow(a, exp);
        return ans;
    }
    public double cos(double a){
        ans = Math.cos(Math.toRadians(a));
        return ans;
    }
    public double sin(double a){
        ans = Math.sin(Math.toRadians(a));
        return ans;
    }
    public double getAns(){
        return ans;
    }
    public void clearAns(){
        ans = 0.0;
    }
    public double setAns(double a){
        ans = a;
        return ans;
    }
    public void clearMemory(){
        memory = 0.0;
    }
    public double getMemory(){
        return memory;
    }
    public void setMemory(double a){
        memory = a;
    }
    
}