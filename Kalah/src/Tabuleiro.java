public class Tabuleiro {
    
    private int[] board;

    public Tabuleiro(){
        this.board = new int[14];
    }

    public void inicializaTabuleiro(){
        for(int i = 0; i<14; i++){
            this.board[i] = 4;
        }
        this.board[6]=0; //silo do jogador 1
        this.board[13]=0; // silo do jogador 2
        
    }

    public void mostrarTabuleiro(){
        System.out.print("     ");
        for(int i = 5;i>=0;i--){  //imprime as cavas do jogador 1
            System.out.print("|"+board[i]+" ");
        }
        System.out.println("|");
        System.out.print(" (" + board[6] + ")");  //imprime silo do jogador 1
        System.out.print("-----------------------");
        System.out.println("(" + board[13] + ")");  //imprime silo do jogador 2
        System.out.print("     ");
        for(int x = 7; x<13 ; x++ ){  //imprime as cavas do jogador 1

            System.out.print("|"+board[x]+" ");
        }
        System.out.println("|");
        
    }

    public boolean semear (int x, boolean vez, Jogador j1, Jogador j2){

        boolean repeteVez=false;
        int sementes = board[x];
        board[x] = 0;   // retira todas as sementes da cava escolhida
        int aux = x;

        if(vez == true){

            for(int i = sementes; i>0; i--){  //distribui de acordo com a quantidade de sementes

                if(aux == 12){ //não deixa depositar sementes no silo do adversário 
                    aux = -1;
                }

                aux +=1;  
                board[aux] +=1;
                if(aux == 6){
                    j1.setPontos(j1.getPontos() + 1); //incrementa os pontos do jogador
                }

                if(i==1){  //na ultima iterção verifica se rouba sementes do adversário
                    CavaVazia(aux,vez);
                }
                
            }
        }else{
            for(int i = sementes; i>0; i--){  //distribui de acordo com a quantidade de sementes

                if(aux == 13){  //reseta a contagem do tabuleiro
                    aux = -1;
                }

                aux +=1;
                board[aux] +=1;

                if(aux == 13){  //incrementa os pontos do jogador
                    j2.setPontos(j2.getPontos() + 1);
                }

                if(i==1){  //na ultima iterção verifica se rouba sementes do adversário
                    CavaVazia(aux,vez);    
                }
                if(aux == 5){  //não deixa depositar sementes no silo adversário
                    aux = 6;
                }
            }
        }

        //verifica caso a ultima semente tenha caido no silo do próprio jogador
        if(vez == true && aux == 6){  
            repeteVez = true;
        }else if(vez == false && aux == 13){
            repeteVez = true;
        }

        return repeteVez;

    }

    public boolean verificaFim(Jogador j1, Jogador j2){

        boolean fim=false;
        //verifica se o lado do jogador 1 esta vazio
        if(board[0]==0 && board[1]==0 && board[2]==0 && board[3]==0 && board[4]==0 && board[5]==0){  

            if(j1.getPontos()>j2.getPontos()){ //verifica quem ganhou
                System.out.println();
                System.out.println("parabens o jogador " + j1.getNome() + "GANHOUUUUUU !!!!!!!!!");
                System.out.println("o jogador possui " + j1.getPontos() + " pontos!!!!!!");
            }else if(j1.getPontos()==j2.getPontos()){ //verifica empate
                System.out.println();
                System.out.println("O jogo EMPATOU !!!!!!!!!");
                System.out.println("ambos os jogadores possuem " + j1.getPontos() + " pontos");
                System.out.println();
            }else{  
                System.out.println();
                System.out.println("parabens o jogador " + j2.getNome() + "GANHOUUUUUU !!!!!!!!!");
                System.out.println("o jogador possui " + j2.getPontos() + " pontos!!!!!!");
                System.out.println();
            }
        
        //verifica se o lado do jogador 1 esta vazio
        }else if(board[7]==0 && board[8]==0 && board[9]==0 && board[10]==0 && board[11]==0 && board[12]==0){

           if(j1.getPontos()>j2.getPontos()){ //verifica quem ganhou
                System.out.println();
                System.out.println("parabens o jogador " + j1.getNome() + "GANHOUUUUUU !!!!!!!!!");
                System.out.println("o jogador possui " + j1.getPontos() + " pontos!!!!!!");
            }else if(j1.getPontos()==j2.getPontos()){ //verifica empate
                System.out.println();
                System.out.println("O jogo EMPATOU !!!!!!!!!");
                System.out.println("ambos os jogadores possuem " + j1.getPontos() + " pontos");
                System.out.println();
            }else{  
                System.out.println();
                System.out.println("parabens o jogador " + j2.getNome() + "GANHOUUUUUU !!!!!!!!!");
                System.out.println("o jogador possui " + j2.getPontos() + " pontos!!!!!!");
                System.out.println();
            }
        }

        return fim;
    }

    public void CavaVazia(int cava, boolean vez){ 

        int aux = 0;
        //verifica se a situação é possivel
        if((vez == true && cava <=5) || (vez == false && cava >6 && cava<13)){  //faz a comparação para ver se a ultima semente caiu no lado correto do tabuleiro
            
           aux = 12-cava;  
            
            if(board[cava] == 1){ //caso a cava esteja vazia
                board[cava] = board[cava] + board[aux]; //incrementa na cava as sementes da cava oposta
                board[aux]=0;   //retira todas as sementes da cava oposta
            }

        }
        
    }

   

}


