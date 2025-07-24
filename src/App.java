import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BussinessExceptions;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta: ");
        System.out.print(" Numero: ");
        Integer number = sc.nextInt();
        System.out.print(" Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print(" Saldo inicial: ");
        Double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        Double withdrawLimit = sc.nextDouble();


        Account acc = new Account(number,holder,balance,withdrawLimit);

        System.out.println();
        System.out.print("Informe uma quantia para saque: ");
        double amount = sc.nextDouble();

       
            try {
                acc.withdraw(amount);
                System.out.printf("Novo saldo da conta %.2f%n ", acc.getBalance());
            }
            catch (BussinessExceptions e){
                System.out.println(e.getMessage());
            }
            


        sc.close();




    }
}
