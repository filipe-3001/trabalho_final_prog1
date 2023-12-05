import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Integer> cartas;

    public Baralho() {
        cartas = new ArrayList<>();// Criação do Baralho
        for (int i = 1; i <= 109; i++) {
            cartas.add(i);
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas); // Método Embaralhar
    }

    public int calcularPontos(int carta) {
        int pontos = 1; // Pontuação base é 1 ponto

        // Regra a
        if (carta % 10 == 5) {
            pontos++;
        }

        // Regra b
        if (carta % 10 == 0) {
            pontos += 2;
        }

        // Regra c
        if (temDigitosRepetidos(carta)) {
            pontos += 4;
        }

        return pontos;
    }

    private boolean temDigitosRepetidos(int carta) {
        String cartaStr = String.valueOf(carta);
        return cartaStr.length() == 2 && cartaStr.charAt(0) == cartaStr.charAt(1);
    }

    public int getCarta() {
        if (cartas.isEmpty()) {
            throw new IllegalStateException("O baralho está vazio. Não há mais cartas disponíveis.");
        }
        return cartas.remove(0);
    }


}