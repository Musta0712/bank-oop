package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

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

       Account account2 = bank.findAccount("ES0004");

        if (account2 != null) {
            account2.deposit(300);
        } else {
            System.out.println("No existe la cuenta");
        }

        Customer customer = bank.findAccountCustomer("ES0001");
        if (customer != null){
            customer.showInfo();
        }else {
            System.out.println("Cuenta no encontrada");
        }
    }
}
