public class Jogador {
    
    private int pontos;
    private String nome;

    public Jogador(String nome){
        this.nome = nome;
        this.pontos = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }
    
}
