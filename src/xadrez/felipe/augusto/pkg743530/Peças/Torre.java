package xadrez.felipe.augusto.pkg743530.Peças;
import xadrez.felipe.augusto.pkg743530.Peca;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Torre extends Peca{
    //Metodos Especiais
    public Torre(int cor) {
        super(cor);
    }
    
    //Metodos Personalizados
    @Override
    public String desenho(){
        if(getCor()== 0) //peca branca
            return("t+");
        else
            return("T-");
    }
    
    @Override
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        return (linhaOrigem == linhaDestino && colunaOrigem != colunaDestino) || (linhaOrigem != linhaDestino) && (colunaOrigem == colunaDestino);
    }  
}
