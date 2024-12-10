package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp3 {
    private final BankReader bankReader;

    public BankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run(){
        Bank bank = bankReader.read();

        bank.showAccount();

        Account account = bank.findAccount("ES0003");
        if ( account != null){
            account.deposit(-50);
        }else{
            System.out.println("No existe la cuenta");
        }

        bank.accounts("000X");
    }
}
