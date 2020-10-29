package xadrez.felipe.augusto.pkg743530;

//referenciando as pecas especificas, mas na proxima fase isso irá mudar apenas para Posicao, que contem Peca
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
public class Tabuleiro {
    
    //Atributos
    private Posicao[][] mesa = new Posicao[8][8];
    
    //Metodos Especiais
    public Tabuleiro() {
        String coluna;
        
        for(int i = 8; i > 0; i--){
            for(int j = 0; j < 8; j++){
                switch(j){
                    case 0:
                        coluna = "A";
                        break;
                    case 1:
                        coluna = "B";
                        break;
                    case 2:
                        coluna = "C";
                        break;
                    case 3:
                        coluna = "D";
                        break;
                    case 4:
                        coluna = "E";
                        break;
                    case 5:
                        coluna = "F";
                        break;
                    case 6:
                        coluna = "G";
                        break;
                    case 7:
                        coluna = "H";
                        break;
                    default:
                        coluna = "X";
                        break;
                }
                
                this.mesa[i-1][j] = new Posicao();
                this.mesa[i-1][j].setLinha(i);
                this.mesa[i-1][j].setColuna(coluna);
                this.mesa[i-1][j].setOcupante("");
                
                if (i % 2 == 0){
                    if (j % 2 == 0)
                        this.mesa[i-1][j].setCor(0); //casa branca
                    else
                        this.mesa[i-1][j].setCor(1); //casa preta
                }
                else {
                    if (j % 2 == 0)
                        this.mesa[i-1][j].setCor(1); //casa preta
                    else
                        this.mesa[i-1][j].setCor(0); //casa branca
                }
            }
        }
    }
    
    /* PROXIMA FASE
    public void setMesa(Posicao[][] mesa) {
        this.mesa = mesa;
    }
    
    public String getOcupante(){
        return "";
    }
    */
    
    public Posicao getPosicao(int linha, int coluna){
        return this.mesa[linha][coluna];
    }
    
    //Metodos Personalizados
    public void desenho(){
        String colunas[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
        
        //imprimindo as coordenadas
        System.out.print("     ");
        for(int i = 0; i < 8; i++)
            System.out.print(colunas[i] + " ");
        
        System.out.println("");
        
        for(int i = 8; i > 0; i--){
            //imprimindo as coordenadas
            System.out.print(i + "    ");
            for(int j = 0; j < 8; j++)
                System.out.print(getPosicao(i-1, j).isCor() + " ");
            
            System.out.println("");
        }
    }
    
    //checa movimento está recebendo as peças especificas mas na proxima fase ira receber apenas objeto Posicao
    public boolean checaMovimento(char peca, int cor, int linhaOrigem, String colunaOrigem, int linhaDestino, String colunaDestino){
        int colunaOrigemInt, colunaDestinoInt;

        //verificar se está disponivel a posicao - PROXIMA FASE IMPLEMENTAR
        //Posicao p = this.getPosicao(linhaOrigem, colunaOrigem);
        
        //convertendo string coluna para int
        switch(colunaOrigem){
            case "A":
                colunaOrigemInt = 1;
                break;
            case "B":
                colunaOrigemInt = 2;
                break;
            case "C":
                colunaOrigemInt = 3;
                break;
            case "D":
                colunaOrigemInt = 4;
                break;
            case "E":
                colunaOrigemInt = 5;
                break;
            case "F":
                colunaOrigemInt = 6;
                break;
            case "G":
                colunaOrigemInt = 7;
                break;
            case "H":
                colunaOrigemInt = 8;
                break;
            default:
                colunaOrigemInt = 9;
                break;
        }
        //convertendo string coluna para int
        switch(colunaDestino){
            case "A":
                colunaDestinoInt = 1;
                break;
            case "B":
                colunaDestinoInt = 2;
                break;
            case "C":
                colunaDestinoInt = 3;
                break;
            case "D":
                colunaDestinoInt = 4;
                break;
            case "E":
                colunaDestinoInt = 5;
                break;
            case "F":
                colunaDestinoInt = 6;
                break;
            case "G":
                colunaDestinoInt = 7;
                break;
            case "H":
                colunaDestinoInt = 8;
                break;
            default:
                colunaDestinoInt = 9;     
                break;
        }
  
        //verificando se viola as dimensoes do tabuleiro
        if (linhaOrigem > 8 || linhaOrigem < 1){
            System.out.println("Voce violou as dimensões do tabuleiro!");
            return false;
        }
	if (colunaOrigemInt > 8 || colunaOrigemInt < 1){
            System.out.println("Voce violou as dimensões do tabuleiro!");
            return false;
        }
	if (linhaDestino > 8 || linhaDestino < 1){
            System.out.println("Voce violou as dimensões do tabuleiro!");
            return false;
        }
	if (colunaDestinoInt > 8 || colunaDestinoInt < 1){
            System.out.println("Voce violou as dimensões do tabuleiro!");
            return false;
        }
        
        //verificar se posicao esta ocupada - PROXIMA FASE
        
        //criando objetos no tabuleiro para testar movimentos
        if (peca == 'p' || peca == 'P') {
            Peao novoP = new Peao(cor);
            return novoP.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt);
	}
	else if (peca == 't' || peca == 'T') {
            Torre novaT = new Torre(cor);
            return novaT.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt);
	}
	else if (peca == 'c' || peca == 'C') {
            Cavalo novoC = new Cavalo(cor);
            return novoC.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt);
	}
	else if (peca == 'b' || peca == 'B') {
            Bispo novoB = new Bispo(cor);
            return novoB.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt);
	}
	else if (peca == 'r' || peca == 'R') {
            Rei novoR = new Rei(cor);
            return novoR.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt);
	}
	else if (peca == 'd' || peca == 'D') {
            Dama novaD = new Dama(cor);
            return novaD.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt);
	}
	else {
            return false;
	}
    }
    
}
