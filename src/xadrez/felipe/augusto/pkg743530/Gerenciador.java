package xadrez.felipe.augusto.pkg743530;
import java.util.Scanner;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Gerenciador {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String flag = "-1"; //informa se o jogo sera carregado ou iniciado
        String j1, j2; //nomes do jogadores j1 branco, j2 preto
        
        while(!"0".equals(flag)) {
            System.out.println("\n  ======================================");
            System.out.println("  |     1 - Carregar Jogo              |");
            System.out.println("  |     2 - Novo Jogo                  |");
            System.out.println("  |     0 - Sair                       |");
            System.out.println("  ======================================\n");
            
            System.out.print("\nDigite a opção desejada: ");
            flag = read.nextLine();
            
             switch (flag) {
                case "1":
                    String nomeArquivo;
                    
                    System.out.print("\nDigite o nome do arquivo para ler: ");
                    nomeArquivo = read.nextLine()+ ".txt";
                    
                    //criando objeto jogo
                    Jogo jCarregado = new Jogo(nomeArquivo);
                    break;
                    
                case "2":
                    //Jogadores
                    System.out.print("\nDigite o nome do Jogador 1 (Peças Brancas +): ");
                    j1 = read.nextLine();
                    System.out.print("\nDigite o nome do Jogador 2 (Peças Pretas -): ");
                    j2 = read.nextLine();

                    //Boas Vindas e Construindo Jogo
                    System.out.println("\nBEM VINDOS AO JOGO DE XADREZ! (" + j1 + " x " + j2+ ")\n");
                    Jogo j = new Jogo(j1, j2);
                    break;
                
                case "0":
                    System.out.println("\nTchau, tchau!");
                    break;
                    
                default:
                    System.out.println("\nErro: Digite uma opção presente no menu!");
                    break;
            }
        }
        System.exit(0);
    } 
}
