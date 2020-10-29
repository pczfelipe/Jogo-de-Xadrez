package xadrez.felipe.augusto.pkg743530;

import java.util.Scanner;

/**
 *
 * @author Felipe Augusto - 743530
 */
public class Teste {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int opcao = 0; //menu para testar peca
        int linhaOrigem, linhaDestino; 
        String colunaOrigem, colunaDestino;
        
        //Boas Vindas e Tabuleiro Inicial
        //0 são posicoes em branco e 1 são posicoes em preto
        System.out.println("\nBEM VINDOS AO JOGO DE XADREZ!\n");
        
        Jogo j = new Jogo();
        
	do {
            System.out.println("\n\n### TESTE DAS PEÇAS DE XADREZ ###");
            System.out.println("\n=========================");
            System.out.println("  |     1 - Bispo         |");
            System.out.println("  |     2 - Cavalo        |");
            System.out.println("  |     3 - Dama          |");
            System.out.println("  |     4 - Peao          |");
            System.out.println("  |     5 - Rei           |");
            System.out.println("  |     6 - Torre         |");
            System.out.println("  |     0 - Sair          |");
            System.out.println("  =========================\n");

            System.out.print("\nDigite a peça desejada para testar: ");
            opcao = read.nextInt();
            
            if(opcao != 0 && opcao <= 6){
                System.out.print("\nDigite a linha de origem: ");
                linhaOrigem = read.nextInt();
                System.out.print("\nDigite a coluna de origem: ");
                colunaOrigem = read.next().toUpperCase();

                System.out.print("\nDigite a linha destino: ");
                linhaDestino = read.nextInt();
                System.out.print("\nDigite a coluna destino: ");
                colunaDestino = read.next().toUpperCase();

                switch (opcao) {
                    case 1:
                        System.out.println("\nTestando Bispo");
                        if(j.testePecas('b', linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
                            System.out.println("Movimento válido! Sua posição atual é: (" + linhaDestino + ", " + colunaDestino + ")");
                        else
                            System.out.println("Movimento inválido! Sua posição atual é: (" + linhaOrigem + ", " + colunaOrigem + ")");
                        break;

                    case 2:
                        System.out.println("\nTestando Cavalo");
                        if(j.testePecas('c', linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
                            System.out.println("Movimento válido! Sua posição atual é: (" + linhaDestino + ", " + colunaDestino + ")");
                        else
                            System.out.println("Movimento inválido! Sua posição atual é: (" + linhaOrigem + ", " + colunaOrigem + ")");
                        break;

                    case 3:
                        System.out.println("\nTestando Dama");
                        if(j.testePecas('d', linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
                            System.out.println("Movimento válido! Sua posição atual é: (" + linhaDestino + ", " + colunaDestino + ")");
                        else
                            System.out.println("Movimento inválido! Sua posição atual é: (" + linhaOrigem + ", " + colunaOrigem + ")");
                        break;

                    case 4:
                        System.out.println("\nTestando Peao");
                        if(j.testePecas('p', linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
                            System.out.println("Movimento válido! Sua posição atual é: (" + linhaDestino + ", " + colunaDestino + ")");
                        else
                            System.out.println("Movimento inválido! Sua posição atual é: (" + linhaOrigem + ", " + colunaOrigem + ")");
                        break;

                    case 5:
                        System.out.println("\nTestando Rei");
                        if(j.testePecas('r', linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
                            System.out.println("Movimento válido! Sua posição atual é: (" + linhaDestino + ", " + colunaDestino + ")");
                        else
                            System.out.println("Movimento inválido! Sua posição atual é: (" + linhaOrigem + ", " + colunaOrigem + ")");
                        break;

                    case 6:
                        System.out.println("\nTestando Torre");
                        if(j.testePecas('t', linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
                            System.out.println("Movimento válido! Sua posição atual é: (" + linhaDestino + ", " + colunaDestino + ")");
                        else
                            System.out.println("Movimento inválido! Sua posição atual é: (" + linhaOrigem + ", " + colunaOrigem + ")");
                        break;

                    default:
                        break;
                }
            }
            else if(opcao == 0)
                System.out.println("Tchau, tchau!");
            else
                System.out.println("Opção Inválida!");
	} while (opcao != 0); 
    }
    
}
