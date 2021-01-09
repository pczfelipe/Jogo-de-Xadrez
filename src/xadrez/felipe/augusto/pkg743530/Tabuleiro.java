package xadrez.felipe.augusto.pkg743530;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Tabuleiro {
    //Atributos
    private Posicao[][] mesa = new Posicao[8][8]; //vetor de objetos posicao. Um tabuleiro é formado por diversos objetos posicao
    private final int linha[] = {1, 2, 3, 4, 5, 6, 7, 8}; //linhas do tabuleiro
    private final String coluna[] = {"A", "B", "C", "D", "E", "F", "G", "H"}; //colunas do tabuleiro
    
    //Metodos Especiais    
    /**
     *Construtor de tabuleiro, responsável por criar as posições e inserir as peças criadas nas posicoes iniciais do xadrex
     * 
     * @param pB Peças brancas do tabuleiro
     * @param pP Peças pretas do tabuleiro
     * @param arquivo Recebe as informacoes do arquivo carregado, se nao for carregado nada, recebe null
     */
    public Tabuleiro(Peca[] pB, Peca[] pP, String[] arquivo) {
        String coluna, cor;
        char sinal;
        int k = 0, m = 0, n = 0;
        
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
        
        if(arquivo != null){ //setando pecas carregadas
            for(int i = 8; i > 0; i--){
                for(int j = 0; j < 8; j++){
                    sinal = arquivo[k].charAt(arquivo[k].length() - 1);

                    if(sinal == '+'){
                        this.mesa[i-1][j].setOcupante(pB[m]);
                        m++;
                    }
                    else if(sinal == '-'){
                        this.mesa[i-1][j].setOcupante(pP[n]);
                        n++;
                    }
                    
                    k++;
                }
            }
        }
        else{  //setando pecas (Torre, Cavalo, Bispo, Rei, Dama) inicialmente no tabuleiro
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
    }
    
     /**
     *Retorna um objeto posicao de acordo com a linha e coluna informada
     * 
     * @param linha Coordenada Linha da Posicao
     * @param coluna Coordenada Coluna da Posicao
     * @return Retorna um objeto posicao 
     */
    public Posicao getPosicao(int linha, int coluna){
        return this.mesa[linha][coluna];
    }
    
    //Metodos Personalizados
    /**
     *Responsavel por fazer o desenho do tabuleiro
     */
    public void desenho(){
        //imprimindo as coordenadas
        System.out.print("     ");
        for(int i = 0; i < 8; i++)
            System.out.print(coluna[i] + "  ");
        
        System.out.println("\n");
        
        for(int i = 8; i > 0; i--){
            //imprimindo as coordenadas
            System.out.print(i + "    ");
            for(int j = 0; j < 8; j++){
                if(mesa[i-1][j].getOcupante() == null) //se nao tem ocupando imprime a cor da posicao (00 ou 11)
                    System.out.print(getPosicao(i-1, j).isCor() + " ");
                else
                    System.out.print(mesa[i-1][j].getOcupante().desenho() + " ");
            }
            System.out.println("");
        }
    }
    
    /**
     *Responsavel por verificar as irregularidades de movimento do xadrez
     * 
     * @param linhaOrigem Coordenada linha de origem da peca
     * @param colunaOrigemInt  Coordenada coluna de origem da peca
     * @param linhaDestino Coordenada linha de destino da peca
     * @param colunaDestinoInt  Coordenada linha de destino da peca
     * @param cor Cor do jogador
     * @return 0 para movimento invalido, 1 para movimento valido, 2 para movimento valido e captura
     */
    public boolean checaMovimento(int linhaOrigem, int colunaOrigemInt, int linhaDestino, int colunaDestinoInt, int cor){
        //verificando coordenadas
        if(linhaOrigem > 7 || linhaOrigem < 0){
            System.out.println("\nErro: Movimento Inválido! A Coordenada Linha de Origem viola a dimensão do tabuleiro!\n");
            return false;
        }
        else if(linhaDestino > 7 || linhaDestino < 0){
            System.out.println("\nErro: Movimento Inválido! A Coordenada Linha de Destino viola a dimensão do tabuleiro!\n");
            return false;
        }
        else if(colunaOrigemInt > 7 || colunaOrigemInt < 0){
            System.out.println("\nErro: Movimento Inválido! A Coluna de Origem viola a dimensão do tabuleiro!\n");
            return false;
        }
        else if(colunaDestinoInt > 7 || colunaDestinoInt < 0){
            System.out.println("\nErro: Movimento Inválido! A Coluna de Destino viola a dimensão do tabuleiro!\n");
            return false;
        }
        
        //verificando se a posicao de origem eh vazia
        if(mesa[linhaOrigem][colunaOrigemInt].getOcupante() == null){
            System.out.println("\nErro: Movimento Inválido! A Coordenada de Origem informada não possui uma peça disponível!\n");
            return false;
        }

        //verificando se a posicao de origem eh valida (coluna)
        if((linhaOrigem == linhaDestino) && (colunaOrigemInt == colunaDestinoInt)){
            System.out.println("\nErro: Movimento Inválido! A Coordenada de Origem é igual a Coordenada de Destino!\n");
            return false;
        }

        //verificando se o jogador esta andando com a peca dele
        if(cor != mesa[linhaOrigem][colunaOrigemInt].getOcupante().getCor()){
            System.out.println("\nErro: Movimento Inválido! A Coordenada de Origem possui uma peça que não pertence a você!\n");
            return false;
        }

        //verificando se a coordenada de destino tem uma peca adversaria, se for uma peca do mesmo jogador o movimento eh invalido
        //usaremos isso para verificar o peao andando em diagonal em caso de captura
        boolean adversario = false;
        if(mesa[linhaDestino][colunaDestinoInt].getOcupante() != null){
            if(cor == mesa[linhaDestino][colunaDestinoInt].getOcupante().getCor()){
                System.out.println("\nErro: Movimento Inválido! A Coordenada de Destino possui uma peça sua!\n");
                return false;
            }
            adversario = true;
        }

        //verificando se o movimento eh valido de acordo com a peca informada, no caso do peao eh diferente ja que ele captura na diagonal
        if(adversario == true){
            if("p+".equals(mesa[linhaOrigem][colunaOrigemInt].getOcupante().desenho()) || "P-".equals(mesa[linhaOrigem][colunaOrigemInt].getOcupante().desenho())){
                if((colunaDestinoInt == colunaOrigemInt + 1) || (colunaDestinoInt == colunaOrigemInt - 1)){
                    if((linhaOrigem - linhaDestino == 1 && cor == 1) || (linhaDestino - linhaOrigem == 1 && cor == 0)){ //aqui tem que verificar a direcao e a cor da peca para evitar que o peao capture pra tras
                        novaPosicao(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt, adversario);
                        return true;
                    }
                }
                System.out.println("\nErro: Movimento Inválido! Verifique se o movimento informado é válido de acordo com o tipo de peça selecionada!\n");
                return false;
            }
        }
        
        //verificando se o movimento eh valido de acordo com a peca informada
        if(!mesa[linhaOrigem][colunaOrigemInt].getOcupante().checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt)){
            System.out.println("\nErro: Movimento Inválido! Verifique se o movimento informado é válido de acordo com o tipo de peça selecionada!\n");
            return false;
        }
        
        //verificando se eh cavalo, se for ele pode pular peca
        if("c+".equals(mesa[linhaOrigem][colunaOrigemInt].getOcupante().desenho()) || "C-".equals(mesa[linhaOrigem][colunaOrigemInt].getOcupante().desenho())){
            novaPosicao(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt, adversario);
            return true;
        }

        //verificando se existe alguma peca na frente
        if(caminhoPeca(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt)){
            //se passar por todas as excessoes o movimento eh valido
            novaPosicao(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt, adversario);
            return true;
        }
        else{
            System.out.println("\nErro: Movimento Inválido! Existe uma peça no meio do caminho!\n");
            return false;
        }
    }
    
     /**
     *Responsavel por verificar se existe alguma peca no meio do caminho da origem ate o destino que bloqueia o movimento da peca
     * 
     * @param linhaOrigem Coordenada linha de origem da peca
     * @param colunaOrigem Coordenada coluna de origem da peca
     * @param linhaDestino Coordenada linha de destino da peca
     * @param colunaDestino Coordenada linha de destino da peca
     * @return True caso nao haja peca no caminho e False para peca no caminho que atrapalham o movimento da peca
     */
    private boolean caminhoPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        int comeco, fim; //variaveis auxiliares para percorrer o caminho na direcao correta
        
        if(linhaOrigem == linhaDestino){ //andando horizontalmente
            if(colunaOrigem > colunaDestino){
                comeco = colunaDestino + 1; //procurando a frente
                fim = colunaOrigem;
            }
            else{
                comeco = colunaOrigem + 1; //procurando a frente
                fim = colunaDestino;
            }
            //procurando pecas atrapalhando o movimento
            for(int i = comeco; i < fim; i++)
                if(mesa[linhaOrigem][i].getOcupante() != null)
                    return false;
        }
        else if(colunaOrigem == colunaDestino){ //andando verticalmente
            if(linhaOrigem > linhaDestino){
                comeco = linhaDestino + 1; //procurando a frente
                fim = linhaOrigem;
            }
            else{
                comeco = linhaOrigem + 1; //procurando a frente
                fim = linhaDestino;
            }
            //procurando pecas atrapalhando o movimento
            for(int i = comeco; i < fim; i++)
                if(mesa[i][colunaOrigem].getOcupante() != null)
                    return false;
        }
        else{ //andando na diagonal
            int fimDiagonal; //usada apenas para verificar a diagonal da linha e ir caminhando
            
            if(linhaOrigem > linhaDestino){ //verificando ate onde a diagonal irá andar
                comeco = linhaDestino;
                fimDiagonal = linhaOrigem;
            }
            else{
                comeco = linhaOrigem;
                fimDiagonal = linhaDestino;
            }
            
            fim = (colunaOrigem < colunaDestino) ? colunaOrigem : colunaDestino;
            
            if(((colunaDestino - colunaOrigem < 0) && (linhaDestino - linhaOrigem > 0)) || ((colunaDestino - colunaOrigem > 0) && (linhaDestino - linhaOrigem < 0))){ //verificando esquerda em cima e direita em baixo
                fimDiagonal--;
                fim++;
                while(fimDiagonal > comeco){
                    if(mesa[fimDiagonal][fim].getOcupante() != null)
                        return false;
                    
                    fimDiagonal--;
                    fim++;
                }
            }
            else if(((colunaDestino - colunaOrigem < 0) && (linhaDestino - linhaOrigem < 0)) || ((colunaDestino - colunaOrigem > 0) && (linhaDestino - linhaOrigem > 0))){ //verificando esquerda em baixo e direita em cima
                comeco++;
                fim++;
                while(comeco < fimDiagonal){
                    if(mesa[comeco][fim].getOcupante() != null)
                        return false;
                    
                    comeco++;
                    fim++;
                }
            }
        }
        //se passou por todas verificacoes o movimento eh valido
        return true;
    }
    
     /**
     *Responsavel por atualizar nova posicao e deixar nula a anterior
     * 
     * @param linhaOrigem Coordenada linha de origem da peca
     * @param colunaOrigem Coordenada coluna de origem da peca
     * @param linhaDestino Coordenada linha de destino da peca
     * @param colunaDestino Coordenada linha de destino da peca
     * @param colunaDestinoString Coordenada linha de destino da peca (em texto)
     */
    private void novaPosicao(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, boolean adversario) {
        System.out.println("\nSucesso: Movimento Válido! A peça " + mesa[linhaOrigem][colunaOrigem].getOcupante().desenho() + " agora está em [" + (linhaDestino + 1) + ',' + coluna[colunaDestino] + "]\n");
        //setando estado da peca para fora do jogo
        if(adversario == true)
            mesa[linhaDestino][colunaDestino].getOcupante().setInGame(false);
        
        //setando nova posicao
        mesa[linhaDestino][colunaDestino].setOcupante(mesa[linhaOrigem][colunaOrigem].getOcupante());
        mesa[linhaOrigem][colunaOrigem].setOcupante(null);
    }
}
