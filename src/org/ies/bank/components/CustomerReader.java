package org.ies.bank.components;

import org.ies.bank.model.Customer;

import java.util.Scanner;

public class CustomerReader {
    private final Scanner scanner;

    public CustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer read(){
        System.out.println("Introduce los datos del cliente");
        System.out.println("Introduce el NIF: ");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nombre: ");
        String name = scanner.nextLine();
        System.out.println("Introduce el apellido: ");
        String surname = scanner.nextLine();

        return new Customer(
                nif,
                name,
                surname
        );
    }
}
