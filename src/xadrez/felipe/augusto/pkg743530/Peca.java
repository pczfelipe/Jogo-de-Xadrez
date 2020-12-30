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
    protected Peca(int cor) {
        this.cor = cor;
        this.inGame = true; //ao construir a peca, ela ja esta em jogo
    }

    protected int getCor() {
        return cor;
    }

    protected boolean isInGame() {
        return inGame;
    }

    protected void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
    
    //Metodos Personalizados
    protected abstract String desenho();
    protected abstract boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino);
}
