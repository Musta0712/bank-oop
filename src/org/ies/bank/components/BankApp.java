package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {

    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        int option;

        do {
            option = chooseOption();

            //1. Mostrar las cuentas del banco

            if (option == 1) {
                bank.showAccount();

                //2. Mostrar datos de una cuenta
                //- Se pide un IBAN
                //- Se busca la cuenta con ese IBAN.
                //- Si no existe se muestra el mensaje "No existe la cuenta", si existe se muestra en pantalla

            } else if (option == 2) {
                System.out.println("Introduce el IBAN");
                String iban = scanner.nextLine();
                bank.findAccount(iban);

                //3.Mostrar los datos de las cuentas de un cliente
                //- Se pide un nif
                //- Se recorren las cuentas comprobando si son del cliente con ese nif. Se muestran en pantalla

            } else if (option == 3) {
                System.out.println("Introduce el NIF");
                String nif = scanner.nextLine();
                bank.showAccountNif(nif);
                for (Account account : bank.getAccounts()) {
                    if (account.getCustomer().getNif().equals(nif)) {
                        account.showInfo();
                    }
                }

                //4. Ingresar dinero en cuenta
                //- Se pide un IBAN
                //- Se pide una cantidad de dinero
                //- Se busca la cuenta con el IBAN.
                //- Si no existe se muestra el mensaje "No existe la cuenta"
                //- Si existe se modifica el saldo, añadiendo la cantidad.
                //- Se muestra la cuenta

            } else if (option == 4) {
                System.out.println("Introduce un IBAN");
                String iban = scanner.nextLine();
                System.out.println("Introduce la cantidad de dinero");
                double amount;
                do {
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount < 0);
                    System.out.println("Solo puede ingresar numeros positivos");
                } while (amount < 0);
                bank.deposit(iban, amount);


                //5. Sacar dinero de una cuenta
                //- Se pide un IBAN
                //- Se pide una cantidad de dinero
                //- Se busca la cuenta con el IBAN.
                //- Si no existe se muestra el mensaje "No existe la cuenta"
                //- Si hay suficiente saldo, se reduce el saldo. Si no hay suficiente saldo se muestra "Saldo insuficiente"
                //- Se muestra la cuenta

            } else if (option == 5) {
                System.out.println("Introduce un IBAN");
                String iban = scanner.nextLine();
                System.out.println("Introduce la cantidad de dinero");
                double amount;
                do {
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount < 0) ;
                    System.out.println("Solo puedes retirar numeros positivos");
                } while (amount < 0);
                bank.deposit(iban, -amount);

            }else if (option==6){
                System.out.println("Introduce el nif de la cuenta");
                String nif = scanner.nextLine();

                int customerAccountNumber = bank.countCustomerAccounts(nif);
                System.out.println("El cliente tiene " + customerAccountNumber + "cuentas.");
            }else if (option == 7) {
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();

                bank.showAccountCustomer(iban);
            }
        } while (option != 8);
    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("Bienvenido!!!");
            System.out.println("1. Mostrar las cuentas de un banco");
            System.out.println("2. Mostrar los datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option < 1 || option > 6);
        return option;
    }
}
