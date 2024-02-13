package jogador;

import java.util.Random;
import java.util.Scanner;

public class Jogo { // ex.06 completo aqui. ex.07 também.
    private Jogador melhorJogador;
    private int numeroJogadas = 0;

    private Scanner entrada = new Scanner(System.in);
    private Random random = new Random();


    public void jogarPPT(Jogador jogador) {

        String[] escolhas = {"Pedra", "Papel", "Tesoura"};
        System.out.println("Escolha: 1 para Pedra, 2 para Papel, 3 para Tesoura");
        int usuarioEscolheu = entrada.nextInt() - 1;
        int computadorEscolheu = random.nextInt(escolhas.length);

        System.out.println("Você escolheu: " + escolhas[usuarioEscolheu]);
        System.out.println("Computador escolheu: " + escolhas[computadorEscolheu]);

        if (usuarioEscolheu == computadorEscolheu) {
            System.out.println("Empate");
        } else if ((usuarioEscolheu == 1 && computadorEscolheu == 3) ||
                   (usuarioEscolheu == 2 && computadorEscolheu == 1) ||
                   (usuarioEscolheu == 3 && computadorEscolheu == 2)) {
                System.out.println("Parabéns! Você ganhou!");
                jogador.adicionaPontos(1);

            } else {
            System.out.println("Você perdeu!");
            jogador.perdePontos(1);
        }
    }
    public void jogarAdvinhacao(int num, Jogador jogador) {
        int numeroAleatorio = random.nextInt(num + 1);
        int tentativas = 10;

        System.out.println("Adivinhe o número entre 0 e " + num + ". Você tem " + tentativas + " tentativas.");

        for (int i = 0; i < tentativas; i++) {
            System.out.println("Tentativa " + (i + 1) + ": ");
            int palpilte = entrada.nextInt();

            if (palpilte == numeroAleatorio) {
                System.out.println("Parabéns! Você acertou o número em " + (i + 1) + " tentativas");
                int pontosGanhos = 11 - (i + 1);
                System.out.println("Você ganhou " + pontosGanhos + " pontos.");
                jogador.adicionaPontos(pontosGanhos);
                return;

            } else if (palpilte < numeroAleatorio) {
                System.out.println("O número é maior que " + palpilte + "-");
            } else {
                System.out.println("O número é menor que " + palpilte + "-");
            }
        }
        System.out.println("Vovê usou todas as tentativas. O número era: " + numeroAleatorio);

        jogador.perdePontos(1);

    }
}
