package xadrez.felipe.augusto.pkg743530;

import xadrez.felipe.augusto.pkg743530.Peças.Bispo;
import xadrez.felipe.augusto.pkg743530.Peças.Cavalo;
import xadrez.felipe.augusto.pkg743530.Peças.Dama;
import xadrez.felipe.augusto.pkg743530.Peças.Peao;
import xadrez.felipe.augusto.pkg743530.Peças.Rei;
import xadrez.felipe.augusto.pkg743530.Peças.Torre;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Jogo {
    //Atributos
    private Tabuleiro tabuleiro;
    private Jogador j1; //jogador 1
    private Jogador j2; //jogador 2
    private String estado; //inicial, xeque, xeque-mate
    private int vezJogador; //0 para branco e 1 para preto 
    private Peca[] pP = new Peca[16]; //vetor pecas pretas
    private Peca[] pB = new Peca[16]; //vetor pecas brancas
        
    //Métodos Especiais
    public Jogo(String j1, String j2) {
        //Criando Pecas - Torre, Cavalo, Bispo
        this.pB[0] = new Torre(0);
        this.pP[0] = new Torre(1);
        this.pB[1] = new Cavalo(0);
        this.pP[1] = new Cavalo(1);
        this.pB[2] = new Bispo(0);
        this.pP[2] = new Bispo(1);
        //Criando Pecas - Dama, Rei
        this.pB[3] = new Dama(0);
        this.pP[3] = new Dama(1);
        this.pB[4] = new Rei(0);
        this.pP[4] = new Rei(1);
        //Criando Pecas - Torre, Cavalo, Bispo
        this.pB[5] = new Bispo(0);
        this.pP[5] = new Bispo(1);
        this.pB[6] = new Cavalo(0);
        this.pP[6] = new Cavalo(1);
        this.pB[7] = new Torre(0);
        this.pP[7] = new Torre(1);
        //Criando Pecas - Peao
        for(int i = 8; i < 16; i++){
            this.pB[i] = new Peao(0);
            this.pP[i] = new Peao(1);
        }

        //Criando Jogadores
        this.j1 = new Jogador(j1, pB);
        this.j2 = new Jogador(j2, pP);
        
        //Criando Tabuleiro
        this.tabuleiro = new Tabuleiro(pB, pP);
        this.tabuleiro.desenho();
        
        //Setando Estado do Jogo
        this.estado = "Inicial";
    }
    
    //Métodos Personalizados
    public boolean movimentar(char peca, int linhaOrigem, String colunaOrigem, int linhaDestino, String colunaDestino){
        return true;
    }
    
}
