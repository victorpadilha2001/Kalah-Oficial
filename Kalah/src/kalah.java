import java.util.Scanner;

public class Kalah {

    Scanner scan = new Scanner(System.in);
    Tabuleiro tabuleiro;
    Jogador jogador1,jogador2;
    boolean vez,repeteVez,fim;  //boolean vez -> true = jogador1, false = jogador 2
    int opcao = 0;
    
    public Kalah() {

        tabuleiro = new Tabuleiro();
        int cava = 0;

        vez = true;

        System.out.println();
        System.out.println("bem vindo ao jogo KALAH !!!!!!");
        System.out.println();
        System.out.println("digite o nome do jogador 1");
        jogador1 = new Jogador(scan.nextLine()); //inicializa jogador 1
        System.out.println("digite o nome do jogador 2");
        jogador2 = new Jogador(scan.nextLine()); //inicializa jogador 2

        tabuleiro.inicializaTabuleiro();
        tabuleiro.mostrarTabuleiro();
        System.out.println();

        while (opcao != 10) {

            if (vez) {
                System.out.println();
                System.out.println();
                System.out.println("vez do jogador: " + jogador1.getNome());
                System.out.println("opcões: ");
                System.out.println("- Escolher cava(digite entre 1-6)");
                System.out.println("- Sair do jogo(digite 10)");
                opcao = scan.nextInt();  //recebe a opcçao do jogador 

                //não deixa a logica do jogo acontecer caso o jogador queria sair    
                if (opcao != 10) {

                    cava = opcao;
                    repeteVez = tabuleiro.semear(cava-1,vez,jogador1,jogador2);
                    System.out.println();
                    if (repeteVez == true) {  //verifica caso o jogador tenha o direito de repitir a jogada
                        System.out.println("parabens, voce pode jogar novamente");
                        repeteVez = false;
                        
                    } else {
                        vez = false;
                    }
                    System.out.println();
                    tabuleiro.mostrarTabuleiro();
                    System.out.println();

                    if (tabuleiro.verificaFim(jogador2, jogador1)) {  //verifica fim do jogo
                        opcao = 10;
                    }
                       
                }
            } else {
                System.out.println();
                System.out.println();
                System.out.println("vez do jogador: " + jogador2.getNome());
                System.out.println("opcões: ");
                System.out.println("- Escolher cava(digite entre 1-6)");
                System.out.println("- Sair do jogo(digite 10)");
                opcao = scan.nextInt();

                //não deixa a logica do jogo acontecer caso o jogador queria sair
                if (opcao != 10) {

                    cava = opcao;
                    repeteVez = tabuleiro.semear(cava+6,vez,jogador1,jogador2);
                    System.out.println();
                    if (repeteVez == true) {  //verifica caso o jogador tenha o direito de repitir a jogada
                        System.out.println("parabens, voce pode jogar novamente");
                        repeteVez = false;
                        
                    } else {
                        vez = true;
                    }
                    System.out.println();
                    tabuleiro.mostrarTabuleiro();
                    System.out.println();

                    if (tabuleiro.verificaFim(jogador1, jogador2)) {  //verifica fim do jogo
                        opcao = 10;
                    }
                }
            }
        }
    }
}
