package org.ies.bank;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BanApp2;
import org.ies.bank.components.BankReader;
import org.ies.bank.components.CustomerReader;

import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerReader customerReader = new CustomerReader(scanner);
        AccountReader accountReader = new AccountReader(scanner, customerReader);
        BankReader bankReader = new BankReader(scanner, accountReader);
        BanApp2 bankApp2= new BanApp2(bankReader);

        bankApp2.run();
    }
}
