import java.util.ArrayList;
import java.util.List;


public class Jogador {
    private List<String> nomes;

    public Jogador(int numJogadores, List<String> nomesJogadores) {
        if (numJogadores < 3 || numJogadores > 6 || nomesJogadores.size() != numJogadores) {
            throw new IllegalArgumentException("Número de jogadores inválido ou nomes insuficientes.");
        }

        nomes = new ArrayList<>(nomesJogadores);
    }

    //Método que faz print dos nomes dos jogadores no console e suas cartas
    public void mostrarJogador(int id) {
        System.out.print(nomes.get(id));
        //Precisa de um espaço em branco em baixo
    }
 

}
