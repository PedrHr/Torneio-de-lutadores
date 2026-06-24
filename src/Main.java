import java.util.Scanner;
/**
 * Sistema de torneio de lutadores.
 */
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Torneio torneio = new Torneio();
        int opcao;

        do {

            System.out.println("\n==================|TORNEIO|===================");

            System.out.println("(1) Registrar lutadores(as)");
            System.out.println("(2) Mostrar lutadores(as)");
            System.out.println("(3) Buscar por Nome");
            System.out.println("(4) Listar por Classe");
            System.out.println("(5) Mostrar Combates");
            System.out.println("(6) Executar Lutas");
            System.out.println("(7) Mostrar Pontuações");
            System.out.println("(8) Mostrar Ranking");
            System.out.println("(9) Sair");

            System.out.print("Opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    if (torneio.getQtd() == 8) {
                        System.out.println("Limite atingido!");
                        break;
                    }

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    int classe;

                    do {
                        System.out.println("Classe:");
                        System.out.println("1 - Caça");
                        System.out.println("2 - Guerra");
                        System.out.println("3 - Estratégia");
                        System.out.println("4 - Magia");

                        classe = entrada.nextInt();

                    } while (classe < 1 || classe > 4);

                    int ataque;

                    do {
                        System.out.print("Ataque: ");
                        ataque = entrada.nextInt();
                    } while (ataque < 0 || ataque > 100);

                    int defesa;

                    do {
                        System.out.print("Defesa: ");
                        defesa = entrada.nextInt();
                    } while (defesa < 0 || defesa > 100);

                    int agilidade;

                    do {
                        System.out.print("Agilidade: ");
                        agilidade = entrada.nextInt();
                    } while (agilidade < 0 || agilidade > 100);

                    entrada.nextLine();

                    Lutador lutador = new Lutador(nome, classe, ataque, defesa, agilidade);

                    torneio.adicionarLutador(lutador);

                    System.out.println("Dano: " + lutador.getDano());
                    break;

                case 2:

                    if (torneio.getQtd() == 0) {
                        System.out.println("Nenhum lutador cadastrado!");
                        break;
                    }

                    for (int i = 0; i < torneio.getQtd(); i++) {

                        Lutador l = torneio.getLutadores()[i];

                        System.out.println("\nNome: " + l.getNome());

                        System.out.println("Classe: " + l.getNomeClasse());

                        System.out.println("Ataque: " + l.getAtaque());

                        System.out.println("Defesa: " + l.getDefesa());

                        System.out.println("Agilidade: " + l.getAgilidade());

                        System.out.println("Dano: " + l.getDano());
                    }
                    break;

                case 3:

                    System.out.print("Nome: ");
                    String buscaNome = entrada.nextLine();

                    boolean encontrou = false;

                    for (int i = 0; i < torneio.getQtd(); i++) {

                        Lutador l = torneio.getLutadores()[i];

                        if (l.getNome().equalsIgnoreCase(buscaNome)) {
                            System.out.println("Nome: " + l.getNome());

                            System.out.println("Dano: " + l.getDano());

                            encontrou = true;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Lutador não encontrado!");
                    }
                    break;

                case 4:

                    System.out.print("Classe: " +
                            "\n(1) Caça " +
                            "\n(2) Guerra " +
                            "\n(3) Estratégia " +
                            "\n(4) Magia \n");

                    int classeBusca = entrada.nextInt();

                    entrada.nextLine();

                    boolean achou = false;

                    for (int i = 0; i < torneio.getQtd(); i++) {

                        Lutador l = torneio.getLutadores()[i];

                        if (l.getClasse() == classeBusca) {
                            System.out.println("\nNome: " + l.getNome());

                            System.out.println("Dano: " + l.getDano());

                            achou = true;
                        }
                    }

                    if (!achou) {
                        System.out.println("Nenhum lutador nessa classe!");
                    }
                    break;

                case 5:

                    if (torneio.getQtd() < 8) {
                        System.out.println("Cadastre os 8 lutadores!");
                        break;
                    }

                    for (int i = 0; i < 12; i++) {

                        int l1 = torneio.getLutas()[i][0];

                        int l2 = torneio.getLutas()[i][1];

                        System.out.println(torneio.getLutadores()[l1].getNome() + " VS " + torneio.getLutadores()[l2].getNome());
                    }
                    break;

                case 6:

                    if (torneio.getQtd() < 8) {
                        System.out.println("Cadastre os 8 lutadores primeiro!");
                        break;
                    }

                    torneio.executarLutas();

                    System.out.println("Lutas executadas!");
                    break;

                case 7:

                    for (int i = 0; i < torneio.getQtd(); i++) {

                        System.out.println("\nNome: " + torneio.getLutadores()[i].getNome());

                        System.out.println("Combate 1: " + torneio.getPontuacao()[i][0]);

                        System.out.println("Combate 2: " + torneio.getPontuacao()[i][1]);

                        System.out.println("Combate 3: " + torneio.getPontuacao()[i][2]);

                        System.out.println("Total: " + torneio.getTotal()[i]);
                    }
                    break;

                case 8:

                    int[] ranking = torneio.gerarRanking();

                    System.out.println("\n===== RANKING =====");

                    for (int i = 0; i < torneio.getQtd(); i++) {
                        System.out.println((i + 1) + "º - " + torneio.getLutadores()[ranking[i]].getNome() + " (" + torneio.getTotal()[ranking[i]] + " pontos)");
                    }
                    break;
            }

        } while (opcao != 9);

        entrada.close();
    }
}