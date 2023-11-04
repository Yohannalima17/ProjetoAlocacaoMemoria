package P3_SO;

import java.util.Random;

public class GeradorDeProcessos {
    private int idCounter = 1;
    private Random random = new Random();

    public Processo gerarProcessoAleatorio() {
        int tamanho = random.nextInt(41) + 10; // Tamanho entre 10 e 50
        Processo processo = new Processo(idCounter, tamanho);
        idCounter++;
        return processo;
    }
}