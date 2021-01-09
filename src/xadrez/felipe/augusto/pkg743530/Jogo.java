package xadrez.felipe.augusto.pkg743530;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
    private Tabuleiro tabuleiro; //objeto tabuleiro
    private Jogador j1; //jogador 1
    private Jogador j2; //jogador 2
    private String estado; //em andamento, xeque, xeque-mate
    private int vezJogador; //0 para branco, 1 para preto
    private Peca[] pP = new Peca[16]; //vetor pecas pretas
    private Peca[] pB = new Peca[16]; //vetor pecas brancas
        
    //Métodos Especiais
    /**
     *Construtor de jogo quando o usuario carrega
     * 
     * @param nomeArquivo Nome do arquivo para ser lido
     */
    public Jogo(String nomeArquivo){
        try{
            String j1, j2, estado;
            String posicao[] = new String[65];
            char sinal;
            int i = 0, j = 0, k = 0;
            
            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader getArq = new BufferedReader(arquivo);
            
            String info = getArq.readLine();
            
            //Setando vez do jogador, jogadores e estado do jogo
            this.vezJogador = Integer.parseInt(info);
            info = getArq.readLine();
            j1 = info;
            info = getArq.readLine();
            j2 = info;
            info = getArq.readLine();
            this.estado = info;
            info = getArq.readLine();

            //setando pecas e posicao
            while(info != null){
                //verificando se eh peca preta ou branca
                sinal = info.charAt(info.length() - 1);
                switch (sinal) {
                    case '+': //pecas brancas
                        if("b+".equals(info))
                            this.pB[i] = new Bispo(0);
                        else if("p+".equals(info))
                            this.pB[i] = new Peao(0);
                        else if("t+".equals(info))
                            this.pB[i] = new Torre(0);
                        else if("c+".equals(info))
                            this.pB[i] = new Cavalo(0);
                        else if("d+".equals(info))
                            this.pB[i] = new Dama(0);
                        else if("r+".equals(info))
                            this.pB[i] = new Rei(0);
                        i++;
                        break;
                    case '-': //pecas pretas
                        if("B-".equals(info))
                            this.pP[j] = new Bispo(1);
                        else if("P-".equals(info))
                            this.pP[j] = new Peao(1);
                        else if("T-".equals(info))
                            this.pP[j] = new Torre(1);
                        else if("C-".equals(info))
                            this.pP[j] = new Cavalo(1);
                        else if("D-".equals(info))
                            this.pP[j] = new Dama(1);
                        else if("R-".equals(info))
                            this.pP[j] = new Rei(1);
                        j++;
                        break;
                    default: //posicoes
                        break;
                }
                posicao[k] = info;
                k++;
                info = getArq.readLine();
            }                       
            arquivo.close();
            
            //Criando Jogadores
            this.j1 = new Jogador(j1, pB, 0);
            this.j2 = new Jogador(j2, pP, 1);

            //Criando Tabuleiro
            this.tabuleiro = new Tabuleiro(pB, pP, posicao);
            
            //Chamando menu
            menu();
        }
        catch(IOException e){
            System.out.println("\nErro: Não foi possível ler o arquivo informado, verifique o nome informado!");
        }
    }
    
    /**
     *Construtor de jogo, responsável por criar o jogador com seu nome, cor e suas respectivas pecas
     * 
     * @param j1 Nome do jogador de pecas brancas
     * @param j2 Nome do jogador de pecas pretas
     */
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
        this.j1 = new Jogador(j1, pB, 0);
        this.j2 = new Jogador(j2, pP, 1);
        
        //Criando Tabuleiro
        this.tabuleiro = new Tabuleiro(pB, pP, null);
        
        //Setando Estado do Jogo
        this.estado = "Em andamento";
        
        //Setando primeiro jogador (branco)
        this.vezJogador = this.j1.getCor();
        
        //Chamando menu
        menu();
    }

    /**
     *Responsavel por retornar o estado da partida
     * 
     * @return Retorna uma string
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     *Responsavel por setar quando um novo estado de jogo acontece
     * 
     * @param estado Recebe uma String referente ao estado do jogo
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //Métodos Personalizados
    /**
     *Responsavel por mostrar o menu ao usuario
     * 
     */
    private void menu(){
        int linhaOrigem, linhaDestino;
        String colunaOrigem, colunaDestino;
        String opcao = "-1"; //menu para informar se salva ou movimenta peca
        Scanner read = new Scanner(System.in);
        
        while(!"0".equals(opcao) && !"Xeque Mate".equals(estado)) {
            if(vezJogador == 0)
                System.out.println("\nVez do Jogador: " + this.j1.getNome());
            else
                System.out.println("\nVez do Jogador: " + this.j2.getNome());
            tabuleiro.desenho();
            System.out.println("\n  ======================================");
            System.out.println("  |     1 - Realizar Movimento         |");
            System.out.println("  |     2 - Salvar Jogo                |");
            System.out.println("  |     0 - Sair                       |");
            System.out.println("  ======================================\n");

            System.out.print("\nDigite a opção desejada: ");
            opcao = read.nextLine();

            switch (opcao) {
                case "1":
                    try{
                        System.out.print("\nDigite a linha de origem: ");
                        linhaOrigem = Integer.parseInt(read.nextLine());
                        System.out.print("\nDigite a coluna de origem: ");
                        colunaOrigem = read.nextLine().toUpperCase();

                        System.out.print("\nDigite a linha destino: ");
                        linhaDestino = Integer.parseInt(read.nextLine());
                        System.out.print("\nDigite a coluna destino: ");
                        colunaDestino = read.nextLine().toUpperCase();
                        rodada(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
                        //verificar vez do jogador
                        //verificar estado do jogo
                        break;
                    }
                    catch(NumberFormatException e){
                        System.out.println("\nErro: Digite valores corretos para linha (1 - 8) e coluna (A - H)!\n");
                        break;
                    }

                case "2":
                    salvar();
                    break;

                case "0":
                    System.out.println("\nTchau, tchau!");
                    break;

                default:
                    System.out.println("\nErro: Digite uma opção presente no menu!\n");
                    break;
            }    
        }
    }
    
    /**
     *Responsavel chamar a verificacao das peças e tratar os turnos da partida
     * 
     * @param linhaOrigem Coordenada linha de origem da peca
     * @param colunaOrigem Coordenada coluna de origem da peca
     * @param linhaDestino Coordenada linha de destino da peca
     * @param colunaDestino Coordenada linha de destino da peca
     * @return Retorna um boolean se a rodada trocou
     */
    private void rodada(int linhaOrigem, String colunaOrigem, int linhaDestino, String colunaDestino){
        //usando ascii para converter string para char e depois int
        int colunaOrigemInt = colunaOrigem.charAt(0) - 65;
        int colunaDestinoInt = colunaDestino.charAt(0) - 65; 
        
        //subtraindo 1 para obter o verdadeira indice na matriz de objetos Posicao
        linhaOrigem--; 
        linhaDestino--; 

        //jogador branco
        if(vezJogador == this.j1.getCor()){
            if(tabuleiro.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt, j1.getCor())){
                //se o movimento foi valido troca a vez do jogador
                vezJogador = j2.getCor();
            }
        }
        //jogador preto
        else{
            if(tabuleiro.checaMovimento(linhaOrigem, colunaOrigemInt, linhaDestino, colunaDestinoInt, j2.getCor())){
                //se o movimento foi valido troca a vez do jogador
                vezJogador = j1.getCor();
            }
        }
        xequeMate();
    }
    
    /**
     *Responsavel por verificar xeque mate a partida, verifica se algum dos reis foi capturado
     * 
     */
    private void xequeMate(){
        int rei = 0; //sempre tem que ter dois, caso tenha um só é pq o jogo acabou
        
        for(int i = 8; i > 0; i--)
            for(int j = 0; j < 8; j++)
                if(tabuleiro.getPosicao(i - 1, j).getOcupante() != null)
                    if("R-".equals(tabuleiro.getPosicao(i - 1, j).getOcupante().desenho()) || "r+".equals(tabuleiro.getPosicao(i - 1, j).getOcupante().desenho()))
                        rei++;
                    
        if(rei != 2){
            System.out.println("Rei capturado. Fim de Jogo!!!");
            estado = "Xeque Mate";
        }
    }
    
    /**
     *Responsavel por salvar a partida
     * 
     */
    private void salvar(){
        String nomeArquivo;
        Scanner read = new Scanner(System.in);
        
        System.out.print("\nDigite o nome do arquivo para salvar: ");
        nomeArquivo = read.nextLine();
        
        //tenta criando arquivo
        try{
            FileWriter arq = new FileWriter(nomeArquivo + ".txt");
            //escrevendo no arquivo
            PrintWriter setArq = new PrintWriter(arq);
            //salvando vez do jogador
            setArq.printf(vezJogador + "\n");
            //salvando jogadores
            setArq.printf(j1.getNome() + "\n");
            setArq.printf(j2.getNome() + "\n");
            //salvando estado
            setArq.printf(getEstado() + "\n");
            //salvando tabuleiro
            for(int i = 8; i > 0; i--){
                for(int j = 0; j < 8; j++){
                    if(tabuleiro.getPosicao(i - 1, j).getOcupante() == null){
                        setArq.printf(tabuleiro.getPosicao(i - 1, j).isCor() + "\n");
                    }    
                    else{
                        setArq.printf(tabuleiro.getPosicao(i - 1, j).getOcupante().desenho() + "\n");
                    }
                }
            }
            setArq.close();
            System.out.println("\nArquivo criado com sucesso!!!\n");
        }
        catch(IOException e){
            System.out.println("\nErro: Problema ao escrever no arquivo!!!\n");
        }
    }
}
