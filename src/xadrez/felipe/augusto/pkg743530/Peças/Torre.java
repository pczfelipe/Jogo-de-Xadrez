package xadrez.felipe.augusto.pkg743530.Peças;
import xadrez.felipe.augusto.pkg743530.Peca;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Torre extends Peca{
    //Metodos Especiais
    /**
     *Construtor de peca torre, responsavel por criar a peca com sua cor
     * 
     * @param cor Recebe a cor da peca 
     */
    public Torre(int cor) {
        super(cor);
    }
    
    //Metodos Personalizados
    /**
     *Responsavel por retornar o desenho da peca de acordo com a cor dela
     * 
     * @return Retorna uma string que representa a peca
     */
    @Override
    public String desenho(){
        if(getCor()== 0) //peca branca
            return("t+");
        else
            return("T-");
    }
    
    /**
     *Responsavel por verificar a movimentacao de acordo com as regras do xadrez
     * 
     * @param linhaOrigem Coordenada linha de origem da peca
     * @param colunaOrigem Coordenada coluna de origem da peca
     * @param linhaDestino Coordenada linha de destino da peca
     * @param colunaDestino Coordenada linha de destino da peca
     * @return Retorna um boolean se o movimento eh valido ou nao 
     */
    @Override
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        return (linhaOrigem == linhaDestino && colunaOrigem != colunaDestino) || (linhaOrigem != linhaDestino) && (colunaOrigem == colunaDestino);
    }  
}
