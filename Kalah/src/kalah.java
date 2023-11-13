import java.util.Scanner;

public class kalah {

    Scanner scan = new Scanner(System.in);
    Tabuleiro tabuleiro;
    Jogador jogador1,jogador2;
    boolean vez,repeteVez,fim;  //boolean vez -> true = jogador1, false = jogador 2
    int opcao = 0;
    
    public kalah(){

        tabuleiro = new Tabuleiro();
        int cava = 0;

        vez = true;

        System.out.println();
        System.out.println("bem vindo ao jogo KALAH");
        System.out.println();
        System.out.println("digite o nome do jogador 1");
        jogador1 = new Jogador(scan.nextLine());
        System.out.println("digite o nome do jogador 2");
        jogador2 = new Jogador(scan.nextLine());

        tabuleiro.inicializaTabuleiro();
        tabuleiro.mostrarTabuleiro();
        System.out.println();

        while(opcao != 2){

            if(vez){
                System.out.println("vez do jogador: " + jogador1.getNome());
                System.out.println("opcões: ");
                System.out.println("- Escolher cava(digite entre 1-6)");
                System.out.println("- Sair do jogo(digite 10)");
                opcao = scan.nextInt();
                if (opcao != 10) {

                    cava = opcao;
                    repeteVez = tabuleiro.semear(cava-1,vez);
                    tabuleiro.mostrarTabuleiro();
                    System.out.println();
                    if(repeteVez == true){
                        System.out.println("parabens, voce pode jogar novamente");
                        repeteVez = false;
                        
                    }else{
                        vez = false;
                    }

                    if(tabuleiro.verificaFim(jogador2, jogador1)){
                        opcao = 10;
                    }
                       
                }
            }else{
                System.out.println("vez do jogador: " + jogador2.getNome());
                System.out.println("opcões: ");
                System.out.println("- Escolher cava(digite entre 1-6)");
                System.out.println("- Sair do jogo(digite 10)");
                opcao = scan.nextInt();
                if(opcao != 10){

                    cava = opcao;
                    repeteVez = tabuleiro.semear(cava+6,vez);
                    tabuleiro.mostrarTabuleiro();
                    System.out.println();
                    if(repeteVez == true){
                        System.out.println("parabens, voce pode jogar novamente");
                        repeteVez = false;
                        
                    }else{
                        vez = true;
                    }

                    if(tabuleiro.verificaFim(jogador1, jogador2)){
                        opcao = 10;
                    }

                }
            }


        }
        



    }

}
