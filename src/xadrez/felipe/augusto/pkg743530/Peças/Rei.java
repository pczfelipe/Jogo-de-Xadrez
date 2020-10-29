package xadrez.felipe.augusto.pkg743530.Peças;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Rei {
    //Atributos
    private final int cor; //0 para brancas, 1 para pretas
    private boolean inGame;
    
    //Metodos
    public Rei(int cor) {
        this.cor = cor;
        this.inGame = true;
    }

    public int getColor() {
        return cor;
    }
    
    public String desenho(){
        if(getColor() == 0) //peca branca
            return("r");
        else
            return("R");
    }
    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        return Math.abs(linhaDestino - linhaOrigem) <= 1 && Math.abs(colunaDestino - colunaOrigem) <= 1;
    }
}
