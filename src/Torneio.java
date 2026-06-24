/**
 * Classe responsável pelas regras do torneio.
 */
public class Torneio {

    private Lutador[] lutadores = new Lutador[8];

    private int[][] lutas = {
            {3,4},
            {3,5},
            {1,7},
            {4,5},
            {6,3},
            {7,0},
            {7,5},
            {1,0},
            {6,4},
            {2,6},
            {1,2},
            {0,2}
    };

    private int[][] pontuacao = new int[8][3];

    private int[] total = new int[8];

    private int qtd = 0;

    public boolean adicionarLutador(Lutador lutador) {

        if (qtd == 8) {
            return false;
        }

        lutadores[qtd] = lutador;
        qtd++;

        return true;
    }

    public Lutador[] getLutadores() {
        return lutadores;
    }

    public int getQtd() {
        return qtd;
    }

    public int[][] getPontuacao() {
        return pontuacao;
    }

    public int[] getTotal() {
        return total;
    }

    public int[][] getLutas() {
        return lutas;
    }

    public void executarLutas() {

        int[] combate = new int[8];

        for (int i = 0; i < 12; i++) {

            int l1 = lutas[i][0];
            int l2 = lutas[i][1];

            int p1 = lutadores[l1].getDano() - lutadores[l2].getDano();

            int p2 = lutadores[l2].getDano() - lutadores[l1].getDano();

            pontuacao[l1][combate[l1]] = p1;
            pontuacao[l2][combate[l2]] = p2;

            combate[l1]++;
            combate[l2]++;
        }

        calcularTotais();
    }

    private void calcularTotais() {

        for (int i = 0; i < qtd; i++) {

            total[i] = pontuacao[i][0] + pontuacao[i][1] + pontuacao[i][2];
        }
    }

    public int[] gerarRanking() {

        int[] ranking = new int[8];

        for (int i = 0; i < 8; i++) {
            ranking[i] = i;
        }

        for (int i = 0; i < 7; i++) {

            for (int j = i + 1; j < 8; j++) {

                if (total[ranking[j]] > total[ranking[i]]) {

                    int aux = ranking[i];
                    ranking[i] = ranking[j];
                    ranking[j] = aux;
                }
            }
        }

        return ranking;
    }
}