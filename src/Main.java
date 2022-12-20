import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JogoDaVelha novoJogo = new JogoDaVelha();

        String posicao;

        int jogadas = 0;

        System.out.println("Jogo da Velha");
        novoJogo.exibirTabuleiro();

    }
}

class JogoDaVelha{

    String[][] tabuleiro = {{"1", "2", "3"},
                            {"4", "5", "6"},
                            {"7", "8", "9"}};

    public String exibirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("  " + tabuleiro[i][j]);
            }
            System.out.println("\n");
        }
        return null;
    }


    public void jogadas(String posicao, String jogador) {
        switch (posicao) {
            case "1":
                tabuleiro[0][0] = jogador;
            case "2":
                tabuleiro[0][1] = jogador;
            case "3":
                tabuleiro[0][2] = jogador;
            case "4":
                tabuleiro[1][0] = jogador;
            case "5":
                tabuleiro[1][1] = jogador;
            case "6":
                tabuleiro[1][2] = jogador;
            case "7":
                tabuleiro[2][0] = jogador;
            case "8":
                tabuleiro[2][1] = jogador;
            case "9":
                tabuleiro[2][2] = jogador;
            default:
                System.out.println("Opção inválida.");
        }
    }

}