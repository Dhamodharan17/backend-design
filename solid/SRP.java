import java.math.BigDecimal;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class SRP {
    // target class - Account, Account Operations - check it follows SRP
    // SRP - class should only contains methods and attributes realted to itself only.
}

@Getter
@Setter
class Account{
    private int accountNumber;
    private String firstName;
    private BigDecimal totalAmonut;
}

class AccountOperations{
    // local storage
    private static Map<Integer,Account> accountMap = new HashMap<>();
    
    public void addAccount(Account account){
        accountMap.put(account.getAccountNumber(), account);
    }

    public Account geAccount(int accountNumber){
        return accountMap.get(accountNumber);
    }

    // responsiblity of Account - add, get, delete account
    // deposit is not responisbility of Account
    public void deposit(int amount,int accountNumber){
        // deposit operation
        accountMap.get(accountNumber).getTotalAmonut().add(amount);
    }

}

class TransactionOperations{

    public void deposit(BigDecimal amount,int accountNumber){
        // get account details from account operation
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.geAccount(accountNumber);
        account.setTotalAmout(account.getTotalAmonut().add(amount));
    }

    public void withdraw(BigDecimal amount,int accountNumber){
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.geAccount(accountNumber);
        account.setTotalAmout(account.getTotalAmonut().subtract(amount));
    }


}
