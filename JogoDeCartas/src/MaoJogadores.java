public class MaoJogadores {
    private int maoJogadores[][] = new int[6][12];
    private int monteJogadores [][] = new int[6][50];


    public void adicionarCarta(int jogador, int coluna, int carta){
        this.maoJogadores[jogador][coluna] = carta;
    }

    public void retirarCarta(int jogador, int coluna){
        this.maoJogadores[jogador][coluna] = 0;
    }

    public int getCartas(int jogador, int coluna){
        return maoJogadores[jogador][coluna];
    }

    public void adicionarCartaMonte(int jogador, int coluna, int carta){
        this.monteJogadores[jogador][coluna] = carta;
    }

    public void zerarMonte(int jogador, int coluna){
        this.monteJogadores[jogador][coluna] = 0;
    }
    
}
