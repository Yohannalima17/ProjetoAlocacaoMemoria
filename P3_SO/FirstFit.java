package P3_SO;

public class FirstFit implements AlgoritmoDeAlocacao {
    @Override
    public boolean alocar(Processo processo, Memoria memoria) {
        return memoria.alocar(processo);
    }
}