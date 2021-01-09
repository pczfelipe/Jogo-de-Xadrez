package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public abstract class Peca {
    //Atributos
    protected int cor; //0 para brancas, 1 para pretas
    protected boolean inGame; //true para em jogo, false para capturada
    
    //Metodos Especiais
    /**
     *Construtor de peca, responsavel por criar a peca e colocar ela em jogo
     * 
     * @param cor Recebe a cor da peca 
     */
    protected Peca(int cor) {
        this.cor = cor;
        this.inGame = true; //ao construir a peca, ela ja esta em jogo
    }

    /**
     *Retorna a cor da peca
     * 
     * @return Retorna um inteiro representando a cor da peca
     */
    protected int getCor() {
        return cor;
    }

    /**
     *Responsavel por retornar se a peca esta em jogo ou nao
     * 
     * @return Retorna um boolean 
     */
    protected boolean isInGame() {
        return inGame;
    }

    /**
     *Responsavel por remover a peca do jogo
     * 
     * @param inGame Recebe status atual da peca no jogo 
     */
    protected void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
    
    //Metodos Personalizados
    /**
     *Responsavel por retornar o desenho da peca de acordo com a cor dela
     * 
     * @return Retorna uma string que representa a peca
     */
    protected abstract String desenho();
     /**
     *Responsavel por verificar a movimentacao de acordo com as regras do xadrez
     * 
     * @param linhaOrigem Coordenada linha de origem da peca
     * @param colunaOrigem Coordenada coluna de origem da peca
     * @param linhaDestino Coordenada linha de destino da peca
     * @param colunaDestino Coordenada linha de destino da peca
     * @return Retorna um boolean se o movimento eh valido ou nao 
     */
    protected abstract boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino);
}
