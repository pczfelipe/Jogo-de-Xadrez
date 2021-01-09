package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Posicao {
    //Atributos
    private final String cor; //00 para branco, 11 para Preto
    private final int linha; //de 1 a 8
    private final String coluna; //de "A" a "H", ou seja, de 1 a 8
    private Peca ocupante; //é um objeto Peça, posteriormente sera implementado
    
    //Metodos Especiais
    /**
    *Construtor de tabuleiro, responsável por criar as posições e inserir as peças criadas nas posicoes iniciais do xadrex
    * 
    * @param cor Cor da posicao no tabuleiro
    * @param linha Linha no tabuleiro
    * @param coluna Coluna no tabuleiro
    */
    public Posicao(String cor, int linha, String coluna) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.ocupante = null;
    }

    /**
     *Retorna a cor da posicao no tabuleiro
     * 
     * @return Retorna String que representa cor
     */
    public String isCor() {
        return cor;
    }

     /**
     *Retorna a peca na posicao no tabuleiro
     * 
     * @return Retorna um objeto peca 
     */
    public Peca getOcupante() {
        return ocupante;
    }

     /**
     *Responsavel por colocar uma nova peca na nova posicao
     * 
     * @param ocupante Recebe um objeto peca 
     */
    public void setOcupante(Peca ocupante) {
        this.ocupante = ocupante;
    }
}
