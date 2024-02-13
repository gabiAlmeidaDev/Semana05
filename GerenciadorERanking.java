package jogador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GerenciadorERanking {
    public List<Jogador> jogadores;
    private Scanner entrada;

    public GerenciadorERanking() {
        this.jogadores = new ArrayList<>();
        this.entrada = new Scanner(System.in);
    }

    public boolean adicionarJogador(Jogador novoJogador) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(novoJogador.getNome())) {
                return false;
            }
        }
        jogadores.add(novoJogador);
        return true;
    }

    public Jogador buscarJogadorPeloNome(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador;
            }
        }
        return null;
    }
    // ex. 05 pede pra verificar se o jogador existe ou precisa criar um novo.
    public Jogador obterOuCriarJogador() {
        System.out.println("Digite o nome do jogador:");
        String nome = entrada.nextLine();

        Jogador jogador = buscarJogadorPeloNome(nome);
        if (jogador == null) {
            System.out.println("Jogador não encontrado. Criando um novo jogador para: " + nome);
            System.out.println("Por favor, digite a idade do jogador:");
            int idade = entrada.nextInt();
            entrada.nextLine();
            jogador = new Jogador(nome, idade, 0, 0);
            adicionarJogador(jogador);
            System.out.println("Jogador " + nome + " adicionado com sucesso!");
        } else {
            System.out.println("Bem-vindo de volta, " + nome + "!");
        }
        return jogador;
    }


    public void atualizarPontuacao(String nome, int pontos) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                jogador.adicionaPontos(pontos);
                break;
            }
        }
    }

    public void adicionarTentativa(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                jogador.adicionaTentativa();
                break;
            }
        }
    }

    // O ex. 03 pede pra criar uma lista com os melhores jogadores:
    // aqui já está com o método para os 10 primeiros e para o ranking total que é pedido no ex.04 e depois no ex.08 também pra imprimir no main..
    public void exibirRanking(boolean apenasTop10) {
        jogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());

        int limite = apenasTop10 ? Math.min(jogadores.size(), 10) : jogadores.size();
        for (int i = 0; i < limite; i++) {
            Jogador jogador = jogadores.get(i);
            System.out.println((i + 1) + " - " + jogador.getNome() + " - Pontuação: " + jogador.getPontuacao());
        }
    }

}

