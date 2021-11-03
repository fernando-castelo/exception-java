package application;

import entities.Conta;
import exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial Balance: ");
            Double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withDrawLimit = sc.nextDouble();

            Conta conta = new Conta(number, holder, balance, withDrawLimit);
            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();

            try {
            conta.withDraw(amount);
            System.out.printf("New balance: %.2f", conta.getBalance());

            } catch (BusinessException e) {
            System.out.println("Error in withdraw: " + e.getMessage());
            }
            sc.close();
    }
}
