package entities;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import exceptions.BussinessExceptions;

public class Teste {

    public static void main(String[]args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Informe os dados da conta: ");

            // TODO: Protegendo toda a leitura de dados
            System.out.print("Numero: ");
            Integer number = sc.nextInt();

            System.out.print("Titular: ");
            sc.nextLine(); // limpa buffer
            String holder = sc.nextLine();

            System.out.print("Saldo inicial: ");
            Double balance = sc.nextDouble();

            System.out.print("Limite de saque: ");
            Double withdrawLimit = sc.nextDouble();

            Account acc = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Informe uma quantia para saque: ");
            double amount = sc.nextDouble();

            acc.withdraw(amount);
            System.out.printf("Novo saldo da conta: %.2f%n", acc.getBalance());
        }
        catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida: use apenas números válidos.");
        }
        catch (BussinessExceptions e) {
            System.out.println("❌ Erro de negócio: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("❌ Erro inesperado: " + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
 }
