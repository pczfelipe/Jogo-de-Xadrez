package xadrez.felipe.augusto.pkg743530.Peças;
import xadrez.felipe.augusto.pkg743530.Peca;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Rei extends Peca{
    //Metodos Especiais
    public Rei(int cor) {
        super(cor); //Chamando construtor herdado da classe Peca
    }

    //Metodos Personalizados
    @Override
    public String desenho(){
        if(getCor()== 0) //peca branca
            return("r+");
        else
            return("R-");
    }
    
    @Override
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        return Math.abs(linhaDestino - linhaOrigem) <= 1 && Math.abs(colunaDestino - colunaOrigem) <= 1;
    }
}
