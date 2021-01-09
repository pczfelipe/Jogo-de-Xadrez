package xadrez.felipe.augusto.pkg743530.Peças;
import xadrez.felipe.augusto.pkg743530.Peca;


/**
 *
 * @author Felipe Augusto - 743530
 */
public class Peao extends Peca{
    //Atributos
    private boolean primeiraJogada; //armazena se é a primeira jogada
    
    //Metodos Especiais
    /**
     *Construtor de peca peao, responsavel por criar a peca com sua cor e setar primeira jogada
     * 
     * @param cor Recebe a cor da peca 
     */
    public Peao(int cor) {
        super(cor); //Chamando construtor herdado da classe Peca
        this.primeiraJogada = true;
    }

    //Metodos Personalizados
    /**
     *Responsavel por retornar o desenho da peca de acordo com a cor dela
     * 
     * @return Retorna uma string que representa a peca
     */
    @Override
    public String desenho(){
        if(getCor() == 0) //peca branca
            return("p+");
        else
            return("P-");
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
        if(this.getCor() == 0) {
            switch (linhaDestino - linhaOrigem) {
                case 2:
                    if(this.primeiraJogada != true)
                        return false;
                    
                    if(colunaDestino == colunaOrigem){
                        this.primeiraJogada = false;
                        return true;
                    }
                
                case 1:
                    if(colunaOrigem == colunaDestino || Math.abs(colunaDestino - colunaOrigem) == 1){  // Movimento para frente ou em diagonal
                        this.primeiraJogada = false;
                        return true;
                    }
                    break;
                
                default:
                    return false;
            }
        }
        else {
            switch (linhaOrigem - linhaDestino) {
                case 2:
                    if(this.primeiraJogada != true)
                        return false;
                    
                    if(colunaDestino == colunaOrigem){
                        this.primeiraJogada = false;
                        return true;
                    }
                    
                case 1:
                    if(colunaOrigem == colunaDestino || Math.abs(colunaDestino - colunaOrigem) == 1){  // Movimento para frente ou em diagonal
                        this.primeiraJogada = false;
                        return true;
                    }
                
                default:
                    return false;
            }
        }
        return false;
    }
}
