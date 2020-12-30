package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Posicao {
    //Atributos
    private String cor; //00 para branco, 11 para Preto
    private int linha; //de 1 a 8
    private String coluna; //de "a" a "h", ou seja, de 1 a 8
    private Peca ocupante; //é um objeto Peça, posteriormente sera implementado
    
    //Metodos Especiais
    public Posicao(String cor, int linha, String coluna) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.ocupante = null;
    }
    
    public String isCor() {
        return cor;
    }

    public Peca getOcupante() {
        return ocupante;
    }

    public void setOcupante(Peca ocupante) {
        this.ocupante = ocupante;
    }
}
