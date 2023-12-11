public class MaoJogadores {
    private int maoJogadores[][] = new int[6][12];
    private int monteJogadores [][] = new int[6][50];
    private int pontosTotais = 0;
    //Auxiliar para contagem
    private int ac = 0;

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

    public int getMonte(int jogador, int coluna){
        return monteJogadores[jogador][coluna];
    }

    public int pontuacao(int idJogador){
        pontosTotais = 0;
        for(int i = 0; i < 49; i++){
            pontosTotais++;
            ac = monteJogadores[idJogador][i];
            if(ac % 10 == 0){
                pontosTotais = pontosTotais + 2;
            }
            if(ac == 5 || ac == 15 || ac == 25 || ac == 35 || ac == 45 || ac == 65 || ac == 75 || ac == 85 || ac == 95 || ac == 105){
                pontosTotais++;
            }
            if(ac == 11 || ac == 22 || ac == 33 || ac == 44 || ac == 66 || ac == 77 || ac == 88 || ac == 99){
                pontosTotais = pontosTotais + 3;
            }
            if(ac == 5){
                pontosTotais = pontosTotais + 5;
            }

        }
        return pontosTotais;
    }
    
}
