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
    public Peao(int cor) {
        super(cor); //Chamando construtor herdado da classe Peca
        this.primeiraJogada = true;
    }

    public void setPrimeiraJogada() {
        this.primeiraJogada = false;
    }
    
    //Metodos Personalizados
    @Override
    public String desenho(){
        if(getCor() == 0) //peca branca
            return("p+");
        else
            return("P-");
    }
    
    @Override
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        if(this.getCor() == 0) {
            switch (linhaDestino - linhaOrigem) {
                case 2:
                    if(this.primeiraJogada != true)
                        return false;
            
                    return colunaDestino == colunaOrigem;
                
                case 1:
                    if(colunaOrigem == colunaDestino || Math.abs(colunaDestino - colunaOrigem) == 1) // Movimento para frente ou em diagonal
                        return true;
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
                    
                    return colunaDestino == colunaOrigem;
                    
                case 1:
                    if(colunaOrigem == colunaDestino || Math.abs(colunaDestino - colunaOrigem) == 1) // Movimento para frente ou em diagonal
                        return true;
                
                default:
                    return false;
            }
        }
        return false;
    }
}
