package xadrez.felipe.augusto.pkg743530.Peças;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Torre {
    //Atributos
    private final int cor; //0 para brancas, 1 para pretas
    private boolean inGame;
    
    //Metodos
    public Torre(int cor) {
        this.cor = cor;
        this.inGame = true;
    }

    public int getColor() {
        return cor;
    }
    
    public String desenho(){
        if(getColor() == 0) //peca branca
            return("t");
        else
            return("T");
    }
    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        System.out.println("\nTestando " + this.desenho());
        return (linhaOrigem == linhaDestino && colunaOrigem != colunaDestino) || (linhaOrigem != linhaDestino) && (colunaOrigem == colunaDestino);
    }  
}
