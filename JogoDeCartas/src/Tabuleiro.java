public class Tabuleiro {
    //criação da matriz

    int tabuleiro[][] = new int[5][5];

  
    public void setTabuleiro(int linha , int coluna, int valor){
        this.tabuleiro[linha][coluna] = valor;
    }

    public void zerarTabuleiro(int linha, int coluna){
        this.tabuleiro[linha][coluna] = 0;
    }

    
    public void ImpressaoTabuleiro(){
        for (int linha = 0; linha < tabuleiro.length ; linha++) {
            for (int coluna = 0; coluna < tabuleiro[linha].length ; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + "   ");
            }
            System.out.println();
        }
    }

}
