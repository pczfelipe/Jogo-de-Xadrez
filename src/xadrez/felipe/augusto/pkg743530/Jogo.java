package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Jogo {
    
    //Atributos
    private Tabuleiro tabuleiro;
    private String estado;
    /* PROXIMA FASE - CRIAR PEÇAS TAMBÉM
    private Jogador j1;
    private Jogador j2;
    */
    private int vezJogador; //0 para branco e 1 para preto 
    
    //Métodos Especiais
    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        tabuleiro.desenho();
        
        //PRÓXIMA FASE - CRIAR AQUI OS JOGADORES
    }
    
    //Métodos Personalizados
    public boolean testePecas(char peca, int linhaOrigem, String colunaOrigem, int linhaDestino, String colunaDestino){
        return this.tabuleiro.checaMovimento(peca, 0, linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
    }
    
}
