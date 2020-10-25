package xadrez.felipe.augusto.pkg743530.Peças;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Peao {
    //Atributos
    private int cor; //0 para brancas, 1 para pretas
    private boolean inGame;
    private boolean primeiraJogada; //armazena se é a primeira jogada
    
    //Metodos
    public Peao(int cor) {
        this.cor = cor;
        this.inGame = true;
        this.primeiraJogada = true;
    }

    public int getCor() {
        return cor;
    }
    
    public String desenho(){
        if(getCor() == 0) //peca branca
            return("p");
        else
            return("P");
    }
    
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
