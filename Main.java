import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Inicia as variaveis que serão usadas
        String[] nome = new String[8];
        int[] classe = new int[8];
        int[] ataque = new int[8];
        int[] defesa = new int[8];
        int[] agilidade = new int[8];
        int[] dano = new int[8];
        int opcao;
        int qtd = 0;

        //MENU
        do {
            System.out.println("\n==================|TORNEIO|===================");

            System.out.println("\n(1) Registrar lutadores(as)");
            System.out.println("(2) Mostrar lutadores(as)");
            System.out.println("(3) Buscar por Nome");
            System.out.println("(4) Listar por Classe");
            System.out.println("(5) Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                //Cadastrar
                case 1:
                    if (qtd == 8) {
                    System.out.println("Limite atingido!");
                    break;
                    }

                    //nome
                    if(qtd < 8){
                        System.out.println("Cadastro do lutador " + (qtd + 1));

                        System.out.println("Nome: ");
                        nome[qtd] = entrada.nextLine();

                    //classe

                    do {
                        System.out.println("Classe:");
                        System.out.println("(1) Caça");
                        System.out.println("(2) Guerra");
                        System.out.println("(3) Estratégia");
                        System.out.println("(4) Magia");

                        System.out.print("Digite: ");
                        classe[qtd] = entrada.nextInt();
                    } while (classe[qtd] < 1 || classe[qtd] > 4);

                    //ataque
                    do {
                        System.out.print("Ataque (0 - 100): ");
                        ataque[qtd] = entrada.nextInt();
                    } while (ataque[qtd] < 0 || ataque[qtd] > 100);

                    //defesa
                    do{
                        System.out.print("Defesa (0 - 100): ");
                        defesa[qtd] = entrada.nextInt();
                    } while (defesa[qtd] < 0 || defesa[qtd] > 100);

                    //agilidade
                    do {
                        System.out.print("Agilidade (0 - 100): ");
                        agilidade[qtd] = entrada.nextInt();
                    } while (agilidade[qtd] < 0 || agilidade[qtd] > 100);

                    entrada.nextLine();

                    //dano
                    dano[qtd] = ataque[qtd] + defesa[qtd] + agilidade[qtd];

                    System.out.println("Dano: " + dano[qtd]);

                    qtd++;
                    }
                    break;
                
                //Mostrar o Lutador 
                case 2:
                    if (qtd == 0){
                        System.out.println("\nNenhum lutador cadastrado!!");
                    }
                    for (int i = 0; i < qtd; i++) {
                        System.out.println("\nNome: " + nome[i]);

                        if (classe[i] == 1){
                            System.out.println("Classe: Caça");
                        }
                        if (classe[i] == 2){
                            System.out.println("Classe: Guerra");
                        }
                        if (classe[i] == 3){
                            System.out.println("Classe: Estratégia");
                        }
                        if (classe[i] == 4){
                            System.out.println("Classe: Magia");
                        }

                        System.out.println("Ataque: " + ataque[i]);
                        System.out.println("Defesa: " + defesa[i]);
                        System.out.println("Agilidade: " + agilidade[i]);
                        System.out.println("Dano: " + dano[i]);
                    }
                    
                    break;
                
                //Buscar o Lutador pelo nome
                case 3:
                    
                    String pesquisa;

                    System.out.println("\nDigite o nome: ");
                    pesquisa = entrada.nextLine();

                    boolean encontrou = false;
                    for(int i = 0; i < qtd; i++){
                        if (nome[i] == (pesquisa)){
                            System.out.println("Nome: " + nome[i]);
                            System.out.println("Dano: " + dano[i]);

                            encontrou = true;
                        }
                    }

                    if (encontrou == false){
                        System.out.println("\nLutador não encontrado.");
                    }
                    break;
                //Listar cada lutador pela classe
                case 4:
                    if (qtd == 0){
                        System.out.println("\nNenhum lutador cadastrado!!");
                    }
                    boolean encontrado = false;
                    int busca;
                    
                    System.out.println("\n===============|LISTAR CLASSES|================");
                    System.out.println("(1) Caça");
                    System.out.println("(2) Guerra");
                    System.out.println("(3) Estratégia");
                    System.out.println("(4) Magia");

                    System.out.println("\nDigite a classe: ");
                    busca = entrada.nextInt();

                    for(int i = 0; i < qtd; i++){
                        if (classe[i] == busca){
                            System.out.println("\nNome: " + nome[i]);

                            encontrado = true;
                        }
                    }

                    if (encontrado == false){
                        System.out.println("\nNenhum lutador nessa classe!");
                    }

                    entrada.nextLine();
            }
        } while (opcao != 5);

    }
}
