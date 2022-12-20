import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JogoDaVelha novoJogo = new JogoDaVelha();

        String posicao;

        int jogadas = 0;
        int jogadaValida = 0;

        while(true) {

            System.out.println("Jogo da Velha");
            novoJogo.exibirTabuleiro();
            do {
                System.out.print("Jogador 1, informe uma posição no tabuleiro: ");
                posicao = scanner.next();
                while (!novoJogo.verificarJogada(posicao)) {
                    System.out.println("Jogada inválida, tente novamente!");
                    System.out.print("Jogador 1, informe uma posição: ");
                    posicao = scanner.next();
                    jogadaValida = 0;
                }
                novoJogo.jogando(posicao, "O");

                jogadaValida = 1;

            } while (jogadaValida == 0);
            jogadas++;
            jogadaValida = 0;

            novoJogo.exibirTabuleiro();

            if (!novoJogo.ganhador(jogadas).equals("null")) {
                break;
            }

            do {
                System.out.print("Jogador 2, informe uma posição no tabuleiro: ");
                posicao = scanner.next();
                while (!novoJogo.verificarJogada(posicao)) {
                    System.out.println("Jogada inválida, tente novamente!");
                    System.out.print("Jogador 2, informe uma posição: ");
                    posicao = scanner.next();
                    jogadaValida = 0;
                }
                novoJogo.jogando(posicao, "X");

                jogadaValida = 1;

            } while (jogadaValida == 0);

            jogadas++;
            jogadaValida = 0;

            novoJogo.exibirTabuleiro();

            if (!novoJogo.ganhador(jogadas).equals("null")) {
                break;
            }
        }
        System.out.println("O "+ novoJogo.ganhador(jogadas)+ " venceu!");
    }
}

class JogoDaVelha{

    private String[][] tabuleiro = {{"1", "2", "3"},
                                    {"4", "5", "6"},
                                    {"7", "8", "9"}};

    public String exibirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(" " + tabuleiro[i][j]);
            }
            System.out.println("\n");
        }
        return null;
    }

    public boolean verificarJogada(String posicao) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j].equals(posicao))
                    return true;
            }
        }
        return false;
    }


    public void jogando(String posicao, String jogador) {
        if(posicao.equals("1"))
            tabuleiro[0][0] = jogador;
        else if(posicao.equals("2"))
            tabuleiro[0][1] = jogador;
        else if(posicao.equals("3"))
            tabuleiro[0][2] = jogador;
        else if(posicao.equals("4"))
            tabuleiro[1][0] = jogador;
        else if(posicao.equals("5"))
            tabuleiro[1][1] = jogador;
        else if(posicao.equals("6"))
            tabuleiro[1][2] = jogador;
        else if(posicao.equals("7"))
            tabuleiro[2][0] = jogador;
        else if(posicao.equals("8"))
            tabuleiro[2][1] = jogador;
        else
            tabuleiro[2][2] = jogador;

    }

    public String ganhador(int jogadas) {
        String[] vetor = new String[8];
        String ganhador = "null";

        if (jogadas == 9) {
            ganhador = "Deu Velha!";
        }
        vetor[0] = tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2];
        vetor[1] = tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2];
        vetor[2] = tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2];
        vetor[3] = tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0];
        vetor[4] = tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1];
        vetor[5] = tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2];
        vetor[6] = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        vetor[7] = tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals("XXX")) {
                ganhador = "Jogador 1";
            } else if (vetor[i].equals("OOO")) {
                ganhador = "Jogador 2";
            }
        }
        return ganhador;
    }
}