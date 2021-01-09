package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Jogador {
    //Atributos
    private final String nome; //nome do jogador
    private Peca[] p = new Peca[16]; //conjunto de pecas do jogador
    private final int cor; //0 para jogador com pecas branco, 1 para jogador com pecas pretas

    //Metodos Especiais
    /**
     *Construtor de jogador, responsável por criar o jogador com seu nome, cor e suas respectivas pecas
     * 
     * @param nome Nome do Jogador
     * @param p Conjunto de pecas do xadrez iniciais
     * @param cor Cor do Jogador de acordo com sua peca
     */
    public Jogador(String nome, Peca[] p, int cor) {
        //Setando nome e cor do jogador
        this.nome = nome;
        this.cor = cor;
        //Copiando Pecas para jogador
        System.arraycopy(p, 0, this.p, 0, 16);
    }

    /**
     *Responsavel por retornar a cor do jogador
     * 
     * @return Retorna um inteiro
     */
    public int getCor() {
        return cor;
    }

    /**
     *Responsavel por retornar o nome do jogador
     * 
     * @return Retorna uma string
     */
    public String getNome() {
        return nome;
    }
}
