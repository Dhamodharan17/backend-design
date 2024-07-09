package com.backend.solid;

import lombok.AllArgsConstructor;


public class WithOut_LSP {
    
    public static void main(String[] args) {
        LoanPayment loanPayment = new CreditCardLoan();
        loanPayment.foreCloseLoan();//unsupported message
    }
}

@AllArgsConstructor
class LoanClosureService{
    private LoanPayment loanPayment;
    public void foreCloseLoan(){
        loanPayment.foreCloseLoan();
    }


}
// payment related options for loan account
interface LoanPayment{
    public void doPayment(int amount);
    public void foreCloseLoan();
    public void doRepayment();
}

class HomeLoan implements LoanPayment{

    @Override
    public void doPayment(int amount) {
        //logic
    }

    @Override
    public void foreCloseLoan() {
        //logic
    }

    @Override
    public void doRepayment() {
       //logic
    }
    
}

class CreditCardLoan implements LoanPayment{

    @Override
    public void doPayment(int amount) {
       //logic
    }

    @Override
    public void foreCloseLoan() {
        throw new UnsupportedOperationException("foreCloseLoan is not allowed");
    }

    @Override
    public void doRepayment() {
        throw new UnsupportedOperationException("doRepayment is not allowed");
    }
    
}
