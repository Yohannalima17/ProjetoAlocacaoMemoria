package P3_SO;

import java.util.LinkedList;

public class Memoria {
    private int size;
    private LinkedList<Processo> processos;

    public Memoria(int size) {
        this.size = size;
        this.processos = new LinkedList<>();
    }

    public boolean alocar(Processo processo) {
        if (getEspacoLivre() >= processo.getTamanho()) {
            processos.add(processo);
            return true;
        }
        return false;
    }

    public void desalocar() {
        if (!processos.isEmpty()) {
            processos.removeFirst();
        }
    }

    public int getEspacoLivre() {
        int espacoUtilizado = processos.stream().mapToInt(Processo::getTamanho).sum();
        return size - espacoUtilizado;
    }

    public int getOcupacaoPorcentagem() {
        return (processos.stream().mapToInt(Processo::getTamanho).sum() * 100) / size;
    }
}