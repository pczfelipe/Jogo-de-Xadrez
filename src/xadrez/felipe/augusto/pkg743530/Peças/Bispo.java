package xadrez.felipe.augusto.pkg743530.Peças;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Bispo {
    //Atributos
    private final int cor; //0 para brancas, 1 para pretas
    private boolean inGame;
    
    //Metodos Especiais
    public Bispo(int cor) {
        this.cor = cor;
        this.inGame = true;
    }

    public int getCor() {
        return cor;
    }
    
    //Metodos Personalizados
    public String desenho(){
        if(getCor() == 0) //peca branca
            return("b");
        else
            return("B");
    }
    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        return Math.abs(linhaDestino - linhaOrigem) == Math.abs(colunaDestino - colunaOrigem);
    }

}
