package xadrez.felipe.augusto.pkg743530.Peças;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Cavalo {
    //Atributos
    private int cor; //0 para brancas, 1 para pretas
    private boolean inGame;
    
    //Metodos
    public Cavalo(int cor) {
        this.cor = cor;
        this.inGame = true;
    }

    public int getCor() {
        return cor;
    }
    
    public String desenho(){
        if(getCor() == 0) //peca branca
            return("c");
        else
            return("C");
    }
    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        switch (Math.abs(linhaDestino - linhaOrigem)) {
            case 2:
                return Math.abs(colunaDestino - colunaOrigem) == 1;
            case 1:
                return Math.abs(colunaDestino - colunaOrigem) == 2;
            default:
                return false;
        }
    }
}
