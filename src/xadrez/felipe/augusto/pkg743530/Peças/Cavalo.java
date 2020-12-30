package xadrez.felipe.augusto.pkg743530.Peças;
import xadrez.felipe.augusto.pkg743530.Peca;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Cavalo extends Peca{
    //Metodos Especiais
    public Cavalo(int cor) {
        super(cor); //Chamando construtor herdado da classe Peca
    }

    @Override
    public String desenho(){
        if(getCor() == 0) //peca branca
            return("c+");
        else
            return("C-");
    }
    
    @Override
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
