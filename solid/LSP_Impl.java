package com.backend.solid;
import java.time.LocalDate;
import lombok.AllArgsConstructor;


public class With_LSP {
    // LSP -> whenever parent is required, we should able to pass child and successfully perform the operation, so we should able to code such
    public static void main(String[] args) {
        
        // Substituting HomeLoan (subtype) for SecureLoan (supertype)
        SecureLoan secureLoan = new HomeLoan();
        LoanClosureService loanClosureService = new LoanClosureService(secureLoan);
        loanClosureService.foreCloseLoan();  // Should print: Loan Closed at <current date>

        // Substituting CreditCardLoan (subtype) for LoanPayment (supertype)
        LoanPayment loanPayment = new CreditCardLoan();
        loanPayment.doPayment(67890);  // Should print: Payment Done for 67890
    }
}

@AllArgsConstructor
class LoanClosureService{
  // LSP -> whenever parent is required, we should able to pass child and successfully perform the operation
  //here required is SecureLoan we are passing HomeLoan
    private SecureLoan secureLoan;

    public void foreCloseLoan(){
        secureLoan.foreCloseLoan();
    }
}

//parent I
interface LoanPayment{
    public void doPayment(int account);
}

//child I
interface SecureLoan extends LoanPayment{
    public void foreCloseLoan();
    public void doRepayment();
}

class HomeLoan implements SecureLoan{

    @Override
    public void doPayment(int account) {
       System.out.println("Payment Done for "+account);
    }

    @Override
    public void foreCloseLoan() {
       System.out.println("Loan Closed at "+LocalDate.now());
    }

    @Override
    public void doRepayment() {
      System.out.println("Re-Payment Done");
    }
    
}

class CreditCardLoan implements LoanPayment{

    @Override
    public void doPayment(int account) {
        System.out.println("Payment Done for "+account);
    }

}
