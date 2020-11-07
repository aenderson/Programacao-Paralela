package br.edu.iftm.prova1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Revesamento revesamento = new Revesamento();
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nPor conta da pandemia nossa academia está aceitando apenas 2 alunos por horário\nassim adotamos uma forma de revezamento para todos os alunos\n\n");
        System.out.println("selecione o horário: \n\n\tMENU\n1- 8:00\n2- 9:00\n3- 10:00\n4- 14:00\n5- 16:00\n6- 17:00\n7- 18:00");
        int horário = input.nextInt();
        int op1 = 0, op2 = 0;
        System.out.println("Qual o nome do aluno 1?");
        String nomea = input.next();
        revesamento.setNomea(nomea);
        System.out.println("\nE do aluno 2?");
        String nomeb = input.next();
        revesamento.setNomeb(nomeb);
        System.out.println("Qual treino do aluno 1?");
        System.out.println("\nMENU\n\n1- Treino de perna\n2- Treino de costas\n3- Treino de braços\n4- Treino isolado");
        op1 = input.nextInt();

        switch (op1) {
            case 1: {
                revesamento.setTempoa(2000);
                 break;
            }
            case 2: {
                revesamento.setTempoa(1500);
                break;
            }
            case 3: {
                revesamento.setTempoa(1000);
                break;
            }
            case 4: {
                revesamento.setTempoa(500);
                break;
            }
            default: {
                System.out.println("Treino inválido");
                break;
            }
        }
        System.out.println("E do Aluno 2?");
        System.out.println("MENU\n\n1- Treino de perna\n2- Treino de costas\n3- Treino de braços\n4- Treino isolado");
        op2 = input.nextInt();

        switch (op2) {
            case 1: {
                revesamento.setTempob(2000);
                 break;
            }
            case 2: {
                revesamento.setTempob(1500);
                break;
            }
            case 3: {
                revesamento.setTempob(1000);
                break;
            }
            case 4: {
                revesamento.setTempob(500);
                break;
            }
            default: {
                System.out.println("Treino inválido");
                break;
            }
        }
    Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    revesamento.entra();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    revesamento.proximo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    });
    t1.start();
    t2.start();

    t1.join();
    t2.join();

    input.close();
    }
  
}