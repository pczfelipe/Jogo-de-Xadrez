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
public class Jogador {
    //Atributos
    private String nome;
    private Peca[] p = new Peca[16]; 

    //Metodos Especiais
    public Jogador(String nome, Peca[] p) {
        //Setando nome do jogador
        this.nome = nome;
        
        //Copiando Pecas para jogador
        System.arraycopy(p, 0, this.p, 0, 16);
    }

    public void setP(Peca[] p) {
        this.p = p;
    }
    
    //Metodos Personalizados
        public boolean getstatusPeca(Peca p){
        return p.isInGame();
    }
}
