import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Numbernator{
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        int max = 101;
        int min = 0;
        char op = 'a';
        int count = 0;
        ArrayList<Integer> cache = new ArrayList<>();

        System.out.println("Olá! Eu sou o gênio do número e vou tentar adivinhar um núemro que você pensou que esteja entre 0 e 100");
        System.out.println("Já pensou? Escreva s para continuar");
        char choice = s.next().charAt(0);
        while (choice != 's') {
            System.out.println("Digite s para continuar");
            choice = s.next().charAt(0);
        }

        do {
            if (count == 0) {
                int random = r.nextInt(max);
                cache.add(random);
                System.out.println("Meu chute é " + random);
                System.out.println("Acertei? (s/n)");
                op = s.next().charAt(0);
                if (op == 's') {
                    System.out.println("Haha eu ganhei!");
                } else {
                    count++;
                }
            }else if (count > 0 && count < 5) {
                System.out.println("O número é? 1 - maior ou 2 - menor, digite o número");
                int choice2 = s.nextInt();
                if(choice2 == 1){
                    int random = r.nextInt(cache.get(count - 1), max);
                    cache.add(random);
                    System.out.println("Meu chute é " + random);
                    System.out.println("Acertei? (s/n)");
                    op = s.next().charAt(0);
                    if (op == 's') {
                        System.out.println("Haha eu ganhei!");
                    } else {
                        count++;
                    }
                }else{
                    int random = r.nextInt(min, cache.get(count - 1));
                    cache.add(random);
                    System.out.println("Meu chute é " + random);
                    System.out.println("Acertei? (s/n)");
                    op = s.next().charAt(0);
                    if (op == 's') {
                        System.out.println("Haha eu ganhei!");
                    } else {
                        count++;
                    }
                }
            }else{
                System.out.println("Poxa perdi");
            }
        } while (op != 's');
    }
}