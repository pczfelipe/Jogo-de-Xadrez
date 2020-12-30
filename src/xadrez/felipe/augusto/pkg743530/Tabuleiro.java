package xadrez.felipe.augusto.pkg743530;

//Impotanto Excessoes
import Excessoes.ColunaDestino;
import Excessoes.LinhaDestino;
import Excessoes.OrigemIgualDestino;
import Excessoes.OrigemVazia;
import Excessoes.PecaFrente;
//Importando Pecas
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
    private int linha[] = {1, 2, 3, 4, 5, 6, 7, 8};
    private String coluna[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
    
    //Metodos Especiais
    public Tabuleiro(Peca[] pB, Peca[] pP) {
        String coluna;
        String cor;
        
        for(int i = 8; i > 0; i--){
            for(int j = 0; j < 8; j++){
                switch(j){
                    case 0:
                        coluna = this.coluna[0];
                        break;
                    case 1:
                        coluna = this.coluna[1];
                        break;
                    case 2:
                        coluna = this.coluna[2];
                        break;
                    case 3:
                        coluna = this.coluna[3];
                        break;
                    case 4:
                        coluna = this.coluna[4];
                        break;
                    case 5:
                        coluna = this.coluna[5];
                        break;
                    case 6:
                        coluna = this.coluna[6];
                        break;
                    case 7:
                        coluna = this.coluna[7];
                        break;
                    default:
                        coluna = "X";
                        break;
                }
                
                //verificando cor da posicao do tabuleiro e setando-a
                if (i % 2 == 0){
                    if (j % 2 == 0)
                        cor = "00"; //casa branca
                    else
                        cor = "11"; //casa preta
                }
                else {
                    if (j % 2 == 0)
                        cor = "11"; //casa preta
                    else
                        cor = "00"; //casa branca
                }
                
                //criando objeto posicao e adicionando linha e coluna do tabuleiro
                this.mesa[i-1][j] = new Posicao(cor, i, coluna);
            }
        }
        
        //setando pecas (Torre, Cavalo, Bispo, Rei, Dama) inicialmente no tabuleiro
        for(int i = 0; i < 8; i++){
            this.mesa[7][i].setOcupante(pP[i]);
            this.mesa[0][i].setOcupante(pB[i]);
        }
        //setando pecas (Peao) inicialmente no tabuleiro
        for(int i = 0; i < 8; i++){
            this.mesa[6][i].setOcupante(pP[i+8]);
            this.mesa[1][i].setOcupante(pB[i+8]);
        }
    }
    
    private Posicao getPosicao(int linha, int coluna){
        return this.mesa[linha][coluna];
    }
    
    //Metodos Personalizados
    public void desenho(){
        String colunas[] = {"AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH"};
        
        //imprimindo as coordenadas
        System.out.print("     ");
        for(int i = 0; i < 8; i++)
            System.out.print(colunas[i] + " ");
        
        System.out.println("\n");
        
        for(int i = 8; i > 0; i--){
            //imprimindo as coordenadas
            System.out.print(i + "    ");
            for(int j = 0; j < 8; j++){
                if(this.mesa[i-1][j].getOcupante() == null)
                    System.out.print(getPosicao(i-1, j).isCor() + " ");
                else
                    System.out.print(this.mesa[i-1][j].getOcupante().desenho() + " ");
            }
            
            System.out.println("");
        }
    }
    
    //checa movimento está recebendo as peças especificas mas na proxima fase ira receber apenas objeto Posicao
    public boolean checaMovimento(Peca p, int linhaOrigem, String colunaOrigem, int linhaDestino, String colunaDestino){
        //variaveis para converter coluna String para inteiro para buscar na matriz mesa
        int colunaOrigemInt, colunaDestinoInt;

        //convertendo string coluna para int
        switch(colunaOrigem){
            case "A":
                colunaOrigemInt = 0;
                break;
            case "B":
                colunaOrigemInt = 1;
                break;
            case "C":
                colunaOrigemInt = 2;
                break;
            case "D":
                colunaOrigemInt = 3;
                break;
            case "E":
                colunaOrigemInt = 4;
                break;
            case "F":
                colunaOrigemInt = 5;
                break;
            case "G":
                colunaOrigemInt = 6;
                break;
            case "H":
                colunaOrigemInt = 7;
                break;
            default:
                colunaOrigemInt = 8;
                break;
        }
        //convertendo string coluna para int
        switch(colunaDestino){
            case "A":
                colunaDestinoInt = 0;
                break;
            case "B":
                colunaDestinoInt = 1;
                break;
            case "C":
                colunaDestinoInt = 2;
                break;
            case "D":
                colunaDestinoInt = 3;
                break;
            case "E":
                colunaDestinoInt = 4;
                break;
            case "F":
                colunaDestinoInt = 5;
                break;
            case "G":
                colunaDestinoInt = 6;
                break;
            case "H":
                colunaDestinoInt = 7;
                break;
            default:
                colunaDestinoInt = 8;     
                break;
        }
        
        try{
            //verificando se a coordenada de destino esta dentro das dimensoes do tabuleiro
            for(int i = 0; i < 8; i++){
                if(this.linha[i] != linhaDestino)
                    throw new LinhaDestino();
                if(this.coluna[i] != colunaDestino)
                    throw new ColunaDestino();
            }
            
            //verificando se a posicao de origem eh valida
            if(this.mesa[linhaOrigem-1][colunaOrigemInt].getOcupante() == null)
                throw new OrigemVazia();
            if((linhaOrigem == linhaDestino) && (colunaOrigem == colunaDestino))
                throw new OrigemIgualDestino(); 
            
            //verificando se existe alguma peca na frente
            
            
            //verificando se o movimento eh valido de acordo com a peca informada
            if(p.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt) == false)
                throw new Exception();
            
            //se passar por todas as excessoes o movimento eh valido
            System.out.println("\nErro: Movimento Válido! A peça agora está em [" + linhaDestino + ',' + colunaDestino + ']');
            return true;
            
        }
        catch(LinhaDestino e){
            System.out.println("\nErro: Movimento Inválido! Verifique a linha de destino informada!");
            return false;
        }
        catch(ColunaDestino e){
            System.out.println("\nErro: Movimento Inválido! Verifique a coluna de destino informada!");
            return false;
        }
        catch(OrigemVazia e){
            System.out.println("\nErro: Movimento Inválido! A Coordenada de Origem informada não possui nenhuma peça!");
            return false;
        }
        catch(OrigemIgualDestino e){
            System.out.println("\nErro: Movimento Inválido! A Coordenada de Origem é a mesma que a Coordenada de Destino!");
            return false;
        }
        catch(PecaFrente e){
            System.out.println("\nErro: Movimento Inválido! Existe uma peca no meio do caminho do movimento!");
            return false;
        }
        catch(Exception e){
            System.out.println("\nErro: Movimento Inválido! Verifique se o movimento informado é válido de acordo com o tipo de peça selecionada!");
            return false;
        }
    }
}
