class DIP{

  main(){
    
    // high level modules shouldn't depend on low level modules
    // both should depend on abstraction
    // we need to see abstraction(I) before writing logic for ut
    
  }
}

/**
 * As per DIP rule it states :
 
 * High-level modules should not depend on low-level modules. Both should depend on abstractions.
 * --- So low level is depdendent via CalculatorOperation rather being depend on add or substract operations.
 
 * Abstractions should not depend on details(Imple). Details(Impl) should depend on abstractions
 * ---Abstraction is achieved as via interface we are entering in low level.
 */
public class Calculator {
    public int calculate(int a,int b, CalculatorOperation operation){
        return operation.calculate(a,b);
    }
}
/**
 * This is low level modules interface so anything
 * to invoke in lowlevel modules needs to go via this interface
 * by this we will achieve both loossely couple between high level and low level moduler
 * and abstration as well.
 */
public interface CalculatorOperation {
    public int calculate(int a,int b);
}

**
 * So we will have this class but it will be taken care
 * via interface implementation.
 *
 */
public class AddOperation implements CalculatorOperation {
    public int calculate(int a, int b){
        return a+b;
    }
}

/**
 * One more sub module for substration
 */
public class SubOperation  implements CalculatorOperation{
    public int calculate(int a, int b){
        return a-b;
    }
}
