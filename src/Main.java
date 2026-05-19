import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Cria um objeto Scanner

        //Inicia as variaveis que serão usadas
        String[] nome = new String[8];
        String[] classe = new String[8];
        int[] ataque = new int[8];
        int[] defesa = new int[8];
        int[] agilidade = new int[8];
        int[] dano = new int[8];
        int opcao;
        int quantidade = 0;

        //Cria um loop do-while para o menu funcionar enquanto não for digitado 5.
        do {
            System.out.println("Menu: ");
            System.out.println("1 - Registrar Lutadores");
            System.out.println("2 - Mostrar Lutadores");
            System.out.println("3 - Buscar Lutador");
            System.out.println("4 - Listar Lutadores por Classe");
            System.out.println("5 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    if(quantidade < 8) {

                        System.out.println("Nome:");
                        nome[quantidade] = sc.nextLine();

                        System.out.println("Classe:");
                        classe[quantidade] = sc.nextLine();

                        System.out.println("Ataque:");
                        ataque[quantidade] = sc.nextInt();

                        System.out.println("Defesa:");
                        defesa[quantidade] = sc.nextInt();

                        System.out.println("Agilidade:");
                        agilidade[quantidade] = sc.nextInt();

                        dano[quantidade] = ataque[quantidade] + defesa[quantidade] + agilidade[quantidade];

                        quantidade++;

                        sc.nextLine();

                        System.out.println("Lutador cadastrado!");
                    }
                    else {
                        System.out.println("Limite atingido!");
                    }

                    break;
                case 2:

            }
        } while (opcao != 5);
    }
}