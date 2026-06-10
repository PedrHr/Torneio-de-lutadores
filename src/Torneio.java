import java.util.Scanner;

class Torneio {
    public static void main(String[] args) {
        //Scanner para entrada da resposta do usuário
        Scanner entrada = new Scanner(System.in); 

        //Inicia as variaveis que serão usadas
        String[] nome = new String[8];
        int[] classe = new int[8];
        int[] ataque = new int[8];
        int[] defesa = new int[8];
        int[] agilidade = new int[8];
        int[] dano = new int[8];
        int[] total = new int[8];
        //sistema pra organizar os lutadores nas lutas
        int[][] lutas = {{3,4},{3,5},{1,7},{4,5},{6,3},{7,0},{7,5},{1,0},{6,4},{2,6},{1,2},{0,2}};
        //Grade das pontuações
        int[][] pontuacao = new int[8][3];
        int opcao;
        int qtd = 0;

        //Menu principal do torneio com cadastramento, listas e opçao de sair 
        //tentamos deixar o mais agradavel e intuitivo possivel para entendimento do usuário.
        do {
            System.out.println("\n==================|TORNEIO|===================");

            System.out.println("\n(1) Registrar lutadores(as)");
            System.out.println("(2) Mostrar lutadores(as)");
            System.out.println("(3) Buscar por Nome");
            System.out.println("(4) Listar por Classe");
            System.out.println("(5) Mostrar Combates");
            System.out.println("(6) Executar Lutas");
            System.out.println("(7) Mostrar Pontuações");
            System.out.println("\n(8) Mostrar Ranking");
            System.out.println("(9) Sair");
            System.out.print("\nOpção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            //switch para cada opção no menu
            switch (opcao) {
                //Cadastrar
                case 1:
                    //foi utilizado IF para que quando terminar o registro de um lutador, ele volte ao menu e não cadastre todos de uma vez só.
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

                    //Calculo do dano do lutador 
                    dano[qtd] = ataque[qtd] + defesa[qtd] + agilidade[qtd];

                    System.out.println("Dano: " + dano[qtd]);

                    qtd++;
                    }
                    break;
                
                //Mostrar os Lutadores(as)  
                case 2:
                    //mensagem de erro para caso não tenha nenhum lutador registrado.
                    if (qtd == 0){
                        System.out.println("\nNenhum lutador cadastrado!!");
                    }
                    //como irá aparecer ao usuário
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
                    
                    System.out.println("\n=====================|BUSCAR LUTADOR|====================");
                    System.out.print("\nDigite o nome: ");
                    pesquisa = entrada.nextLine();
                    
                    boolean encontrou = false;
                    for(int i = 0; i < qtd; i++){
                        if (nome[i].equals(pesquisa)){
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

                    //menu pra escolher a classe que o usuário quer listar
                    System.out.println("\n===============|LISTAR CLASSES|================");
                    System.out.println("(1) Caça");
                    System.out.println("(2) Guerra");
                    System.out.println("(3) Estratégia");
                    System.out.println("(4) Magia");

                    System.out.println("\nDigite a classe: ");
                    busca = entrada.nextInt();

                    for(int i = 0; i < qtd; i++){
                        if (classe[i] == busca){
                            System.out.println("\n==================|CLASSE|" + busca + "|==================");
                            System.out.println("\nNome: " + nome[i]);
                            System.out.println("Ataque: " + ataque[i]);
                            System.out.println("Defesa: " + defesa[i]);
                            System.out.println("Agilidade: " + agilidade[i]);
                            System.out.println("Dano: " + dano[i]);

                            encontrado = true;
                        }
                    }
                    //mensagem de erro caso não tenha nenhum lutador cadastrado na classe
                    if (encontrado == false){
                        System.out.println("\nNenhum lutador nessa classe!");
                    }

                    entrada.nextLine();
                    break;
                //Mostrar os lutadores (Quem vai lutar com quem)
                case 5:
                    //só vai rodar caso todos lutadores estejam cadastrados
                    if (qtd == 8){
                        for(int i = 0; i < 12; i++){
    
                            int lutador1 = lutas[i][0];
                            int lutador2 = lutas[i][1];
    
                            System.out.println("\n" + nome[lutador1] + " VS " + nome[lutador2]);
                            }
                    //mensagem de erro caso não tenha 8 lutadores cadastrados. 
                    } else {
                        System.out.print("\nÉ necessário 8 Lutadores cadastrados para mostrar os combates!");
                    }
                    break;
                
                //calculo da luta entre cada lutador  
                case 6:
                    if (qtd < 8){
                        System.out.println("Cadastre os 8 lutadores primeiro!");
                        break;
                    }
                    int[] combate = new int[8];
                    
                    for (int i = 0; i < 12; i++){
                
                        int l1 = lutas[i][0];
                        int l2 = lutas[i][1];
                        
                        //faz o dano contra dano
                        int p1 = dano[l1] - dano[l2];
                        int p2 = dano[l2] - dano[l1];
                        
                        pontuacao[l1][combate[l1]] = p1;
                        pontuacao[l2][combate[l2]] = p2;
                        
                        //registrar a pontuação
                        combate[l1]++;
                        combate[l2]++;
                    }
                    System.out.println("Lutas executadas com sucesso!");
                    break;
                //Pontuação
                case 7:
                    for(int i = 0; i < qtd; i++){
                        System.out.println("\nNome: " + nome[i]);
                        
                        System.out.println("Combate 1: " + pontuacao[i][0]);
                        System.out.println("Combate 2: " + pontuacao[i][1]);
                        System.out.println("Combate 3: " + pontuacao[i][2]);
                        
                        total[i] = pontuacao[i][0] + pontuacao[i][1] + pontuacao[i][2];

                        System.out.println("Total de pontos: " + total[i]);
                        
                    }
                    break;
                
                //ranking
                case 8:
                    if (qtd < 8){
                        System.out.println("Você precisa cadastrar todos os lutadores e executar as lutas primeiro!");
                        break;
                    }
                    int[] ranking = new int[8];
                    
                    for(int i = 0; i < 8; i++){
                        ranking[i] = i;
                    }
                    
                    for(int i = 0; i < 7; i++){
                        for(int j = i + 1; j < 8; j++){
                            if (total[ranking[j]] > total[ranking[i]]){
                                //variavel pra não perder os valores
                                int aux = ranking[i];
                                ranking[i] = ranking[j];
                                ranking[j] = aux;
                            }
                        }
                    }
                    
                    System.out.println("\n========== RANKING ==========");

                    for(int i = 0; i < qtd; i++){
                        System.out.println(
                            (i + 1) + "º - " + nome[ranking[i]] + " (" + total[ranking[i]] + " pontos)");
                    }
                    break;
                
            }
            //while para que, caso seja escolhido 5, o programa seja fechado
        } while (opcao != 9);
        
    }
}
