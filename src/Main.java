import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nome = new String[8];
        String[] classe = new String[8];
        int[] ataque = new int[8];
        int[] defesa = new int[8];
        int[] agilidade = new int[8];
        int[] dano = new int[8];

        for(int i = 0; i < 8; i++){
            System.out.println("Digite o nome do lutador: ");
            nome[i] = sc.nextLine();
            System.out.println("Digite a classe do lutador: ");
            classe[i] = sc.nextLine();
            System.out.println("Digite o ataque do lutador: ");
            ataque[i] = sc.nextInt();
            System.out.println("Digite a defesa do lutador: ");
            defesa[i] = sc.nextInt();
            System.out.println("Digite a agilidade do lutador: ");
            agilidade[i] = sc.nextInt();
            System.out.println("O dano do lutador será: " + ataque[i] + defesa[i] + agilidade[i]);

        }
    }
}