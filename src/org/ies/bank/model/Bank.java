package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    // Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)

    public void showAccount() {
        for (Account account : accounts) {
            account.showInfo();
        }
    }

    // Dado un IBAN, mostrar la información de la cuenta con ese IBAN.

    public void showAccountIban(String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                account.showInfo();
            }
        }
    }

    // Dado un NIF, mostrar todas las cuentas del cliente con ese NIF

    public void showAccountNif(String nif) {
        for (Account account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }


    // Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN.
    // Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"

    public Account findAccount(String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public void showIbanBalance(String iban, double balance) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                account.setBalance(account.getBalance() + balance);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
