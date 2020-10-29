package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Posicao {
    
    //Atributos
    private int cor; //0 para branco, 1 para Preto
    private int linha; //de 1 a 8
    private String coluna; //de "a" a "h", ou seja, de 1 a 8
    private String ocupante; //é um objeto Peça, posteriormente sera implementado
    
    //Metodos Especiais
    public int isCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    /* PROXIMA FASE
    public String getOcupante() {
        return ocupante;
    }
    */

    /* PRÓXIMA FASE IRÁ RECEBER PEÇA */
    public void setOcupante(String ocupante) {
        this.ocupante = ocupante;
    }

}
