package com.backend.solid;

import lombok.AllArgsConstructor;


public class WithOut_LSP {

    public static void main(String[] args) {

    // Cannot Substituting CreditCardLoan (subtype) LoanPayment SecureLoan (supertype)
        // if we do we get unimplemented error or in production crash
        // This happens because the subtype does not fully adhere to the contract defined by the supertype.
        CreditCardLoan c = new CreditCardLoan();
        LoanClosureService loanPayment = new LoanClosureService(c);
        loanPayment.foreCloseLoan();//unsupported message
    }
}

@AllArgsConstructor
class LoanClosureService{
    // Cannot Substituting CreditCardLoan (subtype) LoanPayment SecureLoan (supertype)
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
