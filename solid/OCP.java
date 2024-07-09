package com.backend.solid;

public class OCP {

    public static void main(String[] args) {

          Calculator calculator = new Calculator();
          //create required operations
          Operation addOperation = new AddOperation();
          int result = calculator.calculateNumber(10, 5, addOperation);
          
          System.out.println("The result of addition is: " + result);
      }
  }
  
  
  // bad calculator design - we need to touch exisiting code if we want another operation
  class BadCalculator{
      public int calculateNumber(int number1,int number2, String type){
          int result=0;
          switch (type) {
              case "sun":
                  result = number1+number2;
                  break;
              case "sub":
                  result = number1-number2;
                  break;
              default:
                  break;
          }
          return result;
      }
  }
  
  //good design - no need to touch exisiting code, create another operation class 
  
  interface Operation{
      public int perfrom(int number1,int number2);
  }
  
  class AddOperation implements Operation{
      public int perfrom(int number1,int number2){
          return number1+number2;
      }
  }
  
  class SubOperation implements Operation{
      public int perfrom(int number1,int number2){
          return number1-number2;
      }
  }
  
  class Calculator{
      public int calculateNumber(int number1,int number2,Operation operation){
          return operation.perfrom(number1, number2);
      }
  }
