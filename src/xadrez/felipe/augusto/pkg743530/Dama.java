package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Dama {
    //Atributos
    private int cor; //0 para brancas, 1 para pretas
    private boolean inGame;
    
    //Metodos
    public Dama(int cor) {
        this.cor = cor;
        this.inGame = true;
    }

    public int getColor() {
        return cor;
    }
    
    public String desenho(){
        if(getColor() == 0) //peca branca
            return("d");
        else
            return("D");
    }
    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        return (Math.abs(linhaDestino - linhaOrigem) == Math.abs(colunaDestino - colunaOrigem)) || (linhaOrigem == linhaDestino && colunaOrigem != colunaDestino) || ((linhaOrigem != linhaDestino) && (colunaOrigem == colunaDestino));
    }
}
