package xadrez.felipe.augusto.pkg743530.Peças;
import xadrez.felipe.augusto.pkg743530.Peca;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Rei extends Peca{
    //Metodos Especiais
    /**
     *Construtor de peca rei, responsavel por criar a peca com sua cor
     * 
     * @param cor Recebe a cor da peca 
     */
    public Rei(int cor) {
        super(cor); //Chamando construtor herdado da classe Peca
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
            return("r+");
        else
            return("R-");
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
        return Math.abs(linhaDestino - linhaOrigem) <= 1 && Math.abs(colunaDestino - colunaOrigem) <= 1;
    }
}
