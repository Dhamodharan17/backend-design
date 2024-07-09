class DIP{
  main(){
// as per DIP - high level modules shouldnot direcy depend on low levle modules but here we have it
    // calculator directly calling add operation class, so we need to add an abstraction
    
  }
}

//module - calculator
 class Calculator {
    public int calculate(int a,int b, String operation){
        int result = 0;
        switch (operation){
            case "add":
                AddOperation addOperation = new AddOperation();
                result = addOperation.add(a,b);
            case "sub":
                SubOperation subOperation = new SubOperation();
                result = subOperation.sub(a,b);
        }
        return result;
    }
}


//This operations are called as sub module in the system
public class AddOperation {
    public int add(int a, int b){
        return a+b;
    }
}

class SubOperation {
    public int sub(int a, int b){
        return a-b;
    }
}

