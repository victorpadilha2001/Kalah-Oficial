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
        for(int i = 5;i>=0;i--){
            System.out.print(board[i]+" ");
        }
        System.out.println();
        System.out.print("(" + board[6] + ")");
        System.out.print("---------------");
        System.out.println("(" + board[13] + ")");
        System.out.print("     ");
        for(int x = 7; x<13 ; x++ ){

            System.out.print(board[x]+" ");
        }
        
    }

    public boolean semear (int x, boolean vez){

        boolean repeteVez=false;
        int sementes = board[x];
        board[x] = 0;
        int aux = x;

        if(vez == true){

            for(int i = sementes; i>0; i--){
                if(aux == 12){
                    aux = -1;
                }
                aux +=1;
                board[aux] +=1;
                if(i==1){
                    CavaVazia(aux,vez);
                }
                
            }
        }else{
            for(int i = sementes; i>0; i--){  //ja faz a verificação caso a semente caia no silo inimigo
                if(aux == 13){
                    aux = -1;
                }
                aux +=1;
                board[aux] +=1;
                if(i==0){
                    CavaVazia(aux,vez);    
                }
                if(aux == 5){
                    aux = 6;
                }
            }
        }

        if(vez = true && aux == 6){  
            repeteVez = true;
        }
        if(vez == false && aux == 13){
            repeteVez = true;
        }

        return repeteVez;

    }

    public boolean verificaFim(Jogador j1, Jogador j2){

        boolean fim=false;
        if(board[0]==0 && board[1]==0 && board[2]==0 && board[3]==0 && board[4]==0 && board[5]==0){
            System.out.println("parabens o jogador " + j1.getNome() + "GANHOUUUUUU !!!!!!!!!");
        }else if(board[7]==0 && board[8]==0 && board[9]==0 && board[10]==0 && board[11]==0 && board[12]==0){
            System.out.println("parabens o jogador " + j2.getNome() + "GANHOUUUUUU !!!!!!!!!");
        }

        return fim;
    }

    public void CavaVazia(int cava, boolean vez){  //nao esta funcionandoy

        boolean vazio = false;
        int aux = 0;
        if((vez == true && cava <=5) || (vez == false && cava >6)){

            switch (cava) {
                case 0:
                    aux = 12;
                    break;
                case 1:
                    aux = 11;
                    break;
                case 2:
                    aux = 10;
                    break;
                case 3:
                    aux = 9;
                    break;
                case 4:
                    aux = 8;
                    break;
                case 5:
                    aux = 7;
                    break;
                case 7:
                    aux = 5;
                    break;
                case 8:
                    aux = 4;
                    break;
                case 9:
                    aux = 3;
                    break;
                case 10:
                    aux = 2;
                    break;
                case 11:
                    aux = 1;
                    break;
                case 12:
                    aux = 0;
                    break;

                default:
                    break;
            }

        
            if(board[cava] == 1){
                board[cava] = board[cava] + board[aux];
                board[aux]=0;
                vazio = true;
            }

        }
        

    }


    public void funTeste(){

        board[5] = 9;
        board[0] = 0;
        board[1] = 0;
    }








}


