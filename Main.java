package jogador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {  // o ex. 08

        GerenciadorERanking gerenciador = new GerenciadorERanking();
        Scanner entrada = new Scanner(System.in);
        Jogo jogo = new Jogo();
        Jogador jogadorAtual = null;

        boolean sair = false;
        while (!sair) {
            if (jogadorAtual == null) {
                jogadorAtual = gerenciador.obterOuCriarJogador();
            }
            System.out.println("******************************************");
            System.out.println("Bem vindo ao Jogo! Escolha qual quer jogar: ");
            System.out.println("1 - Jogar Pedra, Papel e Tesoura");
            System.out.println("2 - Jogar Adivinhação de Números");
            System.out.println("3 - Ver Ranking completo");
            System.out.println("4 - Ver top 10");
            System.out.println("5 - Trocar de Jogador");
            System.out.println("0 - Sair");
            System.out.print("Número da opção escolhida: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    jogo.jogarPPT(jogadorAtual);
                    break;
                case 2:
                    System.out.println("Digite um número limite par o jogo da adivinhação.");
                    int num = entrada.nextInt();
                    jogo.jogarAdvinhacao(num, jogadorAtual);
                    break;
                case 3:
                    System.out.println("O ranking completo: ");
                    gerenciador.exibirRanking(false);
                    break;
                case 4:
                    System.out.println("Os top 10 são: ");
                    gerenciador.exibirRanking(true);
                    break;
                case 5:
                    jogadorAtual = null;
                    break;
                case 0:
                    sair = true;
                    System.out.println("Obrigado por jogar!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        entrada.close();
    }
}



