package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Bispo {
    //Atributos
    private int cor; //0 para brancas, 1 para pretas
    private boolean inGame;
    
    //Metodos
    public Bispo(int cor) {
        this.cor = cor;
        this.inGame = true;
    }

    public int getColor() {
        return cor;
    }
    
    public String desenho(){
        if(getColor() == 0) //peca branca
            return("b");
        else
            return("B");
    }
    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        if(Math.abs(linhaDestino - linhaOrigem) == Math.abs(colunaDestino - colunaOrigem))
            return true;
        else
            return false;
    }

}
