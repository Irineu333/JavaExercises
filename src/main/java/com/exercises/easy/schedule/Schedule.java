package com.exercises.easy.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Crie um programa que simule uma agenda de contatos. <br>
 * O programa deve ter as seguintes entradas;
 * <ul>
 *     <li>1 - Adicionar contato</li>
 *     O programa deve registrar e guardar o nome, email e telefone do contato. Nessa ordem.
 *     <li>2 - Remove contato:</li>
 *     O programa  deve remover um contato pelo seu índice.
 *     <li>3 - Listar contatos:</li>
 *     O programa deve listar todos os contatos registrados, no seguinte formato: [indice] {nome} - [email] - {telefone}.
 *     <li>0 - Sair</li>
 *     O programa deve encerrar a execução.
 * </ul>
 * 1. Apenas os resultados dos comandos 3 serão considerados. <br>
 * 2. Veja a lista de erros a serem emitidos na classe Error desse pacote. <br>
 */
public class Schedule {

    private final List<Contact> contacts = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Schedule schedule = new Schedule();

        schedule.run();
    }

    private void run() {
        int op;

        do {

            System.out.println("1 - Add contact");
            System.out.println("2 - Remove contact");
            System.out.println("3 - List contacts");
            System.out.println("0 - Exit");

            System.out.print("Option: ");
            op = Integer.parseInt(scanner.nextLine());

            System.out.print("\n");

            switch (op) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    listContacts();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(Error.INVALID_OPTION.getMessage());
                    break;
            }

            System.out.print("\n");

        } while (op != 0);
    }

    private void listContacts() {

        if (contacts.isEmpty()) {
            System.out.println(Error.NO_CONTACTS.getMessage());
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {

            Contact contact = contacts.get(i);

            System.out.printf("[%d] %s\n", i, contact);
        }
    }

    private void removeContact() {

        System.out.print("Contact index: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= contacts.size()) {
            System.out.println(Error.INVALID_INDEX.getMessage());
            return;
        }

        contacts.remove(index);
    }

    private void addContact() {

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        contacts.add(new Contact(name, email, phoneNumber));
    }
}
