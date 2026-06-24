/**
 * Classe que representa um lutador.
 */
public class Lutador {

    private String nome;
    private int classe;
    private int ataque;
    private int defesa;
    private int agilidade;
    private int dano;

    public Lutador(String nome, int classe, int ataque, int defesa, int agilidade) {

        this.nome = nome;
        this.classe = classe;
        this.ataque = ataque;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.dano = ataque + defesa + agilidade;

    }

    public String getNome() {
        return nome;
    }

    public int getClasse() {
        return classe;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getDano() {
        return dano;
    }

    public String getNomeClasse() {

        switch (classe) {
            case 1:
                return "Caça";
            case 2:
                return "Guerra";
            case 3:
                return "Estratégia";
            case 4:
                return "Magia";
            default:
                return "Inválida";
        }
    }
}